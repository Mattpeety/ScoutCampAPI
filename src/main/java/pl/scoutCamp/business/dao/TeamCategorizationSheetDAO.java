package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.TeamCategorizationSheet;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetEntity;

import java.util.List;
import java.util.Optional;

public interface TeamCategorizationSheetDAO {

    List<TeamCategorizationSheet> findCategorizationSheetsByTeam(Integer teamId, String period);

    TeamCategorizationSheet saveNewTeamCategorizationSheet(TeamCategorizationSheet teamCategorizationSheet);
}
