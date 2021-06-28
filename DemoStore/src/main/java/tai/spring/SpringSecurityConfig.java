package tai.spring;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		
//		auth.inMemoryAuthentication()
//			.passwordEncoder(pwdEncoder)
//			.withUser("andy")
//			.password(pwdEncoder.encode("abcd123"))
//			.roles("ADMIN")
//			.authorities("ROLE_USER")
//			.and()
//			.withUser("bob")
//			.password(pwdEncoder.encode("bob123"))
//			.roles("RD")
//			.authorities("ROLE_USER")
//			;
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username,password,enable from users where username=?")
			.authoritiesByUsernameQuery(
					"select username,role,groupid "
					+ "from users u join authorities a on u.user_no = a.user_no "
					+ "where u.username=?")
			.passwordEncoder(new BCryptPasswordEncoder())
			;
		
//		auth
//			.userDetailsService(userDetailsService)
//			.passwordEncoder(new BCryptPasswordEncoder())
//			;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/home").authenticated()
			.antMatchers("/").permitAll()
		.and()
			.formLogin()
			.loginPage("/index")
			.usernameParameter("username")
			.passwordParameter("userpwd")
			.loginProcessingUrl("/login.do")
			.defaultSuccessUrl("/login.success")
		.and()
			.logout()
			.logoutUrl("/login")
		;
	}
	
	
}
