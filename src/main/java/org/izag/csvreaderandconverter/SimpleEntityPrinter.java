package org.izag.csvreaderandconverter;

import java.util.List;

public class SimpleEntityPrinter {

    private Formatter formatter;
    private Filter filter;

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