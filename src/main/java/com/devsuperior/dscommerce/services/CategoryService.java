package com.devsuperior.dscommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.DTO.CategoryDTO;
import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> result = categoryRepository.findAll();
		return result.stream().map(x->new CategoryDTO(x)).collect(Collectors.toList());
	}


}