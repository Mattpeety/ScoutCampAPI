package pl.scoutCamp.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import pl.scoutCamp.api.controller.enums.SortOrder;
import pl.scoutCamp.api.controller.enums.SortType;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.business.dao.TeamDAO;
import pl.scoutCamp.domain.Ranking;
import pl.scoutCamp.domain.Team;
import pl.scoutCamp.domain.TeamCategorizationSheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static pl.scoutCamp.api.controller.enums.GivenCategory.*;

@Slf4j
@Service
@AllArgsConstructor
public class RankingService {

    private final TeamDAO teamDAO;
    private final TeamCategorizationSheetDAO teamCategorizationSheetDAO;

    public Page<Ranking> createRankingList(
            String period,
           SortType sort,
            SortOrder order) {
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

    private List<Ranking> sortedRankingList(List<Ranking> rankingList, SortType sort, SortOrder order) {
        Comparator<Ranking> comparingByPoints = Comparator.comparing(Ranking::getTotalPoints);
        Comparator<Ranking> comparingByName = Comparator.comparing(Ranking::getTeamName);
        Comparator<Ranking> comparingByCategory = Comparator.comparing(Ranking::getCategory);
        if (order.equals(SortOrder.ASC)) {
            switch (sort) {
                case POINTS -> compareAsc(rankingList, comparingByPoints);
                case NAME -> compareAsc(rankingList, comparingByName);
                case CATEGORY -> compareAsc(rankingList, comparingByCategory);
            }
        } else {
            switch (sort) {
                case POINTS -> compareDesc(rankingList, comparingByPoints);
                case NAME -> compareDesc(rankingList, comparingByName);
                case CATEGORY -> compareDesc(rankingList, comparingByCategory);
            }
        }
        return rankingList;
    }

    private static void compareAsc(List<Ranking> rankingList, Comparator<Ranking> comparator) {
        rankingList.sort(comparator);
    }
    private static void compareDesc(List<Ranking> rankingList, Comparator<Ranking> comparator) {
        rankingList.sort(comparator.reversed());
    }

    private String getCategory(int points) {
        String category = "";
        if (points >= 0 && points < 20) {
            category = POLOWA.getName();
        } else if (points >= 20 && points < 50) {
            category = LESNA.getName();
        } else if (points >= 50) {
            category = PUSZCZANSKA.getName();
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
