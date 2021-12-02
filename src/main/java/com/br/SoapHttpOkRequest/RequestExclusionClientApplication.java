package com.br.SoapHttpOkRequest;

import com.br.SoapHttpOkRequest.service.HttpOkClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@SpringBootApplication
@Service
public class RequestExclusionClientApplication {

    public static void main(String[] args) throws IOException {

        log.info("[start] SoapHttpOkRequest - main");

        String url = "";
        String request = "";
        String mediaType = "text/xml"; // application/xml

        HttpOkClient httpOkClient = new HttpOkClient();
        httpOkClient.callApiPost(url, request, mediaType);
        log.info("[finish] SoapHttpOkRequest - main");

    }

}
