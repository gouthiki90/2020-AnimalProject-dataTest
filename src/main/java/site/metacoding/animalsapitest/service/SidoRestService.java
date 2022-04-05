package site.metacoding.animalsapitest.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalsapitest.domain.sidorest.SidoRestDto;
import site.metacoding.animalsapitest.domain.sidorest.SidoResponseDto;
import site.metacoding.animalsapitest.domain.sidorest.SidoRestRepository;

@RequiredArgsConstructor
@Service
public class SidoRestService {

    private final SidoRestRepository repository;

    public List<SidoRestDto> 다운로드(SidoRestDto sidoRestDto) {
        List<SidoRestDto> lists = new ArrayList<>();

        try {
            String key = "jDqHGG%2BaNG47ijh6s3XzB%2BuF8fJOeovccnw%2FZtc9wLQUaKJumPo%2Frl1a2ygZ68dv9L0PD7drvpjPAeTnnB9f%2FQ%3D%3D";
            URI uri = new URI(
                    "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?serviceKey=" + key
                            + "&numOfRows=3&pageNo=1&_type=JSON");
            RestTemplate restTemplate = new RestTemplate();

            SidoResponseDto response = restTemplate.getForObject(uri, SidoResponseDto.class);

            System.out.println(response);

            List<SidoResponseDto> sidoList = new ArrayList<>();

            sidoList.add(response);

            System.out.println(sidoList);

            for (int i = 0; i < sidoList.size(); i++) {
                SidoRestDto result = new SidoRestDto(i,
                        sidoList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgCd(),
                        sidoList.get(i).getResponse().getBody().getItems().getItem().get(i).getOrgdownNm());

                lists.add(result);
            }

            System.out.println(lists);

            List<SidoRestDto> sidoEntity = repository.saveAll(lists);

            return sidoEntity;

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
       
    }

}
