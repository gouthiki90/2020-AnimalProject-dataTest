package site.metacoding.animalsapitest.domain.sidodto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalsapitest.domain.sidodto.Sido.Response.Body.Items.Item;

@RequiredArgsConstructor
@Service
public class SidoService {

    private final SidoRepository repository;

    @Transactional
    public List<SidoDto> dowonload(SidoDto sidoDto) {

        List<SidoDto> sidoList = new ArrayList<>();

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

            StringBuilder responseJson = new StringBuilder();

            String response;
            while (true) {
                response = br.readLine();

                if (response == null) {
                    break;
                }
                responseJson = responseJson.append(response);
            }

            // System.out.println(responseJson);

            Gson gson = new Gson();
            Sido responseDto = gson.fromJson(responseJson.toString(), Sido.class);

            // System.out.println(responseDto);

            List<Item> result = responseDto.getResponse().getBody().getItems().getItem();
            // 다운로드 받은 것 result에 담기

            for (int i = 0; i < result.size(); i++) { // result 사이즈 만큼 
                SidoDto items = new SidoDto(i, result.get(i).getOrgCd(), result.get(i).getOrgdownNm());
                // Dto에 담기

                sidoList.add(items); // add 해서 담기
            }

            System.out.println("저장된 리스트" + sidoList);

        } catch (Exception e) {
            System.out.println("실패" + e.getMessage());

        }

        List<SidoDto> sidoEntity = repository.saveAll(sidoList); // Entity에 데이터 saveAll
        System.out.println("받은 entity = " + sidoEntity);
        return sidoEntity;

    }
}
