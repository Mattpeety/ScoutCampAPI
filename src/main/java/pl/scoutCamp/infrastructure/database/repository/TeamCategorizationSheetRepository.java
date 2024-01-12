package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamCategorizationSheetJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamCategorizationSheetEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<TeamCategorizationSheet> findTeamsSheetsByPeriod(String periodName) {
        return teamCategorizationSheetJpaRepository.findAll()
                .stream()
                .filter(sheet -> sheet.getCategorizationSheet().getCategorizationPeriod().getName().equals(periodName))
                .map(teamCategorizationSheetEntityMapper::mapFromEntity)
                .toList();
    }
}
