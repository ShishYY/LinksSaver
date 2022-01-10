package com.shish.linksaver.service;

import com.shish.linksaver.model.CategoryDTO;
import com.shish.linksaver.model.ResponseDTO;
import com.shish.linksaver.persistence.entity.CategoryEntity;
import com.shish.linksaver.persistence.entity.UserEntity;
import com.shish.linksaver.persistence.repository.CategoryRepository;
import com.shish.linksaver.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    public CategoryService(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public ResponseDTO addCategory (CategoryDTO category) {

        UserEntity user = userRepository.findByEmail(category.getEmail());
        List<CategoryEntity> userCategoryList = categoryRepository.findCategoryEntityByUserId(user);

        boolean isContains = userCategoryList.stream().anyMatch(CategoryEntity ->
                CategoryEntity.getCategoryHeading().equals(category.getLinkCategory()));
        /*boolean IsContains = false;
        for (CategoryEntity categoryEntity : userCategoryList){
            isContains = categoryEntity.getCategoryHeading().equals(category.getCategory());
          Будет работать не правильно?  */
        if (isContains) {
            throw new RuntimeException("This category already exists");
        }
        categoryRepository.save(new CategoryEntity(category.getLinkCategory(), user));
        return new ResponseDTO("Category successfully added");
    }

    public ResponseDTO deleteCategory (CategoryDTO category){
        UserEntity user = userRepository.findByEmail(category.getEmail());
        CategoryEntity tempCategorydelete = categoryRepository.findCategoryEntityByCategoryHeadingAndAndUserId(category.getLinkCategory(),user);
        if (tempCategorydelete.getId() != null){ //Добавить правильную проверку на существование данной категории.Или фронт будет проверять?
        categoryRepository.deleteById(tempCategorydelete.getId());
        return new ResponseDTO("Successfully delete category");
        }
        throw new RuntimeException("Dont have this category");
    }
}


