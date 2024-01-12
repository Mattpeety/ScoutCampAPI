package pl.scoutCamp.domain;


import lombok.*;

import java.util.List;

@With
@Value
@Builder
@EqualsAndHashCode(of = "teamName")
@ToString(of = {"teamName", "sheets", "totalPoints", "category"})
public class Ranking {

    String teamName;
    Integer totalPoints;
    String category;
    List<TeamCategorizationSheet> sheets;
}
