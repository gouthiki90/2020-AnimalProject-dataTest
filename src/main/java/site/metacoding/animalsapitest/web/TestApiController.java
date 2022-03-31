package site.metacoding.animalsapitest.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import site.metacoding.animalsapitest.domain.sido.Response;
import site.metacoding.animalsapitest.domain.sido.SidoResponseDto;

@RestController
public class TestApiController {

    @GetMapping("/rest")
    public void test() {

        try {
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
            URI uri = new URI(
                    "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?serviceKey=" + key
                            + "&numOfRows=3&pageNo=1&_type=JSON");
            RestTemplate restTemplate = new RestTemplate();

            SidoResponseDto response = restTemplate.getForObject(uri, SidoResponseDto.class);

            System.out.println(response);

            
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
