package br.com.maiawall.infra.config;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public FilterRegistrationBean<Filter> h2ConsoleFrameOptions() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>((request, response, chain) -> {
            if (response instanceof HttpServletResponse) {
                ((HttpServletResponse) response).setHeader("X-Frame-Options", "SAMEORIGIN");
            }
            chain.doFilter(request, response);
        });
        registration.addUrlPatterns("/h2-console/*");
        registration.setName("H2ConsoleFrameOptionsFilter");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }

}
