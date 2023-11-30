package pl.scoutCamp.api.dto.dtoList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.api.dto.SheetTypeDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SheetTypesDTO {

    List<SheetTypeDTO> sheetTypes;
}
