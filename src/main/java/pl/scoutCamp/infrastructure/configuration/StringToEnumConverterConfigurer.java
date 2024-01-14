package pl.scoutCamp.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.scoutCamp.api.controller.enums.stringToEnumsConverters.GivenCategoryConverter;
import pl.scoutCamp.api.controller.enums.stringToEnumsConverters.SortOrderConverter;
import pl.scoutCamp.api.controller.enums.stringToEnumsConverters.SortTypeConverter;

@Configuration
public class StringToEnumConverterConfigurer implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SortOrderConverter());
        registry.addConverter(new SortTypeConverter());
        registry.addConverter(new GivenCategoryConverter());
    }
}
