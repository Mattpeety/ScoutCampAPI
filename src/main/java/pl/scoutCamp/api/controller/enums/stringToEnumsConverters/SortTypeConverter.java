package pl.scoutCamp.api.controller.enums.stringToEnumsConverters;

import org.springframework.core.convert.converter.Converter;
import pl.scoutCamp.api.controller.enums.SortType;

public class SortTypeConverter implements Converter<String, SortType> {
    @Override
    public SortType convert(String source) {
        return SortType.valueOf(source.toUpperCase());
    }
}
