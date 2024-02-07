package com.devsuperior.dscommerce.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dscommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	private Long id;
	@Size(min=3,max=80,message = "Nome precisa ter de 3 a 80 caracteres")
	@NotBlank(message = "Campo Requerido")
	private String name;
	@Size(min=10,message = "Descreição precisa ter no mínimo 10 caracteres")
	@NotBlank(message = "Campo Requerido")
	private String description;
	@Positive(message="O preço deve ser positivo")
	private Double price;
	private String imgUrl;
	@NotEmpty(message="Deve ter pelo menos uma categoria")
	private List<CategoryDTO> categories=new ArrayList<>();

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
		categories = entity.getCategories().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	public List<CategoryDTO> getCategories() {
		return categories;
	}
	

}
