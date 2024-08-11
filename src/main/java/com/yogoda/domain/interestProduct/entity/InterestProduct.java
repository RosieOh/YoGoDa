package com.yogoda.domain.interestProduct.entity;

import com.yogoda.domain.product.entity.Product;
import com.yogoda.domain.user.entity.User;
import com.yogoda.global.constant.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
	name="interest_product",
	uniqueConstraints={
		@UniqueConstraint(
			name="productId_userId_unique",
			columnNames={"product_id", "user_id"}
		)
	}
)
public class InterestProduct extends BaseEntity {
    @Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "interest_product_id")
   	private Long id;

   	@ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "user_id")
   	@ToString.Exclude
   	private User user;

   	@ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "product_id")
   	@ToString.Exclude
   	private Product product;
}
