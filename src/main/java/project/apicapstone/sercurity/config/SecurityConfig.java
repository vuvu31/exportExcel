package project.apicapstone.sercurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import project.apicapstone.sercurity.jwt.JwtAuthorizationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthorizationFilter jwtAuthorizationFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        http.cors().configurationSource(request -> configuration.applyPermitDefaultValues());

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable();

        //test
        //http.csrf().disable().cors().and().authorizeRequests().anyRequest().permitAll();

//        http.antMatcher("/**").authorizeRequests()
//                .antMatchers("/auth/login").permitAll()
//                //.antMatchers("/account/**").permitAll()
//                .antMatchers("/account/create-account").permitAll()
//                .anyRequest().authenticated();


        // cấu hình xác thực cho các api
//        http.antMatcher("/api/**").authorizeRequests()
//                .antMatchers("/api/user/create-user").permitAll()
//                .antMatchers("/api/auth/authenticate").permitAll()
//                .antMatchers("/api/user/getAll-user").permitAll()
//                .antMatchers("/api/user/add-role")..permitAll()
//                .antMatchers("/api/**").hasAnyRole("USER","ADMIN")
//                .anyRequest().authenticated();

//        http.antMatcher("/api/**").authorizeRequests()
//                //.antMatchers("/api/user/create-user", "/api/auth/authenticate", "/api/user/getAll-user", "/api/user/add-role").permitAll()
//                .antMatchers("/api/auth/authenticate").permitAll()
//                .antMatchers("/api/user/getAll-user").permitAll()
//                .antMatchers("/api/user/add-role").permitAll()
//                .antMatchers("/api/product/**").hasAnyRole("USER","ADMIN")
//                .anyRequest().authenticated();
    }
}
