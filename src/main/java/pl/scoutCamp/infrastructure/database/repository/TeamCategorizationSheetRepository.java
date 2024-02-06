package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;
import pl.scoutCamp.infrastructure.database.entity.TeamCategorizationSheetEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamCategorizationSheetJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamCategorizationSheetEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TeamCategorizationSheetRepository implements TeamCategorizationSheetDAO {

    TeamCategorizationSheetJpaRepository teamCategorizationSheetJpaRepository;
    TeamCategorizationSheetEntityMapper teamCategorizationSheetEntityMapper;

    @Override
    public List<TeamCategorizationSheet> findCategorizationSheetsByTeam(Integer teamId, String period) {
        return teamCategorizationSheetJpaRepository.findAll()
                .stream()
                .filter(s -> s.getCategorizationSheet().getCategorizationPeriod().getName().equals(period))
                .filter(sheet -> sheet.getTeam().getId().equals(teamId))
                .map(teamCategorizationSheetEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public TeamCategorizationSheet saveNewTeamCategorizationSheet(TeamCategorizationSheet teamCategorizationSheet) {
        TeamCategorizationSheetEntity newTeamCategorizationSheet = teamCategorizationSheetEntityMapper.mapToEntity(teamCategorizationSheet);
        teamCategorizationSheetJpaRepository.saveAndFlush(newTeamCategorizationSheet);
        return teamCategorizationSheetEntityMapper.mapFromEntity(newTeamCategorizationSheet);
    }
}
