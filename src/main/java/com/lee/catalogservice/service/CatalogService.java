package com.lee.catalogservice.service;

import com.lee.catalogservice.domain.CatalogEntity;

import java.util.List;

public interface CatalogService {
    List<CatalogEntity> getAllCatalogs();
}
