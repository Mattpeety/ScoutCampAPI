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

   private final TeamDAO teamDAO;

    @Transactional
    public List<Team> findAvailableTeams() {
        List<Team> allTeams = teamDAO.findTeams();
        if (allTeams.isEmpty()) {
            throw new NotFoundException("Could not find any team");
        }
        log.info("all Teams: [{}]", allTeams);
        return allTeams;
    }

    @Transactional
    public List<Team> findTeamsByRegimentId(Integer regimentId) {
        List<Team> teamsInRegiment = teamDAO.findTeamsByRegimentId(regimentId);
        if (teamsInRegiment.isEmpty()) {
            throw new NotFoundException("Could not find teams in regiment by id: [%s]".formatted(regimentId));
        }
        log.info("Teams: [{}] in Regiment with id [{}]", teamsInRegiment, regimentId);
        return teamsInRegiment;
    }

    @Transactional
    public List<Team> findTeamsByTroopId(Integer troopId) {
        List<Team> teamsInTroop = teamDAO.findTeamsByTroopId(troopId);
        if (teamsInTroop.isEmpty()) {
            throw new NotFoundException("Could not find teams in troop by id: [%s]".formatted(troopId));
        }
        log.info("Teams: [{}] in Troop with id [{}]", teamsInTroop, troopId);
        return teamsInTroop;
    }

    @Transactional
    public List<Team> findTeamsByUserId(Integer userId) {
        List<Team> teamsOfUser = teamDAO.findTeamsByUserId(userId);
        if (teamsOfUser.isEmpty()) {
            throw new NotFoundException("Could not find teams of user by id: [%s]".formatted(userId));
        }
        log.info("Teams: [{}] of User with id [{}]", teamsOfUser, userId);
        return teamsOfUser;
    }
}
