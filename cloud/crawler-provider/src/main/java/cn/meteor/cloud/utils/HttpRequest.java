package cn.meteor.cloud.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequest {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private String url;
    private String method;
    private String data;
    private String charset = "UTF-8";
    
    public HttpRequest(String url) {
        this.url = url;
    }
    
    public HttpRequest(String url, String charset) {
        this.url = url;
        this.charset = charset;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String request() {
        String result = "";
        
        CloseableHttpClient client = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        InputStream is = null;
        CloseableHttpResponse response = null;
        HttpRequestBase http = null;
        
        try {
            client = HttpClientBuilder.create().build();
            if ("POST".equals(method) || null != data) {
                http = new HttpPost(url);
                if (null != data) {
                    ((HttpPost) http).setEntity(new StringEntity(data, "UTF-8"));
                }
            } else if ("GET".equals(method)) {
                http = new HttpGet(url);
            }
            
            StringBuffer sb = new StringBuffer();
            response = client.execute(http);
            
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            isr = new InputStreamReader(is, charset);
            br = new BufferedReader(isr);
            
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            
            result = sb.toString();
        } catch (Exception e) {
            LOG.error("client execute exception{}", e);
        	e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                
                if (isr != null) {
                    isr.close();
                }
                
                if (is != null) {
                    is.close();
                }
                
                if (http != null) {
                    http.releaseConnection();
                }
                
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                LOG.error("client execute exception{}", e);
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
}
