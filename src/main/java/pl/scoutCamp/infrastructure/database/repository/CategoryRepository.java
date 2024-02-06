package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.CategoryDAO;
import pl.scoutCamp.domain.Category;
import pl.scoutCamp.infrastructure.database.repository.jpa.CategoryJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.CategoryEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CategoryRepository implements CategoryDAO {

    CategoryJpaRepository categoryJpaRepository;
    CategoryEntityMapper categoryEntityMapper;

    @Override
    public List<Category> findCategories() {
        return categoryJpaRepository.findAll().stream()
                .map(categoryEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public Optional<Category> findCategoryById(int id) {
        return categoryJpaRepository.findCategoryById(id)
                .map(categoryEntityMapper::mapFromEntity);
    }
}
