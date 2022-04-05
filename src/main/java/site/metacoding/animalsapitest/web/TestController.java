package site.metacoding.animalsapitest.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalsapitest.domain.sidodto.SidoDto;
import site.metacoding.animalsapitest.domain.sidodto.SidoService;
import site.metacoding.animalsapitest.domain.sidorest.SidoRestDto;
import site.metacoding.animalsapitest.service.SidoRestService;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final SidoService service;
    private final SidoRestService sRestService;


    @GetMapping("/")
    public String Download(SidoDto sidoDto, Model model) {

        List<SidoDto> sidoEntity = service.dowonload(sidoDto); // 서비스 하기

        System.out.println("받은 entity = " + sidoEntity);

        model.addAttribute("list", sidoEntity); // 모델에 담기

        return "/sidoDownload";
    }

    @GetMapping("/rest")
    public String restDownload(SidoRestDto sidoRestDto, Model model){

        List<SidoRestDto> sidoEntity = sRestService.다운로드(sidoRestDto);

        model.addAttribute("sidolist", sidoEntity);

        return "/sidoRestDownload";
    }

}
