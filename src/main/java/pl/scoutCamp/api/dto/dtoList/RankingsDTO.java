package pl.scoutCamp.api.dto.dtoList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import pl.scoutCamp.api.dto.RankingDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RankingsDTO {

    private Page<RankingDTO> fullRanking;
}
