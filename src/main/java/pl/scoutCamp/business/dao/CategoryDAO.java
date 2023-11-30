package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO {

    List<Category> findCategories();
}
