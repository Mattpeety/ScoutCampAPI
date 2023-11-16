package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.exception.TeamCategorizationSheet;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamCategorizationSheetJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamCategorizationSheetEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class TeamCategorizationSheetRepository implements TeamCategorizationSheetDAO {

    TeamCategorizationSheetJpaRepository teamCategorizationSheetJpaRepository;
    TeamCategorizationSheetEntityMapper teamCategorizationSheetEntityMapper;
    @Override
    public Optional<TeamCategorizationSheet> findTeamCategorizationSheetById(Integer id) {
return teamCategorizationSheetJpaRepository.findTeamCategorizationSheetById(id)
        .map(teamCategorizationSheetEntityMapper::mapFromEntity);
    }
}
