package com.yogoda.domain.user.entity;

import com.yogoda.domain.area.entity.Area;
import com.yogoda.domain.interestProduct.entity.InterestProduct;
import com.yogoda.domain.product.entity.Product;
import com.yogoda.global.constant.BaseEntity;
import com.yogoda.global.status.UserStatusCode;
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
@ToString
@Table(name = "user")
public class User extends BaseEntity implements UserStatusCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(unique = true)
	private String email;
	private String password;
	private String userName;

	@Column(unique = true)
	private String phone;
	private boolean isAdmin;
	private String status;

	@Column(unique = true)
	private String emailAuthKey;
	private boolean admin;

	private LocalDateTime deletedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_id")
	@ToString.Exclude
	private Area area;

	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	List<InterestProduct> interestProductList = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	List<Product> productList = new ArrayList<>();
}
