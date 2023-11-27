package pl.scoutCamp.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.scoutCamp.business.dao.TeamDAO;
import pl.scoutCamp.domain.Team;
import pl.scoutCamp.domain.exception.NotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TeamService {

    TeamDAO teamDAO;

    @Transactional
    public List<Team> findTeamsByRegimentId(Integer regimentId) {
        List<Team> teamsInRegiment = teamDAO.findTeamByRegimentId(regimentId);
        if (teamsInRegiment.isEmpty()) {
            throw new NotFoundException("Could not find teams in regiment by id: [%s]".formatted(regimentId));
        }
        log.info("Teams: [{}] in Regiment with id [{}]", teamsInRegiment, regimentId);
        return teamsInRegiment;
    }
}
