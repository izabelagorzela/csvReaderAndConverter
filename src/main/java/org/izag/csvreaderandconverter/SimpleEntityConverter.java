package org.izag.csvreaderandconverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


public class SimpleEntityConverter {

    Optional<SimpleEntity> convertToSimpleEntity(String row) {
        SimpleEntity simpleEntity;
        String[] data = row.split(",");
        try {
            simpleEntity = new SimpleEntity(Integer.valueOf(data[0]), data[1], LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } catch (NumberFormatException exc) {
            simpleEntity = null;
            return Optional.ofNullable(simpleEntity);
        }
        return Optional.ofNullable(simpleEntity);
    }
}