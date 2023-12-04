package com.sparta.myselectshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_folder")
public class ProductFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 원래 뒤가 one이면 LAZY 즉시로딩 필요할때만 조회하기 위함
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY) // 원래 뒤가 one이면 LAZY 즉시로딩
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    public ProductFolder(Product product, Folder folder) {
        this.product = product;
        this.folder = folder;
    }
}