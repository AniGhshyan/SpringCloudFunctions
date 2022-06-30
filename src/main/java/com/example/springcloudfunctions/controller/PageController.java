package com.example.springcloudfunctions.controller;

import com.example.springcloudfunctions.dto.PageDto;
import com.example.springcloudfunctions.entity.Page;
import com.example.springcloudfunctions.service.PageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;
    private final ModelMapper modelMapper;


    @PostMapping("/pages")
    public ResponseEntity<PageDto> savePage(@RequestBody PageDto pageRequest) {
        Page page = modelMapper.map(pageRequest, Page.class);
        if (pageService.findByLink(pageRequest.getLink()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        pageService.savePage(page);
        return ResponseEntity.ok(modelMapper.map(page, PageDto.class));
    }

    @GetMapping("/pages")
    public List<PageDto> getPages() {
        List<PageDto> result = new ArrayList<>();
        for (Page page : pageService.findAll()) {
            result.add(modelMapper.map(page, PageDto.class));
        }
        return result;
    }
}
