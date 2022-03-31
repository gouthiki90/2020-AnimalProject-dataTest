package site.metacoding.animalsapitest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalsapitest.domain.sidodto.SidoDto;
import site.metacoding.animalsapitest.domain.sidodto.SidoService;

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


}
