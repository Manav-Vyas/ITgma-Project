package com.ITgma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@SuppressWarnings("deprecation")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String [] PUBLIC_URLS = {
			"/api/v1/auth/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
			};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("itgma@gmail.com").password("itgma@123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("itgmaUser@gmail.com").password("User@123").roles("USER");

	}

//	------------------------------- Security for all API ---------------------------

	
//	 @Override 
//	 protected void configure(HttpSecurity http) throws Exception {
//	 
//		 http.csrf().disable();
//		 http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//	 
//	 }
	 

//	------------------------------- Security based on URL ---------------------------

	
	 @Override 
	 protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
		 http.authorizeRequests().antMatchers("/favourites/**").fullyAuthenticated().
		 and().httpBasic(); 
		 
	 }
	 

//	------------------------------- Security based on ROLE ---------------------------

	
//	 @Override 
//	 protected void configure(HttpSecurity http) throws Exception {
//		 http.csrf().disable().logout()
//			.logoutUrl("/perform_logout")
//			.invalidateHttpSession(true)
//			.deleteCookies("JSESSIONID");
//		 http.authorizeRequests()
//		 .antMatchers("/favourites/**").hasAnyRole("ADMIN")
//		 .antMatchers("/countries/**").hasAnyRole("USER")
//		 .antMatchers(PUBLIC_URLS).permitAll()
//		 .antMatchers(HttpMethod.GET).permitAll()
//		 .anyRequest().fullyAuthenticated().and().exceptionHandling();
//	 }
	 
	 

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	 
}
