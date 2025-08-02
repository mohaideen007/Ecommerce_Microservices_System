package cart_service.Config;

import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.convert.converter.Converter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class secureConfig {


   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
            );
        return http.build();
    }

    // @Bean
    // public JwtDecoder jwtDecoder() {
    //     String secret = "gRW3U8nCU/6X9O7NVDEc9pDP5hW5L7LQmdV4B4WzRRA=";
    //     byte[] keyBytes = Base64.getDecoder().decode(secret);
    //     SecretKeySpec key = new SecretKeySpec(keyBytes, "HmacSHA256");
    //     return NimbusJwtDecoder.withSecretKey(key).build();
    // }

    // private JwtAuthenticationConverter jwtAuthenticationConverter() {
    //     JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
    //     converter.setAuthorityPrefix("ROLE_");           // So "USER" becomes "ROLE_USER"
    //     converter.setAuthoritiesClaimName("scope");      // extract from "scope"

    //     JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
    //     jwtConverter.setJwtGrantedAuthoritiesConverter(converter);
    //     return jwtConverter;
    // }


    @Bean
    public JwtDecoder jwtDecoder() {
       String secretKey="gRW3U8nCU/6X9O7NVDEc9pDP5hW5L7LQmdV4B4WzRRA=";
       byte[]keybytes=Base64.getDecoder().decode(secretKey);
       SecretKeySpec key = new SecretKeySpec(keybytes, "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(key).build();

}


      @Bean
      public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();

        converter.setAuthorityPrefix("ROLE_");
        converter.setAuthoritiesClaimName("scope");
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(converter);
        return jwtConverter;
        
      }
        

@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	
	}






}
