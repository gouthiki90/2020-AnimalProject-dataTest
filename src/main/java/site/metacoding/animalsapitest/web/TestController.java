package site.metacoding.animalsapitest.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/")
    public String Download(){

        try {
            
        StringBuffer sb = new StringBuffer();

        sb.append("https://apis.data.go.kr/1543061/abandonmentPublicSrvc/");
        sb.append("sido?serviceKey=");
        sb.append("jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D&");
        sb.append("numOfRows=3&");
        sb.append("pageNo=1&");
        sb.append("_type=JSON");

        URL url = new URL(sb.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

        String responseJson = br.readLine();

        System.out.println(responseJson);
        // 다운받아 지는 지 확인부터

        } catch (Exception e) {
            System.out.println("실패" + e.getMessage());
            
        }



        return null;
    }
}
