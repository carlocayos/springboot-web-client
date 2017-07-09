package com.carlocayos.error;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class ClientErrorHandler implements ResponseErrorHandler
{
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException
    {
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException
    {
    }
}
