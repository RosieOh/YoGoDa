package com.yogoda.domain.area.entity;

import com.yogoda.domain.product.entity.Product;
import com.yogoda.global.constant.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "area")
public class Area extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long id;

    private String sido;
    private String sigungu;
    private String sinlimdong;
    private double lat;
    private double lnt;

    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
   	@ToString.Exclude
   	private List<Product> productList = new ArrayList<>();
}
