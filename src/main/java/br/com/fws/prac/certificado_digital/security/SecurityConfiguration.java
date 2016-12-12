package br.com.fws.prac.certificado_digital.security;

import br.com.fws.prac.certificado_digital.repositories.AdminLoginRepository;
import br.com.fws.prac.certificado_digital.repositories.CompanyLoginRepository;
import br.com.fws.prac.certificado_digital.security.provider.CompanyProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by nando on 02/12/16.
 */
@EnableWebSecurity
public class SecurityConfiguration {

    @Configuration
    @Order(1)
    public static class ClientSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private CompanyLoginRepository companyLoginRepository;

        @Autowired
        private CompanyProvider companyProvider;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            int umDia = 86400;
            http

                    .authenticationProvider(companyProvider)
                    .authorizeRequests()
                        .antMatchers("/companies/form/**").permitAll()
                        .antMatchers("/companies/activation/**").permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                        .formLogin()
                            .usernameParameter("companyRegistration")
                            .loginPage("/login")
                            .defaultSuccessUrl("/certificates")
                            .permitAll()
                    .and()
                        .logout()
                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                            .logoutSuccessUrl("/login").permitAll()
                    .and()
                        .rememberMe()
                            .tokenValiditySeconds(umDia);



        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/assets/**");
        }
    }

    @Configuration
    public static class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private AdminLoginRepository adminLoginRepository;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

        }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(adminLoginRepository).passwordEncoder(new BCryptPasswordEncoder());
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/assets/**");
        }
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .addFilterBefore(new UserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
////                .addFilterBefore(new AdminAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
////                .authenticationProvider(new UserAuthenticationProvider())
////                .authenticationProvider(new AdminAuthenticationProvider())
////
////                .csrf().and()
////                .authorizeRequests()
////                .anyRequest()
////                .fullyAuthenticated().and()
////                .httpBasic();
//
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        //FIXME: Configure two security auth mechanism
//        //http://stackoverflow.com/questions/25794680/multiple-authentication-mechanisms-in-a-single-app-using-java-config
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/assets/**");
//    }
}
