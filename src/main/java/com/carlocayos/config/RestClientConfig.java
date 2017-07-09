package com.carlocayos.config;

import com.carlocayos.interceptors.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestClientConfig
{
    @Autowired
    private LoggingInterceptor loggingInterceptor;

    @Value("${sample.username}")
    private String userName;

    @Value("${sample.password}")
    private String password;

    @Bean
    public RestTemplate createRestTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

        interceptors.add(new BasicAuthorizationInterceptor(userName, password));
        interceptors.add(loggingInterceptor);

        return restTemplate;
    }
}


