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
public class TeamDTO {


    @JsonView(value = {JsonViews.NoTroopView.class})
    Integer id;
    @JsonView(value = {JsonViews.NoTroopView.class, JsonViews.RankingView.class})
    String name;
    @JsonView(JsonViews.FullView.class)
    RegimentDTO regiment;
    @JsonView(value = {JsonViews.NoRegimentView.class})
    TroopDTO troop;
    @JsonView(value = {JsonViews.NoTroopView.class})
    UserDTO user;

}
