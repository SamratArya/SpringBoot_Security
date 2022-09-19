package com.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

//HERE WE ARE CREATED CUSTOM USERNAME AND PASSWORD FOR AUTHENTICATING THE REQUEST

@Configuration
@EnableWebSecurity
public class CustomSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//ROLE BASED AUTHENTICATION --- HERE WHILE PROVIDING ROLE IT CAN ACCESS ONLY THOSE PROVIDED URL.
		//ROLE: NORMAL ->  READ
		//ROLE: ADMIN  ->  READ , WRITE , UPDATE

		http
		//WHILE DISABLE THIS IT WILL ALLOW USER TO READ , WRITE AND EXECUTE THE DATA
//		.csrf().disable()
		//HERE IT WILL CREATE A TOKEN TO VERIFY THE USER
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.antMatchers("/home" , "/login" , "/register").hasRole("NORMAL")
		.antMatchers("/user/**").hasRole("ADMIN")	
		.antMatchers("/singin").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		//FORM BASED AUTHENTICATION
		.formLogin()
		//FOR CHANGING THE URL (FOR NOW OUR CONFIGUATION STARTS FROM SIGNIN PAGE)
		.loginPage("/signin")
		//HERE IT WILL REDIRECT TO THE DOLOGIN PAGE
		.loginProcessingUrl("/doLogin")
		.defaultSuccessUrl("/user");
//		.httpBasic();

	}

	// FOR PLAIN TEXT ENCODING------------------------------------------

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//	    // INMEMORYAUTHENTICATION IS USED TO STORE THE VALUE AS TEMPORARY
//		auth.inMemoryAuthentication().withUser("amit123").password("4582").roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("arya456").password("9876").roles("ADMIN");
//
//	}
//
//	// IF PASSWORD IS IN PLAIN TEXT,WE ARE USING THIS PLAIN PASSWORD AS A PASSWORD
//	// ENCODER
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}

	// FOR ENCODING WITH METHOD-----------------------------------------

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// PASSWORDENCODER WILL ENCODE TO PASSWORD
		// INMEMORYAUTHENTICATION IS USED TO STORE THE VALUE AS TEMPORARY
		auth.inMemoryAuthentication().withUser("amit123").password(this.passwordEncoder().encode("4582"))
				.roles("NORMAL");
		auth.inMemoryAuthentication().withUser("arya456").password(this.passwordEncoder().encode("9876"))
				.roles("ADMIN");

	}

	// FOR ENCODING THE PASSWORD WHILE USING BCRYPTPASSWORDENCODER
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
