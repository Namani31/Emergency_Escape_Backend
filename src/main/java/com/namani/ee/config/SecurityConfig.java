package com.namani.ee.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeHttpRequests()
                    .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .requestMatchers("/swagger-ui/*").permitAll()
                    .requestMatchers("/v3/api-docs").permitAll()
                    .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                    .anyRequest().permitAll();

        http.formLogin(login -> login   // form 방식 로그인 사용
                .successHandler((req, res, auth) -> res.setStatus(HttpStatus.OK.value()))
                .failureHandler((req, res, auth) -> res.setStatus(HttpStatus.FORBIDDEN.value()))
                    // .defaultSuccessUrl("/test/api/swagger1", true)  // 성공 시 swagger1로
                .permitAll());   // swagger1 이동이 막히면 안되므로 얘는 허용;

        http.logout(withDefaults());    // 로그아웃은 기본설정으로 (/logout 으로 인증해제)

        return http.build();
    }
}
