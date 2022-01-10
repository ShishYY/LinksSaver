package com.shish.linksaver.service;

import com.shish.linksaver.exeptions.LinkAddExeption;
import com.shish.linksaver.model.LinkDTO;
import com.shish.linksaver.model.ResponseDTO;
import com.shish.linksaver.persistence.entity.CategoryEntity;
import com.shish.linksaver.persistence.entity.LinkEntity;
import com.shish.linksaver.persistence.entity.UserEntity;
import com.shish.linksaver.persistence.repository.CategoryRepository;
import com.shish.linksaver.persistence.repository.LinkRepository;
import com.shish.linksaver.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LinkService {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public LinkService(LinkRepository linkRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public void addLink(LinkDTO link) throws LinkAddExeption {
        LinkEntity linkEntity = new LinkEntity();
        categoryRepository.findCategoryEntityByCategoryHeading(link.getLinkCategory());
        linkEntity.setUserEntityId(userRepository.findByEmail(link.getEmail()));
        linkEntity.setCategory(categoryRepository.findCategoryEntityByCategoryHeading(link.getLinkCategory()));
        linkEntity.setUrl(link.getLinkUrl());
        linkRepository.save(linkEntity);
    }

    public ResponseDTO deleteLink(LinkDTO link) throws RuntimeException {
        CategoryEntity category = categoryRepository.findCategoryEntityByCategoryHeading
                (link.getLinkCategory());

        UserEntity user = userRepository.findByEmail(link.getEmail());

        Integer isDelet = linkRepository.deleteLinkEntityByCategoryAndUserEntityIdAndUrl(category, user, link.getLinkUrl());
        if (isDelet > 0) {
            return new ResponseDTO("Link deleted");
        }
        throw new RuntimeException("Something went wrong");
    }
}
