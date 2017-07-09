package com.carlocayos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootWebClientApplication
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = SpringApplication.run(SpringbootWebClientApplication.class, args);
    }
}
