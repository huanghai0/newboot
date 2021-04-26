package com.example.newboot.utils.http;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 *
 *
 * @author  may
 * @version V3.7.0
 */
//@Configuration
//public class CommonRestTemplateConfig {
//
//
//
//    @Value("${mgr.restTemplate.pool.size:5}")
//    private int poolSize;
//
//    @Value("${namelist.url:http://localhost:10021}")
//    private String namelistUrl;
//    @Value("${namelist.context-path:/rs/portal/}")
//    private String contextPath;
//    @Value("${namelist.username:admin}")
//    private String nlname;
//    @Value("${namelist.password:bangsun}")
//    private String nlpwd;
//
//
//    @Bean
//    public RestTemplate commonRestTemplate() {
//
//        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager();
//        connMgr.setMaxTotal(poolSize + 1);
//        connMgr.setDefaultMaxPerRoute(poolSize);
//
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setConnectionManager(connMgr).build();
//
//        List<HttpMessageConverter<?>> converters = init();
//
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        // 数据读取超时时间，即SocketTimeout
//        requestFactory.setReadTimeout(30000);
//        // 连接超时
//        requestFactory.setConnectTimeout(3000);
//        // 连接不够用的等待时间
//        requestFactory.setConnectionRequestTimeout(3000);
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        restTemplate.setMessageConverters(converters);
//
//        return restTemplate;
//    }
//
//    @Bean
//    @ConditionalOnProperty(prefix = "namelist", value = { "url", "username", "password" })
//    public RestTemplate namelistRestTemplate() throws URISyntaxException {
//        URI uri = new URI(namelistUrl + contextPath);
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(new AuthScope(uri.getHost(), uri.getPort()),
//                new UsernamePasswordCredentials(nlname, nlpwd));
//        HttpClient httpClient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider)
//                .setConnectionManager(new PoolingHttpClientConnectionManager()).build();
//
//        List<HttpMessageConverter<?>> converters = init();
//
//        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        restTemplate.setMessageConverters(converters);
//
//        return restTemplate;
//    }
//
//
//    private List<HttpMessageConverter<?>> init(){
//        FastJsonHttpMessageConverter fastjson = new FastJsonHttpMessageConverter();
//
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.BrowserCompatible, SerializerFeature.DisableCircularReferenceDetect);
//        fastjson.setFastJsonConfig(fastJsonConfig);
//
//        List<HttpMessageConverter<?>> messageConverters = Lists.newArrayListWithCapacity(1);
//        messageConverters.add(fastjson);
//
//        return messageConverters;
//    }
//
//
//}
