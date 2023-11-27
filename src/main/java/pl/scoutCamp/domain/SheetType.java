package pl.scoutCamp.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "ordered", "isScoredSheet"})
public class SheetType {

    Integer id;
    String name;
    Integer ordered;
    Boolean isScoredSheet;
}
