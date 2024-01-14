package pl.scoutCamp.api.controller.enums.stringToEnumsConverters;

import org.springframework.core.convert.converter.Converter;
import pl.scoutCamp.api.controller.enums.GivenCategory;

public class GivenCategoryConverter implements Converter<String, GivenCategory> {
    @Override
    public GivenCategory convert(String source) {
        return GivenCategory.valueOf(source.toUpperCase());
    }
}
