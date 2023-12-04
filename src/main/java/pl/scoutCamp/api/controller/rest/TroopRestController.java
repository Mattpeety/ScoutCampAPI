package pl.scoutCamp.api.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.TroopDTO;
import pl.scoutCamp.api.dto.dtoList.TroopsDTO;
import pl.scoutCamp.api.dto.mapper.TroopMapper;
import pl.scoutCamp.business.TroopService;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping(TroopRestController.API_TROOP)
public class TroopRestController {

    public static final String API_TROOP = "/troop";
    public static final String TROOPS_IN_REGIMENT = "/{regimentId}/troops";

    private final TroopMapper troopMapper;
    private final TroopService troopService;


    @JsonView(JsonViews.NoRegimentView.class)
    @GetMapping(value = TROOPS_IN_REGIMENT)
    public ResponseEntity<TroopsDTO> availableTroops(@PathVariable Integer regimentId) {
        if (Objects.isNull(regimentId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getTroopsDTO(regimentId));
    }

    private TroopsDTO getTroopsDTO(Integer regimentId) {
            return TroopsDTO.builder()
                    .troops(getAllTroopsDTO(regimentId))
                    .build();
    }

    private List<TroopDTO> getAllTroopsDTO(Integer regimentId) {
        return troopService.findByRegiment(regimentId).stream()
                .map(troopMapper::map)
                .toList();
    }


}
