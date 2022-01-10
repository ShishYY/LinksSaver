package com.shish.linksaver.persistence.repository;

import com.shish.linksaver.persistence.entity.CategoryEntity;
import com.shish.linksaver.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    CategoryEntity findCategoryEntityByCategoryHeading(String category);

    List<CategoryEntity> findCategoryEntityByUserId(UserEntity user);

}
