<<<<<<< Updated upstream
package pl.scoutCamp.api.dto;public class RegimentsDTO {
=======
package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegimentsDTO {

    private List<RegimentDTO> regiments;
>>>>>>> Stashed changes
}
