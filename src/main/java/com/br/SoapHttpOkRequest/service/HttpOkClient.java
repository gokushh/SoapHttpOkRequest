package com.br.SoapHttpOkRequest.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class HttpOkClient {

    private Long responseCode = 0L;
    private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void callApiPost(String url, Object requestBody, String mediaType) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient client = HttpOkConfiguration.getInstance();

        RequestBody body = RequestBody.create(objectMapper.writeValueAsString(requestBody), MediaType.parse(mediaType));

        System.out.println(objectMapper.writeValueAsString(requestBody));

        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .build();

        log.info(url);

        try (Response response = client.newCall(request).execute()) {
            log.info("http status: " + response.code());
            if (!response.isSuccessful())
                responseCode = Long.valueOf(response.code());
        } catch (Exception e) {
            log.error("Error", e);
            responseCode = 1L;
        }
    }

}
