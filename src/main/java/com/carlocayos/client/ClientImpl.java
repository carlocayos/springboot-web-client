package com.carlocayos.client;

import com.carlocayos.model.DataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientImpl
{
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDTO getData(@RequestBody String body)
    {
        DataDTO dataDTO = restTemplate
                .postForObject("http://localhost:8080/dataloop", body, DataDTO.class);
        return dataDTO;
    }

    @RequestMapping(value = "/dataloop", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDTO getDataLocally(@RequestBody String body)
    {
        DataDTO dataDTO = new RestTemplate()
                .getForObject("http://localhost:8080/data.json", DataDTO.class);
        return dataDTO;
    }
}
