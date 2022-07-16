import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class HttpExample {
    @Test
    public void httpExampleGetTest() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://yandex.ru/");
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void httpExamplePostTest() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://yandex.by/clck/click");
        httpPost.setHeader("Content-type", "text/html");
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            Assert.assertEquals(400, httpResponse.getStatusLine().getStatusCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
