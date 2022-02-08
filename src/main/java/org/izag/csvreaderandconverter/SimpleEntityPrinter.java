package org.izag.csvreaderandconverter;

import java.util.List;

public class SimpleEntityPrinter {

    private SimpleEntityFormatter simpleEnityFormater;
    private SimpleEntityFilter simpleEntityFilter;

    public SimpleEntityPrinter(SimpleEntityFormatter simpleEnityFormater, SimpleEntityFilter simpleEntityFilter) {
        this.simpleEnityFormater = simpleEnityFormater;
        this.simpleEntityFilter = simpleEntityFilter;
    }

    public void printEntities(List<SimpleEntity> entityList) {
        entityList.stream()
                .filter(simpleEntity -> simpleEntityFilter.filterSimpleEntity(simpleEntity) == true)
                .map(simpleEntity -> simpleEnityFormater.formatSimpleEntity(simpleEntity))
                .forEach(System.out::println);
    }
}