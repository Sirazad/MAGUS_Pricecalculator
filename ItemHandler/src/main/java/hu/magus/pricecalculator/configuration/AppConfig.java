package hu.magus.pricecalculator.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import hu.magus.pricecalculator.converter.ItemAddRequestToItemDtoConverter;
import hu.magus.pricecalculator.converter.ItemDtoToItemConverter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.support.FormattingConversionService;

@Configuration
@AllArgsConstructor
public class AppConfig {
    private final ItemAddRequestToItemDtoConverter itemAddRequestToItemDtoConverter;
    private final ItemDtoToItemConverter itemDtoToItemConverter;

    @Bean
    @Lazy
    public FormattingConversionService converter() {
        FormattingConversionService conversionService = new FormattingConversionService();

        conversionService.addConverter(itemAddRequestToItemDtoConverter);
        conversionService.addConverter(itemDtoToItemConverter);
        return conversionService;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Hibernate6Module());
        return objectMapper;
    }
}