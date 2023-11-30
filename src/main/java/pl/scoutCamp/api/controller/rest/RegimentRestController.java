
package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.RegimentDTO;
import pl.scoutCamp.api.dto.dtoList.RegimentsDTO;
import pl.scoutCamp.api.dto.mapper.RegimentMapper;
import pl.scoutCamp.business.RegimentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(RegimentRestController.API_REGIMENT)
public class RegimentRestController {

    private final RegimentService regimentService;
    private final RegimentMapper regimentMapper;

    public static final String API_REGIMENT = "/regiment";
    public static final String ALL_REGIMENTS = "/regiments";

    @GetMapping(value = ALL_REGIMENTS)
    public RegimentsDTO availableRegiments() {
        return getRegimentsDTO();
    }

    private RegimentsDTO getRegimentsDTO() {
        return RegimentsDTO.builder()
                .regiments(getAllRegimentsDTO())
                .build();
    }


    private List<RegimentDTO> getAllRegimentsDTO() {
        return regimentService.findAvailableRegiments().stream()
                .map(regimentMapper::map)
                .toList();
    }

}
