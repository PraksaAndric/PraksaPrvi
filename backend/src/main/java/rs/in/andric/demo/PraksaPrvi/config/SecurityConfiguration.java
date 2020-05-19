package rs.in.andric.demo.PraksaPrvi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import rs.in.andric.demo.PraksaPrvi.repository.UserRepository;
import rs.in.andric.demo.PraksaPrvi.service.MyUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(); //za povezivanje za frontendom
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/news/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();

    }

    @Bean
    public PasswordEncoder encodePWD() {

        return NoOpPasswordEncoder.getInstance();

    }


}
