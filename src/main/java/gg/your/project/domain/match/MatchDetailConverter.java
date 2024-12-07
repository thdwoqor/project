package gg.your.project.domain.match;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Converter
@Component
@RequiredArgsConstructor
public class MatchDetailConverter implements AttributeConverter<MatchDetail, String> {

    private final ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(final MatchDetail team) {
        try {
            return objectMapper.writeValueAsString(team);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("MatchDetail -> json 변환에 실패했습니다.");
        }
    }

    @Override
    public MatchDetail convertToEntityAttribute(final String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("json -> MatchDetail 변환에 실패했습니다.");
        }
    }
}
