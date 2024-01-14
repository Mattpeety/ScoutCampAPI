package pl.scoutCamp.api.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortType {
    POINTS("points"),
    NAME("name"),
    CATEGORY("category");

    private final String name;




}
