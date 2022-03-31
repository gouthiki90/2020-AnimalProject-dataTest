package site.metacoding.animalsapitest.domain.sigungu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalsapitest.domain.sigungu.Sido.Response.Body.Items.Item;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final SidoService service;


    @GetMapping("/")
    public String Download(SidoDto sidoDto, Model model) {

        List<SidoDto> sidoEntity = service.dowonload(sidoDto); // 서비스 하기

        System.out.println("받은 entity = " + sidoEntity);

        model.addAttribute("list", sidoEntity); // 모델에 담기

        return "/sidoDownload";
    }

    @GetMapping("/rest")
    public String test() {

        try {
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
            URI uri = new URI(
                    "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?serviceKey=" + key
                            + "&numOfRows=3&pageNo=1&_type=json");
            RestTemplate restTemplate = new RestTemplate();

            Sido[] response = restTemplate.getForObject(uri, Sido[].class);

            System.out.println(response);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
