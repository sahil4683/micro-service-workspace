package com.mic;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDto {
//	private Long id;

	@NotBlank(message = "Name is required")
	private String name;

	@Positive(message = "Price must be positive")
	@Min(value = 1, message = "min value 1 > ")
	@Max(value = 10, message = "max value > 10")
	private double price;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
