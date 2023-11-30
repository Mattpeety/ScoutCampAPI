package pl.scoutCamp.api.dto.mapper;

import org.mapstruct.Mapper;
import pl.scoutCamp.api.dto.SheetTypeDTO;
import pl.scoutCamp.domain.SheetType;

@Mapper(componentModel = "spring")
public interface SheetTypeMapper {

    SheetTypeDTO map(SheetType sheetType);
}
