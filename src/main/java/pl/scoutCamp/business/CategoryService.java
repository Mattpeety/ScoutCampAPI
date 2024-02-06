package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.CategoryDAO;
import pl.scoutCamp.domain.Category;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryDAO categoryDAO;

    @Transactional
    public List<Category> findAvailableCategories() {
        List<Category> categories = categoryDAO.findCategories();
        if (categories.isEmpty()) {
            throw new NotFoundException("Could not find categories");
        }
        log.info("Categories: [{}]", categories);
        return categories;
    }

    @Transactional
    public Category findCategoryById(int id) {
        Optional<Category> category = categoryDAO.findCategoryById(id);
        if (category.isEmpty()) {
            throw new NotFoundException("Could not find this category");
        }
        return category.get();
    }
}
