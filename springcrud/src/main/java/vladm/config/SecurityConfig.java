package vladm.config;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vladm.model.Roles;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/").hasAnyRole(Roles.Admin.name(), Roles.User.name())
                .antMatchers("/main").hasAnyRole(Roles.Admin.name(), Roles.User.name())
                .antMatchers("/employees").hasAnyRole(Roles.Admin.name(), Roles.User.name())
                .antMatchers("/statuses").hasAnyRole(Roles.Admin.name(), Roles.User.name())
                .antMatchers("/employees/**").hasRole(Roles.Admin.name())
                .antMatchers("/statuses/**").hasRole(Roles.Admin.name())
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth").permitAll().defaultSuccessUrl("/main")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .invalidateHttpSession(true).clearAuthentication(true)
                .logoutSuccessUrl("/auth");
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(getEncoder().encode("admin"))
                        .roles(Roles.Admin.name())
                        .build(),
                User.builder()
                        .username("user")
                        .password(getEncoder().encode("user"))
                        .roles(Roles.User.name())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
