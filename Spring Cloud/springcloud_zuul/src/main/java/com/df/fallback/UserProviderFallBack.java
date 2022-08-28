package com.df.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Loser
 * @date 2021年11月16日 11:30
 */
@Component
public class UserProviderFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
        return "*"; //所有服务
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 返回相应的状态码：
             * zuul转请求失败了，但是客户端向zuul发送请求是成功的，所以不应该把404、500等问题抛给客户端
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 0;
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 返回托底数据
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                String msg = route + "服务不可用,出现了点小问题,请联系客服修复~";
                return new ByteArrayInputStream(msg.getBytes());
            }

            /**
             * 获取请求头
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
