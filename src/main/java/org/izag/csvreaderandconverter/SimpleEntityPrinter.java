package org.izag.csvreaderandconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SimpleEntityPrinter {

    private Formatter formatter;
    private Filter filter;

    @Autowired
    public SimpleEntityPrinter(Formatter formatter, Filter filter) {
        this.formatter = formatter;
        this.filter = filter;
    }

    public void printEntities(List<SimpleEntity> entityList) {
        entityList.stream()
                .filter(simpleEntity -> filter.filterSimpleEntity(simpleEntity) == true)
                .map(simpleEntity -> formatter.formatSimpleEntity(simpleEntity))
                .forEach(System.out::println);
    }
}