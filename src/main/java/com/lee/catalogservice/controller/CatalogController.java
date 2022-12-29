package com.lee.catalogservice.controller;

import com.lee.catalogservice.domain.CatalogEntity;
import com.lee.catalogservice.service.CatalogService;
import com.lee.catalogservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CatalogController {

    private final CatalogService catalogService;
    private final Environment env;

    @GetMapping("/health-check")
    public String status(){
        return String.format("It's Working in Catalog Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs(){
        List<CatalogEntity> catalogList = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = catalogList.stream().map(ResponseCatalog::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
