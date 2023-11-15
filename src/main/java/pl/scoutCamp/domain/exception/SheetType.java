package pl.scoutCamp.domain.exception;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "sheetTypeId")
@ToString(of = {"sheetTypeId", "name", "ordered", "isScoredSheet"})
public class SheetType {

    Integer sheetTypeId;
    String name;
    Integer ordered;
    Boolean isScoredSheet;
}
