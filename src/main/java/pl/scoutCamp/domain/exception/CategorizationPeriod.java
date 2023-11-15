package pl.scoutCamp.domain.exception;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "categorizationPeriodId")
@ToString(of = {"categorizationPeriodId", "name"})
public class CategorizationPeriod {

    Integer categorizationPeriodId;
    String name;
}
