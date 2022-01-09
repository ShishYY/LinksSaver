package com.shish.linksaver.controler;

import com.shish.linksaver.exeptions.LinkAddExeption;
import com.shish.linksaver.model.CategoryDTO;
import com.shish.linksaver.model.LinkDTO;
import com.shish.linksaver.model.ResponseDTO;
import com.shish.linksaver.model.UserLinksDTO;
import com.shish.linksaver.service.CategoryService;
import com.shish.linksaver.service.LinkService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/space")
public class LinkRestController {

    private final LinkService linkService;
    private final CategoryService categoryService;

    public LinkRestController(LinkService linkService, CategoryService categoryService) {
        this.linkService = linkService;
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/savelink", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addLink(@RequestBody() LinkDTO link) throws LinkAddExeption {
        linkService.addLink(link);
    }

    @PostMapping(value = "/deletelink", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO deleteLink(@RequestBody() LinkDTO linkDelete) {
        return linkService.deleteLink(linkDelete);
    }

    @PostMapping(value = "/userlinks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserLinksDTO getUserLink() {
        return null;
    }

    @PostMapping(value = "/getcategiry", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getUserCategory() {
        return null;
    }

    @PostMapping(value = "/addcategory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO addCategory(@RequestBody() CategoryDTO categoryDTO) {
        return categoryService.addcategory(categoryDTO);
    }

}
