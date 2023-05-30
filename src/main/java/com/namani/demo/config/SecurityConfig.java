package com.namani.demo.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated() // 어떠한 요청이라도 인증 필요
                )
                .formLogin(login -> login   // form 방식 로그인 사용
                        .defaultSuccessUrl("/test/api/swagger1", true)  // 성공 시 swagger1로
                        .permitAll()    // // swagger1 이동이 막히면 안되므로 얘는 허용
                )
                .logout(withDefaults());    // 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build();
    }
}
