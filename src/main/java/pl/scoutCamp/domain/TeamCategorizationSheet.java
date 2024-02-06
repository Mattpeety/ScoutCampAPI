package pl.scoutCamp.domain;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "isDraft", "points", "createdAt",
        "updatedAt", "categorizationSheet", "team", "category"})
public class TeamCategorizationSheet {

    Integer id;
    Boolean isDraft;
    Integer points;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    CategorizationSheet categorizationSheet;
    Team team;
    Category category;
}
