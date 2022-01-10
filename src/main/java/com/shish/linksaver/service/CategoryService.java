package com.shish.linksaver.service;

import com.shish.linksaver.model.dto.CategoryDto;
import com.shish.linksaver.model.dto.ResponseDto;
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

    public ResponseDto addCategory (CategoryDto category) {

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
        return new ResponseDto("Category successfully added");
    }

    public ResponseDto deleteCategory (CategoryDto category){
        UserEntity user = userRepository.findByEmail(category.getEmail());
        CategoryEntity tempCategorydelete = categoryRepository.findCategoryEntityByCategoryHeadingAndAndUserId(category.getLinkCategory(),user);
        if (tempCategorydelete.getId() != null) { //Добавить правильную проверку на существование данной категории.Или фронт будет проверять?
        categoryRepository.deleteById(tempCategorydelete.getId());
        return new ResponseDto("Successfully delete category");
        }
        throw new RuntimeException("Dont have this category");
    }
}


