
package pl.scoutCamp.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.api.controller.rest.JsonViews;
import pl.scoutCamp.domain.Regiment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TroopDTO {

    @JsonView({JsonViews.NoRegimentView.class})
    Integer id;
    @JsonView({JsonViews.NoRegimentView.class})
    String name;
    @JsonView(JsonViews.FullView.class)
    Regiment regiment;
}
