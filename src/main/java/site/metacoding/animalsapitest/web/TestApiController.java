package site.metacoding.animalsapitest.web;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalsapitest.domain.sidorest.SidoRestDto;
import site.metacoding.animalsapitest.service.SidoRestService;

@RequiredArgsConstructor
@RestController
public class TestApiController {

    private final SidoRestService service;

}
