package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.AssignmentGroup;

import java.util.Optional;

public interface AssignmentGroupDAO {

    Optional<AssignmentGroup> findAssignmentGroupByName(String name);
}
