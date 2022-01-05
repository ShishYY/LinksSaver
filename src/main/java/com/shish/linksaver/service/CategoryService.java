package com.shish.linksaver.service;

import com.shish.linksaver.model.CategoryDTO;
import com.shish.linksaver.persistence.entity.CategoryEntity;
import com.shish.linksaver.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addcategory(CategoryDTO category){

        CategoryEntity categorytemp = new CategoryEntity();

        categorytemp.setCategoryHeading(category.getCategory());

    }

}
