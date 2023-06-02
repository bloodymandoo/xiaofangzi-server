package com.xiao.fang.zi.xiaofangziserver.util;

import com.google.common.base.Strings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    public static String sendPostDataByMap(String url, String token, Map<String, Object> map) throws IOException {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
        if(!Strings.isNullOrEmpty(token)){
            httpPost.setHeader("Authorization", token);
        }
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (HttpStatus.OK.value() == response.getStatusLine().getStatusCode()) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        response.close();
        return result;
    }

    public static String sendPostDataByJson(String url, String token,  String json) throws IOException {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);
        if(!Strings.isNullOrEmpty(token)){
            httpPost.setHeader("Authorization", token);
        }
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (HttpStatus.OK.value() == response.getStatusLine().getStatusCode()) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        response.close();
        return result;
    }

    public static String postMultipartFileUtil(MultipartFile file, String data, String url, HttpServletRequest request, HttpServletResponse response) {
        String result = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        try {
            builder.setCharset(Charset.forName("UTF-8")).addBinaryBody("file", file.getInputStream(), ContentType.MULTIPART_FORM_DATA, file.getOriginalFilename());
            HttpEntity httpEntity = builder.build();
            httpPost.setEntity(httpEntity);
            HttpResponse httpResponse = client.execute(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            if (responseEntity != null) { // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public static String sendGetData(String url, String token) throws IOException {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        if(!Strings.isNullOrEmpty(token)){
            httpGet.setHeader("Authorization", token);
        }
        httpGet.addHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (HttpStatus.OK.value() == response.getStatusLine().getStatusCode()) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        response.close();
        return result;
    }

}
