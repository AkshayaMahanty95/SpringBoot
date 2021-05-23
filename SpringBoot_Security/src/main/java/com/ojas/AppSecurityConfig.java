package com.ojas;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//4.Oauth2----------------------------------------------------------------------------------
//	
//	//user defile login page
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http
//				.csrf().disable()
//				.authorizeRequests().antMatchers("/login").permitAll()
//				.anyRequest().authenticated();
//				
//		}
//	
//	
	
/*	
	
//2.start---------------------------------------------------------------------------------------------------	
	//Database through login
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		//Bcrypt password
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		//plain password
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
//2.end	-----------------------------------------------------------------------------------------------------
	
//3.-------------here use 2,3-------------------------------------------------------------------------------------
	
	//user defile login page
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login").permitAll();
	}
	
//3.end---------------------------------------------------------------------------------------------------------
	
//1.//--------------------------------------------------------------------------------------	
	//userdetail method 
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder()
				.username("akshaya")
				.password("1234")
				.roles("USER")
				.build());
	}

//1.end----------------------------------------------------------------------------------------
 * 
 * 
 */
	
	
}
