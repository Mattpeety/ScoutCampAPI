package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.TeamCategorizationSheet;

import java.util.Optional;

public interface TeamCategorizationSheetDAO {

    Optional<TeamCategorizationSheet> findTeamCategorizationSheetById (Integer id);
}
