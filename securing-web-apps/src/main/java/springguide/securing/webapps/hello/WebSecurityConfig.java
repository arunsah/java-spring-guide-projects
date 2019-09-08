package springguide.securing.webapps.hello;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import springguide.securing.webapps.usersecurity.AppAuthenticationEntryPoint;
import springguide.securing.webapps.usersecurity.MyAppUserDetailsService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	DataSource dataSource;
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	// enable jdbc authentication
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.passwordEncoder(passwordEncoder());
//	}
	
	
//	@Bean
//	public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception{
//		JdbcUserDetailsManager manager=new JdbcUserDetailsManager();
//		((JdbcDaoSupport) manager).setDataSource(dataSource);
//		return manager;
//	}
	
	@Autowired
	private MyAppUserDetailsService  myAppUserDetailsService;
	
	@Autowired
	private AppAuthenticationEntryPoint appAuthenticationEntryPoint;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll().and().formLogin()
				.loginPage("/register").permitAll();

	}

	/*
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}
	
	*/
	
	
}
