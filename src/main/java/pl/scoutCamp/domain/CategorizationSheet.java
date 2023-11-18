package pl.scoutCamp.domain;


import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "CategorizationSheetId")
@ToString(of = {"CategorizationSheetId", "sheetType", "categorizationPeriod"})
public class CategorizationSheet {

    Integer CategorizationSheetId;
    SheetType sheetType;
    CategorizationPeriod categorizationPeriod;
}
