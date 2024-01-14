package pl.scoutCamp.api.controller.enums.stringToEnumsConverters;


import org.springframework.core.convert.converter.Converter;
import pl.scoutCamp.api.controller.enums.SortOrder;


public class SortOrderConverter implements Converter<String, SortOrder> {

    @Override
    public SortOrder convert(String source) {
        return SortOrder.valueOf(source.toUpperCase());
    }
}
