package pl.scoutCamp.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.infrastructure.database.entity.CategoryEntity;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Integer> {
}
