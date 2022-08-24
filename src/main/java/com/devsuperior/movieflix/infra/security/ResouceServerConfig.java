package com.devsuperior.movieflix.infra.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] PUBLIC = { "/oauth/token" };
    private static final String[] VISITOR_OR_MEMBER = { "/movies/**", "/genres/**" };
    private static final String[] MEMBER = { "/movies/**", "/genres/**", "/reviews/**" };

    private final JwtTokenStore jwtTokenStore;

    public ResouceServerConfig(JwtTokenStore jwtTokenStore) {
        this.jwtTokenStore = jwtTokenStore;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(auth -> auth
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, VISITOR_OR_MEMBER).hasAnyRole("VISITOR", "MEMBER")
                .antMatchers(MEMBER).hasRole("MEMBER")
                .anyRequest().hasRole("ADMIN"));
    }

}
