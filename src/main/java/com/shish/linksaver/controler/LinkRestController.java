package com.shish.linksaver.controler;

import com.shish.linksaver.exeptions.LinkAddExeption;
import com.shish.linksaver.model.dto.CategoryDto;
import com.shish.linksaver.model.dto.LinkDto;
import com.shish.linksaver.model.dto.ResponseDto;
import com.shish.linksaver.model.dto.UserLinksDto;
import com.shish.linksaver.service.impl.CategoryService;
import com.shish.linksaver.service.impl.LinkService;
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
    public void addLink(@RequestBody() LinkDto link) throws LinkAddExeption {
        linkService.addLink(link);
    }

    @PostMapping(value = "/deletelink", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto deleteLink(@RequestBody() LinkDto linkDelete) {
        return linkService.deleteLink(linkDelete);
    }

    @PostMapping(value = "/userlinks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserLinksDto getUserLink() {
        return null;
    }

    @PostMapping(value = "/getcategory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getUserCategory() {
        return null;
    }

    @PostMapping(value = "/addcategory", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto addCategory(@RequestBody() CategoryDto categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }
    @PostMapping(value = "/deletedcategory",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto deleteCategory(@RequestBody() CategoryDto categoryDTO){
        return categoryService.deleteCategory(categoryDTO);
    }

}
