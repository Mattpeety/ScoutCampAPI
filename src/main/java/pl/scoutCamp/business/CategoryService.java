package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.CategoryDAO;
import pl.scoutCamp.domain.Category;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.Collection;
import java.util.List;


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
}
