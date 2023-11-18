package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.CategoryDAO;
import pl.scoutCamp.domain.Category;
import pl.scoutCamp.infrastructure.database.repository.jpa.CategoryJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.CategoryEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRepository implements CategoryDAO {

    CategoryJpaRepository categoryJpaRepository;
    CategoryEntityMapper categoryEntityMapper;

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return categoryJpaRepository.findCategoryByName(name)
                .map(categoryEntityMapper::mapFromEntity);
    }
}
