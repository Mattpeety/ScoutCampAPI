package pl.scoutCamp.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.business.dao.TeamDAO;
import pl.scoutCamp.domain.Ranking;
import pl.scoutCamp.domain.Team;
import pl.scoutCamp.domain.TeamCategorizationSheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RankingService {

    private final TeamDAO teamDAO;
    private final TeamCategorizationSheetDAO teamCategorizationSheetDAO;
    public static final String POINTS = "points";
    public static final String NAME = "name";
    public static final String CATEGORY = "category";

    public Page<Ranking> createRankingList(
            String period,
            String sort,
            String order) {
        List<Ranking> rankingList = new ArrayList<>();
        for (Team team : FindAllTeams()) {
            Ranking teamSummary = Ranking.builder()
                    .teamName(team.getName())
                    .totalPoints(getTotalPoints(getTeamSheets(team, period)))
                    .category(getCategory(getTotalPoints(getTeamSheets(team, period))))
                    .sheets(getTeamSheets(team, period))
                    .build();
            rankingList.add(teamSummary);
        }
//
        return new PageImpl<>(sortedRankingList(rankingList, sort, order));
    }

    private List<Ranking> sortedRankingList(List<Ranking> rankingList, String sort, String order) {
        if (order.equals("asc")) {
            switch (sort) {
                case POINTS -> rankingList.sort(Comparator.comparing(Ranking::getTotalPoints));
                case NAME -> rankingList.sort(Comparator.comparing(Ranking::getTeamName));
                case CATEGORY -> rankingList.sort(Comparator.comparing(Ranking::getCategory));
            }
        } else {
            switch (sort) {
                case POINTS -> rankingList.sort(Comparator.comparing(Ranking::getTotalPoints).reversed());
                case NAME -> rankingList.sort(Comparator.comparing(Ranking::getTeamName).reversed());
                case CATEGORY -> rankingList.sort(Comparator.comparing(Ranking::getCategory).reversed());
            }
        }
        return rankingList;
    }

    private String getCategory(int points) {
        String category = "";
        if (points >= 0 && points < 20) {
            category = "Polowa";
        } else if (points >= 20 && points < 50) {
            category = "Leśna";
        } else if (points >= 50) {
            category = "Puszczańska";
        }
        return category;
    }

    private Integer getTotalPoints(List<TeamCategorizationSheet> teamSheets) {
        int totalPoints = 0;
        for (TeamCategorizationSheet teamSheet : teamSheets) {
            totalPoints = totalPoints + teamSheet.getPoints();
        }
        return totalPoints;
    }

    private List<Team> FindAllTeams() {
        return teamDAO.findTeams();
    }

    private List<TeamCategorizationSheet> getTeamSheets(Team team, String period) {
        return teamCategorizationSheetDAO.findCategorizationSheetsByTeam(team.getId(), period);
    }
}
