package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;
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
    public Optional<TeamCategorizationSheet> findTeamCategorizationSheetById(Integer id) {
return teamCategorizationSheetJpaRepository.findTeamCategorizationSheetById(id)
        .map(teamCategorizationSheetEntityMapper::mapFromEntity);
    }
    @Override
    public Page<TeamCategorizationSheet> findAllTeamSheetsByPeriod(String periodName, Integer regimentId, Pageable pageable) {
        var ranking = teamCategorizationSheetJpaRepository.findAll(pageable)
                .stream()
                .filter(sheet -> sheet.getCategorizationSheet().getCategorizationPeriod().getName().equals(periodName))
                .map(teamCategorizationSheetEntityMapper::mapFromEntity)
                .toList();
        var rankingByRegiment = ranking
                .stream()
                .filter(sheet -> sheet.getTeam().getRegiment().getId().equals(regimentId))
                .toList();
        if (!(regimentId == null)) {
            return new PageImpl<>(rankingByRegiment);
        } else {
            return new PageImpl<>(ranking);
        }
    }
}
