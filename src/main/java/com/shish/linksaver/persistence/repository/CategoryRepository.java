package com.shish.linksaver.persistence.repository;

import com.shish.linksaver.persistence.entity.CategoryEntity;
import com.shish.linksaver.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    CategoryEntity findCategoryEntityByCategoryHeading(String category);

    List<CategoryEntity> findCategoryEntityByUserId(UserEntity user);

    CategoryEntity findCategoryEntityByCategoryHeadingAndAndUserId(String category,UserEntity user);

}
