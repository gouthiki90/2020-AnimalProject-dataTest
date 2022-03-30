package site.metacoding.animalsapitest.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import site.metacoding.animalsapitest.domain.sigungu.Sigungu;

@RestController
public class TestController {

    String responseJson = null;

    @GetMapping("/")
    public String Download() {

        try {

            StringBuffer sb = new StringBuffer();

            sb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/");
            sb.append("sido?serviceKey=");
            sb.append(
                    "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D&");
            sb.append("numOfRows=3&");
            sb.append("pageNo=1&");
            sb.append("_type=JSON");

            URL url = new URL(sb.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            Gson gson = new Gson();

            System.out.println(responseJson);

            while (true) {
                responseJson = br.readLine();

                if (responseJson == null) {
                    break;
                }

                System.out.println(responseJson);
              
            }

            Sigungu responseDto = gson.fromJson(responseJson, Sigungu.class);
            System.out.println(responseDto);

        } catch (Exception e) {
            System.out.println("실패" + e.getMessage());

        }

        return null;
    }

    @GetMapping("/rest")
    public String restDownload() {

        StringBuffer sb = new StringBuffer();

        sb.append("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/");
        sb.append("sido?serviceKey=");
        sb.append(
                "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D&");
        sb.append("numOfRows=3&");
        sb.append("pageNo=1&");
        sb.append("_type=JSON");

        System.out.println(sb.toString());

        RestTemplate rest = new RestTemplate();

        String response = rest.getForObject(
                sb.toString(),
                String.class);

                System.out.println(response);

        return response.toString();
    }
}
