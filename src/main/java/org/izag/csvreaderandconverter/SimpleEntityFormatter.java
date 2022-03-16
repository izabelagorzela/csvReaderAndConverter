package org.izag.csvreaderandconverter;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class SimpleEntityFormatter implements Formatter {

    @Override
    public String formatSimpleEntity(SimpleEntity simpleEntity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(simpleEntity.getId()).append(" ").append(getPrefix(simpleEntity.getName())).append(" ").append(simpleEntity.getName()).append(" ").append(getFormattedDate(simpleEntity.getDate()));
        return stringBuilder.toString();
    }

    private String getPrefix(String name) {
        if(name.startsWith("The Greatest")) return "";
        return "The Greatest";
    }

    private String getFormattedDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = formatter.format(date);
        if(date.getYear() >= 2020) {
           return "####" + formattedDate.substring(4, formattedDate.length());
        }
        return formattedDate;
    }
}