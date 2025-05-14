package com.hzx.lesson.common.utils;

import com.hzx.lesson.common.exception.HttpException;
import com.hzx.lesson.common.exception.InternalServerErrorException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author shenzh
 */
@Service
public class HttpService {

    private static final Logger logger = LoggerFactory.getLogger(HttpService.class);
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient okHttpClient;

    @Autowired
    public HttpService(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return handleResponse(response);
        } catch (IOException e) {
            return "IO Error: " + e.getMessage();
        }
    }

    public String postJson(String url, String json) {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return handleResponse(response);
        } catch (IOException e) {
            throw new InternalServerErrorException("网络请求错误," + e.getMessage());
        }
    }

    private String handleResponse(Response response) throws IOException {
        if (!response.isSuccessful()) {
            String errorBody = response.body() != null ? response.body().string() : "Unknown error";
            logger.error("Request failed with status code: {} and body: {}", response.code(), errorBody);
            throw new HttpException(errorBody, "");
        }
        return response.body() != null ? response.body().string() : "";
    }
}
