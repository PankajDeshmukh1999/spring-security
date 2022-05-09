package com.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/savaData",
						 "/SaveAllData",
						 "/getDataById/{empId}",
						 "/updateData/{cId}",
						 "/deleteDataById/{cId}",
						 "/deleteAllData").hasAnyRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pankaj").password(this.passwordEncoder().encode("pankaj")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("customer").password((this.passwordEncoder().encode("password"))).roles("CUSTOMER");
	}
	
	//Role= high level overview CUSTOMER-> Read data only 
	//							ADMIN ->   read and Write ,update
	
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return  new BCryptPasswordEncoder(10);
	}
}
