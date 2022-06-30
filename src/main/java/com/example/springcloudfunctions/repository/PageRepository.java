package com.example.springcloudfunctions.repository;

import com.example.springcloudfunctions.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepository extends JpaRepository<Page,Integer> {
    Optional<Page> findByLink(String link);
}
