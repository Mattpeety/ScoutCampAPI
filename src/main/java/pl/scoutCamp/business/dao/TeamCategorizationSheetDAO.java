package pl.scoutCamp.business.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.scoutCamp.domain.TeamCategorizationSheet;

import java.util.List;
import java.util.Optional;

public interface TeamCategorizationSheetDAO {

    Optional<TeamCategorizationSheet> findTeamCategorizationSheetById (Integer id);
    Page<TeamCategorizationSheet> findAllTeamSheetsByPeriod(String periodName, Integer regimentId, Pageable pageable);

}
