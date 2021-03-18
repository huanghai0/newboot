package com.example.newboot.utils.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class HttpClientUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    public static PoolingHttpClientConnectionManager cm = null;
    private static CloseableHttpClient httpClient = null;
    private static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";
    private static int DEFAULT_TIME_OUT = 30;
    private static int count = 32;
    private static int totalCount = 1000;
    private static int Http_Default_Keep_Time = 1500;

    private static synchronized void initPools() {
        if (httpClient == null) {
            cm = new PoolingHttpClientConnectionManager();
            cm.setDefaultMaxPerRoute(count);
            cm.setMaxTotal(totalCount);
            httpClient = HttpClients.custom().setKeepAliveStrategy(defaultStrategy).setConnectionManager(cm).build();
        }
    }

    public static ConnectionKeepAliveStrategy defaultStrategy = new ConnectionKeepAliveStrategy() {
        @Override
        public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
            HeaderElementIterator it = new BasicHeaderElementIterator(httpResponse.headerIterator(HTTP.CONN_KEEP_ALIVE));
            int keepTime = Http_Default_Keep_Time;
            while (it.hasNext()) {
                HeaderElement he = it.nextElement();
                String key = he.getName();
                String value = he.getValue();
                if (value != null && key.equalsIgnoreCase("timeout")) {
                    try {
                        return Long.parseLong(value) * 1000;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return keepTime;
        }
    };

    public static HttpRequestBase getRequest(String uri, String method, String contenType, int timeOut) {
        if (httpClient == null) {
            initPools();
        }
        HttpRequestBase request;
        if (timeOut < 0) {
            timeOut = DEFAULT_TIME_OUT;
        }
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(timeOut * 1000)
                .setConnectTimeout(timeOut * 10000)
                .setConnectionRequestTimeout(timeOut * 1000)
                .setExpectContinueEnabled(false).build();

        if (HttpPost.METHOD_NAME.equalsIgnoreCase(method)) {

            request = new HttpPost(uri);

        } else if (HttpGet.METHOD_NAME.equalsIgnoreCase(method)) {
            request = new HttpGet(uri);
        } else {
            request = new HttpPost(uri);
        }

        if (StringUtils.isBlank(contenType)) {
            contenType = DEFAULT_CONTENT_TYPE;
        }

        request.setConfig(config);
        request.addHeader("Content-Type", contenType);
        request.addHeader("Accept", "*/*");
        request.addHeader("connection", "Keep-Alive");
        return request;
    }

    public static String doGetJson(String url) {
        String result = "";
        InputStream content = null;
        CloseableHttpResponse response = null;
        try {
            HttpGet get = (HttpGet) getRequest(url, "get", null, -1);
            response = httpClient.execute(get);
            if (null != response && HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                content = response.getEntity().getContent();
                result = IOUtils.toString(content, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            logger.error("{}", e.getMessage(), e);
        } finally {
            try {
                if (null != content) {
                    content.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {

            }
        }
        return result;
    }


    public static String doPostJson(String url, JSONObject json) {
        String result = "";
        InputStream content = null;
        CloseableHttpResponse response = null;
        try {
            HttpPost post = (HttpPost) getRequest(url, "post", null, -1);
            post.setEntity(new StringEntity(json.toString(), ContentType.APPLICATION_JSON));
            response = httpClient.execute(post);
            if (null != response && HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                content = response.getEntity().getContent();
                result = IOUtils.toString(content, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            logger.error("{}", e.getMessage(), e);
        } finally {
            try {
                if (null != content) {
                    content.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {

            }
        }
        return result;
    }

    public static String doPostXml(String url, String xml) {
        String resultStr = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost post = (HttpPost) getRequest(url, "post", null, -1);
            post.addHeader("SOAPAction", "");
            StringEntity entity = new StringEntity(xml, Charset.forName("UTF-8"));
            post.setEntity(entity);
            response = httpClient.execute(post);
            int status = response.getStatusLine().getStatusCode();
            InputStream content = response.getEntity().getContent();
            if (status == 200) {
                resultStr = IOUtils.toString(content);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {

            }
        }
        return resultStr;
    }


    public static void setDefaultTimeOut(int defaultTimeOut) {
        DEFAULT_TIME_OUT = defaultTimeOut;
    }

    public static void setCount(int count) {
        HttpClientUtil.count = count;
    }

    public static void setTotalCount(int totalCount) {
        HttpClientUtil.totalCount = totalCount;
    }

    public static void setHttp_Default_Keep_Time(int http_Default_Keep_Time) {
        Http_Default_Keep_Time = http_Default_Keep_Time;
    }
}
