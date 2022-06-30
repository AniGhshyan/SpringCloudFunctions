package com.example.springcloudfunctions.service;

import com.example.springcloudfunctions.entity.Page;
import com.example.springcloudfunctions.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;


    public Page findById(int id) {
        return pageRepository.getById(id);
    }

    public List<Page> findAll() {
        return pageRepository.findAll();
    }


    public Optional<Page> findByLink(String link) {
        return pageRepository.findByLink(link);
    }

    public void savePage(Page page) {
        pageRepository.save(page);
    }
}
