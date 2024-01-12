package pl.scoutCamp.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class TeamCategorizationSheetService {

    private final TeamCategorizationSheetDAO teamCategorizationSheetDAO;

    public static final String POINTS = "points";
    public static final String NAME = "name";
    public static final String CATEGORY = "category";


    public List<TeamCategorizationSheet> findTeamsSheetsByPeriod(String periodName) {
        List<TeamCategorizationSheet> allTeamsSheets = teamCategorizationSheetDAO.findTeamsSheetsByPeriod(periodName);
        if (allTeamsSheets.isEmpty()) {
            throw new NotFoundException("Could not find list of all teams' scores");
        }
        log.info("Number of teams' scores: [{}] in period [{}]", allTeamsSheets.size(), periodName);
        return allTeamsSheets;
    }

    public List<TeamCategorizationSheet> findTeamsSheetsByRegimentAndPeriod(Integer regimentId, String periodName) {
        List<TeamCategorizationSheet> allTeamsSheetsInRegiment =
                findTeamsSheetsByPeriod(periodName)
                        .stream()
                        .filter(sheet -> sheet.getTeam().getRegiment().getId().equals(regimentId))
                        .toList();
        if (allTeamsSheetsInRegiment.isEmpty()) {
            throw new NotFoundException("Could not find list of teams' scores in this regiment");
        }
        log.info("Number of teams' scores: [{}] in regiment with Id: [{}] in period: [{}]", allTeamsSheetsInRegiment.size(), regimentId, periodName);
        return allTeamsSheetsInRegiment;
    }

    public List<TeamCategorizationSheet> getSortedRanking(String periodName, String sortedBy, String order) {
        ArrayList<TeamCategorizationSheet> rankingList =
                new ArrayList<>(findTeamsSheetsByPeriod(periodName));
        return sortRanking(rankingList, sortedBy, order);
    }

    public List<TeamCategorizationSheet> getSortedRanking(Integer regimentId, String periodName, String sortedBy, String order) {
        ArrayList<TeamCategorizationSheet> rankingList =
                new ArrayList<>(findTeamsSheetsByRegimentAndPeriod(regimentId, periodName));
        return sortRanking(rankingList, sortedBy, order);
    }

    public List<TeamCategorizationSheet> sortRanking(List<TeamCategorizationSheet> rankingToSort, String sortedBy, String order) {
        if (order.equals("asc")) {
            switch (sortedBy) {
                case POINTS -> rankingToSort.sort(Comparator.comparing(
                        TeamCategorizationSheet::getPoints));
                case NAME -> rankingToSort.sort(Comparator.comparing(
                        TeamCategorizationSheet -> TeamCategorizationSheet.getTeam().getName()));
                case CATEGORY -> rankingToSort.sort(Comparator.comparing(
                        TeamCategorizationSheet -> TeamCategorizationSheet.getCategory().getName()));
            }
        } else if (order.equals("desc")) {
            switch (sortedBy) {
                case POINTS -> rankingToSort.sort(Collections.reverseOrder(Comparator.comparing(
                        TeamCategorizationSheet::getPoints)));
                case NAME -> rankingToSort.sort(Collections.reverseOrder(Comparator.comparing(
                        TeamCategorizationSheet -> TeamCategorizationSheet.getTeam().getName())));
                case CATEGORY -> rankingToSort.sort(Collections.reverseOrder(Comparator.comparing(
                        TeamCategorizationSheet -> TeamCategorizationSheet.getCategory().getName())));
            }
        }
        return rankingToSort;
    }
}
