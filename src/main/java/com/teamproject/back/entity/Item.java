package com.teamproject.back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Table(name = "item")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //****(1.17)******
    // int id -> Integer id

    private String itemName;

    private String itemDesc;

    private String itemImg;

    private int itemStock;

    private int itemSale;

    private int itemOriginPrice;

    private String itemBrand;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Cart> carts;

    //***1.20 추가***
    @OneToMany(mappedBy = "item",fetch = FetchType.LAZY)
    private List<Comment> comments;


    @Transient // 이 필드는 DB에 저장되지 않음
    private Integer averageRating;
}
