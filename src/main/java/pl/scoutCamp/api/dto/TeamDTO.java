package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.domain.Regiment;
import pl.scoutCamp.domain.Troop;
import pl.scoutCamp.domain.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    Integer id;
    String name;
    Regiment regiment;
    Troop troop;
    User user;
}
