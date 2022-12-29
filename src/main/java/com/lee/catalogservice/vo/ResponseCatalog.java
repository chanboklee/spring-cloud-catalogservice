package com.lee.catalogservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lee.catalogservice.domain.CatalogEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private LocalDateTime createdAt;

    public ResponseCatalog(CatalogEntity catalogEntity){
        this.productId = catalogEntity.getProductId();
        this.productName = catalogEntity.getProductName();
        this.unitPrice = catalogEntity.getUnitPrice();
        this.stock = catalogEntity.getStock();
        this.createdAt = catalogEntity.getCreateAt();
    }
}
