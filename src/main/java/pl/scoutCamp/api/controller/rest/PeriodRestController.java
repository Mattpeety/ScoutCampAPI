package pl.scoutCamp.api.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.scoutCamp.api.dto.CategorizationPeriodDTO;
import pl.scoutCamp.api.dto.dtoList.CategorizationPeriodsDTO;
import pl.scoutCamp.api.dto.mapper.CategorizationPeriodMapper;
import pl.scoutCamp.business.CategorizationPeriodService;
import pl.scoutCamp.domain.CategorizationPeriod;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping(PeriodRestController.API_PERIOD)
public class PeriodRestController {

    public static final String API_PERIOD = "/period";
    public static final String ALL_PERIODS = "/periods";
    public static final String PERIOD_BY_NAME = "/{periodName}";


    private final CategorizationPeriodService categorizationPeriodService;
    private final CategorizationPeriodMapper categorizationPeriodMapper;

    @GetMapping(value = ALL_PERIODS)
    public CategorizationPeriodsDTO findAvailablePeriods() {
        return getPeriodsDTO();
    }

    private CategorizationPeriodsDTO getPeriodsDTO() {
        return CategorizationPeriodsDTO.builder()
                .categorizationPeriods(getAllPeriodsDTO())
                .build();
    }

    public List<CategorizationPeriodDTO> getAllPeriodsDTO() {
        return categorizationPeriodService.findAvailablePeriods().stream()
                .map(categorizationPeriodMapper::map)
                .toList();
    }

    @GetMapping(value = PERIOD_BY_NAME)
    public ResponseEntity<CategorizationPeriodDTO> findPeriodByName(@PathVariable String periodName) {
        if (Objects.isNull(periodName)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getPeriodByNameDTO(periodName));
    }

    private CategorizationPeriodDTO getPeriodByNameDTO(String periodName) {
        CategorizationPeriod period = categorizationPeriodService.findPeriod(periodName);
        return categorizationPeriodMapper.map(period);
    }
}
