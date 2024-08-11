package com.yogoda.domain.product.entity;

import com.yogoda.domain.area.entity.Area;
import com.yogoda.domain.category.entity.Category;
import com.yogoda.domain.interestProduct.entity.InterestProduct;
import com.yogoda.domain.user.entity.User;
import com.yogoda.global.constant.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name="product")
public class Product extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	private String title;
	private String content;
	private String imagePath;
	private Long price;
	private String transactionPlace;
	private boolean transactionStatus;

	private LocalDateTime deletedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_id")
	@ToString.Exclude
	private Area area;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	@ToString.Exclude
	private Category category;

	@OneToMany(mappedBy = "product")
	@ToString.Exclude
	List<InterestProduct> interestProductList = new ArrayList<>();
}
