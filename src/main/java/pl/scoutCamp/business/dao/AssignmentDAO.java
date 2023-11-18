package pl.scoutCamp.business.dao;

import pl.scoutCamp.domain.Assignment;

import java.util.Optional;

public interface AssignmentDAO {

    Optional<Assignment> findAssignmentById(Integer id);
}
