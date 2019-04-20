package com.fanyi.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String KEY = "fanyi.com";

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // 使用 BCrypt 加密
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder); // 设置密码加密方式
        return authenticationProvider;
    }

    /**
     * 自定义配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/kindEditor/**").permitAll()
                .antMatchers("/filePlugin//**").permitAll()
                .antMatchers("/uploadFile/**").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/static/**").permitAll()
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/img/**").permitAll()
                .antMatchers("/font/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()

                .antMatchers("/admin/**").hasAnyRole("ADMIN", "USER") // 需要相应的角色才能访问
                .antMatchers("/user/**").hasAnyRole("ADMIN")
                .and()
                .formLogin()   //基于 Form 表单登录验证
                .loginPage("/login").failureUrl("/login-error")
                .defaultSuccessUrl("/admin")
                .and()
                .logout()
//                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .and().rememberMe().key(KEY) // 启用 remember me
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");  // 处理异常，拒绝访问就重定向到 403 页面
        http.csrf().ignoringAntMatchers("/h2-console/**"); // 禁用 H2 控制台的 CSRF 防护
        http.headers().frameOptions().sameOrigin(); // 允许来自同一来源的H2 控制台的请求
        http.csrf().disable(); //关闭csrf保护以实现get请求来logout
    }

    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
}
