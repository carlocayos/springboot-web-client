package com.carlocayos.interceptors;

import com.carlocayos.model.DataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingInterceptor implements ClientHttpRequestInterceptor
{
    @Autowired
    private ObjectMapper mapper;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
            ClientHttpRequestExecution execution) throws IOException
    {
//        String reqBody = new String(body, "UTF-8").trim();
//        System.out.println(request);
//        System.out.println(reqBody);

        ClientHttpResponse response = execution.execute(request, body);

//        System.out.println(response);
        return response;
    }
}
