package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategorizationSheetDTO {

    Integer id;
    SheetTypeDTO sheetType;
    CategorizationPeriodDTO categorizationPeriod;
}
