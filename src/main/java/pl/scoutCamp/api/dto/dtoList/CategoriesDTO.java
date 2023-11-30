package pl.scoutCamp.api.dto.dtoList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.api.dto.CategoryDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {

    List<CategoryDTO> categories;
}
