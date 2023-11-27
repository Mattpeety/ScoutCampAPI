<<<<<<< Updated upstream
package pl.scoutCamp.api.dto;public class TroopDTO {
=======
package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.scoutCamp.domain.Regiment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TroopDTO {

    Integer id;
    String name;
    Regiment regiment;
>>>>>>> Stashed changes
}
