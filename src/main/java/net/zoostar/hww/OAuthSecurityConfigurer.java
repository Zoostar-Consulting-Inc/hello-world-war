package net.zoostar.hww;
 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class OAuthSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("{}", "Configuring OAuth Security...");
		http.authorizeRequests().antMatchers("/api/**").hasRole("USER").anyRequest().authenticated().and().csrf()
				.disable().oauth2Login();
	}

}
