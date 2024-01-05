package pl.scoutCamp.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.api.controller.rest.JsonViews;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategorizationPeriodDTO {

    Integer id;
    String name;
}
