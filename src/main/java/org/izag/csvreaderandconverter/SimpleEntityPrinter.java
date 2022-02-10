package org.izag.csvreaderandconverter;

import java.util.List;

public class SimpleEntityPrinter {

    private Formatter simpleEnityFormater;
    private Filter simpleEntityFilter;

    public SimpleEntityPrinter(Formatter simpleEntityFormatter, Filter simpleEntityFilter) {
        this.simpleEnityFormater = simpleEntityFormatter;
        this.simpleEntityFilter = simpleEntityFilter;
    }

    public void printEntities(List<SimpleEntity> entityList) {
        entityList.stream()
                .filter(simpleEntity -> simpleEntityFilter.filterSimpleEntity(simpleEntity) == true)
                .map(simpleEntity -> simpleEnityFormater.formatSimpleEntity(simpleEntity))
                .forEach(System.out::println);
    }
}