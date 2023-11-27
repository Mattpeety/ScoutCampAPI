<<<<<<< Updated upstream
package pl.scoutCamp.api.rest;

import lombok.AllArgsConstructor;
=======
package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.RegimentDTO;
import pl.scoutCamp.api.dto.RegimentsDTO;
import pl.scoutCamp.api.dto.mapper.RegimentMapper;
import pl.scoutCamp.business.RegimentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(RegimentRestController.REGIMENT)
public class RegimentRestController {
<<<<<<< Updated upstream

    private final RegimentService regimentService;
    private final RegimentMapper regimentMapper;

    public static final String REGIMENT = "/regiment";
    public static final String AVAILABLE_REGIMENTS = "/availableRegiments";

=======
    public static final String REGIMENT = "/regiment";
    public static final String AVAILABLE_REGIMENTS = "/regiments";

    private final RegimentService regimentService;
    private final RegimentMapper regimentMapper;
>>>>>>> Stashed changes
    @GetMapping(value = AVAILABLE_REGIMENTS)
    public RegimentsDTO availableRegiments() {
        return getRegimentsDTO();
    }

    private RegimentsDTO getRegimentsDTO() {
        return RegimentsDTO.builder()
                .regiments(getAvailableRegimentsDTO())
                .build();
    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    private List<RegimentDTO> getAvailableRegimentsDTO() {
        return regimentService.findAvailableRegiments().stream()
                .map(regimentMapper::map)
                .toList();
    }

}
