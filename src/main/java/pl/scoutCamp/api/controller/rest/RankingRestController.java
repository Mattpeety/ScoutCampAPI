package pl.scoutCamp.api.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.scoutCamp.api.controller.enums.SortOrder;
import pl.scoutCamp.api.controller.enums.SortType;
import pl.scoutCamp.api.dto.RankingDTO;
import pl.scoutCamp.api.dto.dtoList.RankingsDTO;
import pl.scoutCamp.api.dto.mapper.RankingMapper;
import pl.scoutCamp.business.RankingService;

@RestController
@AllArgsConstructor
@RequestMapping(RankingRestController.API_RANKING)
// TODO: pagination and ranking in specific regiment
public class RankingRestController {

    public static final String API_RANKING = "/ranking";
    public static final String ALL_TEAMS = "/allTeams/{period}";

    private final RankingService rankingService;
    private final RankingMapper rankingMapper;

    @GetMapping(value = ALL_TEAMS)
    @JsonView(JsonViews.RankingView.class)
    public RankingsDTO findAllRankings (
            @PathVariable String period,
            @RequestParam(defaultValue = "points") SortType sort,
            @RequestParam(defaultValue = "desc") SortOrder order
    ) {
        return getRankingsDTO(period, sort, order);
    }

    private RankingsDTO getRankingsDTO(String period, SortType sort, SortOrder order) {
        return RankingsDTO.builder()
                .fullRanking(getAllRankingsDTO(period, sort, order))
                .build();
    }

    private Page<RankingDTO> getAllRankingsDTO(String period, SortType sort, SortOrder order) {
        return rankingService.createRankingList(period, sort, order)
                .map(rankingMapper::map);
    }


}
