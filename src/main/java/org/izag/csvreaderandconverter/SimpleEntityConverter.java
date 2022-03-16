package org.izag.csvreaderandconverter;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class SimpleEntityConverter {

    Optional<SimpleEntity> convertToSimpleEntity(String row) {
        SimpleEntity simpleEntity = null;
        String[] data = row.split(",");
        try {
            simpleEntity = new SimpleEntity(Integer.valueOf(data[0]), data[1], LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } catch (NumberFormatException | DateTimeParseException exc) {
            System.err.println("Row conversion error: " + row);
        }
        return Optional.ofNullable(simpleEntity);
    }
}