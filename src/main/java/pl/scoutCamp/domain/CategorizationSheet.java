package pl.scoutCamp.domain;


import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "sheetType", "categorizationPeriod"})
public class CategorizationSheet {

    Integer id;
    SheetType sheetType;
    CategorizationPeriod categorizationPeriod;
}
