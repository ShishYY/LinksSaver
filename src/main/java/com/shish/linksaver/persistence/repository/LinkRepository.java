package com.shish.linksaver.persistence.repository;

import com.shish.linksaver.persistence.entity.CategoryEntity;
import com.shish.linksaver.persistence.entity.LinkEntity;
import com.shish.linksaver.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;



public interface LinkRepository extends CrudRepository<LinkEntity,Long> {
         LinkEntity deleteLinkEntityByCategoryAndUserEntityIdAndUrl (CategoryEntity category, UserEntity user,String Url);
}
