
package com.gl.CollegeFest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gl.CollegeFest.service.UserService;

@Configuration
public class AppConfig {

	UserService service;

	public AppConfig(UserService service) {
		super();
		this.service = service;
	}

	@Bean
	public static BCryptPasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager  authenticationManager( AuthenticationConfiguration authenticationConfiguration ) {
		throws Exception {

			return  AuthenticationConfiguration.authenticationManager();


		}
		@Bean
		public SecurityFilterChain fileterChain(HttpSecurity http) throws Exception{

			http.authorizeHttpRequests(
					(configurer) -> configurer
					.requestMatchers("/registration/**").permitAll()
					.requestMatchers("/regsuccess/**").permitAll()
					.requestMatchers("/").hasAnyRole("User", "ADMIN")
					.requestMatchers("/students/list/").hasAnyRole("User", "ADMIN")
					.requestMatchers("/student/showstudentFormForAdd/**").hasAnyRole("User", "ADMIN")
					.requestMatchers("/books/savestudent/").hasAnyRole("User", "ADMIN")
					.requestMatchers("/students/delete/").hasAnyRole("User", "ADMIN")
					.requestMatchers("/student/studentFormForEdit/").hasAnyRole("User", "ADMIN")
					.anyRequest()
					.authenticated()

					)
			.formLogin(form)-->form.loginpage("/login").loginprocessingUrl("/authenticateTheUser").loginprocessingUrl("/authenticateTheUser")

			)
.logout(logout-->logout.permitAll())
.exceptionHandling(configurer->configurer.accessDeniedPage("/access-denied"));
return http.build();



		}
	}

}
