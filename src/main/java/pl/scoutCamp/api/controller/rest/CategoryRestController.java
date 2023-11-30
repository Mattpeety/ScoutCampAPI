package pl.scoutCamp.api.controller.rest;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.CategoryDTO;
import pl.scoutCamp.api.dto.dtoList.CategoriesDTO;
import pl.scoutCamp.api.dto.mapper.CategoryMapper;
import pl.scoutCamp.business.CategoryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(CategoryRestController.API_CATEGORY)
public class CategoryRestController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public static final String API_CATEGORY = "/category";
    public static final String ALL_CATEGORIES = "/categories";

    @GetMapping(value = ALL_CATEGORIES)
    public CategoriesDTO availableCategories() {
        return getCategoriesDTO();
    }

    private CategoriesDTO getCategoriesDTO() {
        return CategoriesDTO.builder()
                .categories(getAllCategoriesDTO())
                .build();
    }

    private List<CategoryDTO> getAllCategoriesDTO() {
        return categoryService.findAvailableCategories().stream()
                .map(categoryMapper::map)
                .toList();
    }
}
