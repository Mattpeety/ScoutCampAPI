package pl.scoutCamp.api.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GivenCategory {
    PROBNA("próbna"),
    POLOWA("polowa"),
    LESNA("leśna"),
    PUSZCZANSKA("puszczańska");

    private final String name;
}
