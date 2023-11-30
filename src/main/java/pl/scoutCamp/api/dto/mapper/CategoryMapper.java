package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.CategoryDTO;
import pl.scoutCamp.domain.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO map(Category category);
}
