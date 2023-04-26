package com.viniciussutil.myfirstproject.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity // define que a classe corresponde a uma entidade gerenciada pelo JPA
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id // indica que esse atributo da chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // será autoincrementável no banco
	private Long id;
	private String name;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Product() {
	}

	public Product(Long id, String name, Double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	

}