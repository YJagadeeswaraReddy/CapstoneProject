package com.wipro.sfh.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private long id;
	private String productName;
	private BigDecimal productPrice;
	private Integer productStock;
	private String productDescription;
	private String category;
	
}
