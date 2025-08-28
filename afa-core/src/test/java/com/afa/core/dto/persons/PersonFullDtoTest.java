package com.afa.core.dto.persons;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class PersonFullDtoTest {

    @Test
    void validate_success() {
        final PersonFullDto p1 = PersonFullDto.builder()
                .firstName("Аркадий")
                .middleName("Натанович")
                .lastName("Стругацкий")
                .build();
        assertEquals("Аркадий Натанович Стругацкий", p1.getFullName());
        assertEquals("Стругацкий А.Н.", p1.getShortName());
    }

}
