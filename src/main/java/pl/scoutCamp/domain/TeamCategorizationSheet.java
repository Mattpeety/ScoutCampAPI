package pl.scoutCamp.domain;

import lombok.*;

import java.sql.Timestamp;

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
    Timestamp createdAt;
    Timestamp updatedAt;
    CategorizationSheet categorizationSheet;
    Team team;
    Category category;
}
