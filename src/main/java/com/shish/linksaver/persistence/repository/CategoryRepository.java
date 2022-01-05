package com.shish.linksaver.persistence.repository;

import com.shish.linksaver.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository <CategoryEntity,Long> {

   Optional<CategoryEntity> findCategoryEntityByCategoryHeading(String category);


}
