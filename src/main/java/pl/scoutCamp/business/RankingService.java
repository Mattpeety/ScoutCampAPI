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
import static pl.scoutCamp.api.controller.enums.SortOrder.*;

@Slf4j
@Service
@AllArgsConstructor
public class RankingService {

    private final TeamDAO teamDAO;
    private final TeamCategorizationSheetDAO teamCategorizationSheetDAO;

    private static final Integer MIN_POINTS_FOR_POLOWA = 20;
    private static final Integer MIN_POINTS_FOR_LESNA = 35;
    private static final Integer MIN_POINTS_FOR_PUSZCZANSKA = 50;

    public Page<Ranking> createRankingList(
            String period,
            SortType sort,
            SortOrder order) {
        List<Ranking> rankingList = new ArrayList<>();
        for (Team team : findAllTeams()) {
            Integer totalPoints = getTotalPoints(getTeamSheets(team, period));
            Ranking teamSummary = Ranking.builder()
                    .teamName(team.getName())
                    .totalPoints(totalPoints)
                    .category(getCategory(totalPoints))
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
        switch (sort) {
            case POINTS -> compare(rankingList, comparingByPoints, order);
            case NAME -> compare(rankingList, comparingByName, order);
            case CATEGORY -> compare(rankingList, comparingByCategory, order);
        }
        return rankingList;

    }
    
    private void compare(List<Ranking> rankingList, Comparator<Ranking> comparator, SortOrder order) {
        if (order.equals(ASC)) {
            rankingList.sort(comparator);
        } else {
            rankingList.sort(comparator.reversed());
        }
    }

    private String getCategory(int points) {
        String category = "";
        if (points >= MIN_POINTS_FOR_POLOWA && points < MIN_POINTS_FOR_LESNA) {
            category = POLOWA.getName();
        } else if (points >= MIN_POINTS_FOR_LESNA && points < MIN_POINTS_FOR_PUSZCZANSKA) {
            category = LESNA.getName();
        } else if (points >= MIN_POINTS_FOR_PUSZCZANSKA) {
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

    private List<Team> findAllTeams() {
        return teamDAO.findTeams();
    }

    private List<TeamCategorizationSheet> getTeamSheets(Team team, String period) {
        return teamCategorizationSheetDAO.findCategorizationSheetsByTeam(team.getId(), period);
    }
}
