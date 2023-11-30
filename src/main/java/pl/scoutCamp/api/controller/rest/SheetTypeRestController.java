package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.SheetTypeDTO;
import pl.scoutCamp.api.dto.dtoList.SheetTypesDTO;
import pl.scoutCamp.api.dto.mapper.SheetTypeMapper;
import pl.scoutCamp.business.SheetTypeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(SheetTypeRestController.API_SHEET_TYPE)
public class SheetTypeRestController {

    private final SheetTypeService sheetTypeService;
    private final SheetTypeMapper sheetTypeMapper;

    public static final String API_SHEET_TYPE = "/sheetType";
    public static final String ALL_SHEET_TYPES = "/sheetTypes";

    @GetMapping(value = ALL_SHEET_TYPES)
    public SheetTypesDTO findAllSheetTypes() {
        return getSheetTypesDTO();
    }

    private SheetTypesDTO getSheetTypesDTO() {
        return SheetTypesDTO.builder()
                .sheetTypes(getAllSheetTypesDTO())
                .build();
    }

    private List<SheetTypeDTO> getAllSheetTypesDTO() {
        return sheetTypeService.findAvailableSheetTypes().stream()
                .map(sheetTypeMapper::map)
                .toList();
    }
}
