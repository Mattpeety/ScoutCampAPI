package pl.scoutCamp.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;

@Slf4j
@Service
@AllArgsConstructor
public class TeamCategorizationSheetService {

    private final TeamCategorizationSheetDAO teamCategorizationSheetDAO;

    public static final String POINTS = "points";
    public static final String NAME = "name";
    public static final String CATEGORY = "category";

    public Page<TeamCategorizationSheet> findTeamSheetsByPeriod(
            String period,
            Integer regimentId,
            int pageNumber,
            int pageSize,
            String sort,
            String order) {
        Pageable sortAsc = PageRequest.of(pageNumber, pageSize, Sort.by(sortParam(sort)));
        Pageable sortDesc = PageRequest.of(pageNumber, pageSize, Sort.by(sortParam(sort)).descending());
        if (order.equals("asc")) {
            return getSortedRanking(period, regimentId, sortAsc);
        } else {
            return getSortedRanking(period, regimentId, sortDesc);
        }
    }

    private Page<TeamCategorizationSheet> getSortedRanking(String period, Integer regimentId, Pageable sortOrder) {
        return teamCategorizationSheetDAO.findAllTeamSheetsByPeriod(period, regimentId, sortOrder);
    }

    private String sortParam(String sort) {
        String sortParam = null;
        switch (sort) {
            case POINTS -> sortParam = "points";
            case NAME -> sortParam = "team.name";
            case CATEGORY -> sortParam = "category.name";
        }
        return sortParam;
    }
}
