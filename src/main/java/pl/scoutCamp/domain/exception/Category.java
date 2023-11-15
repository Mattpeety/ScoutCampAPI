package pl.scoutCamp.domain.exception;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "categoryId")
@ToString(of = {"categoryId", "name", "imagePath"})
public class Category {

    Integer categoryId;
    String name;
    String imagePath;
}
