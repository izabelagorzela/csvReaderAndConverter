package org.izag.csvreaderandconverter;

import java.util.List;
import java.util.ListIterator;

public class SimpleEntityPrinter {

    private SimpleEntityFormater simpleEnityFormater;

    public SimpleEntityPrinter(SimpleEntityFormater simpleEnityFormater) {
        this.simpleEnityFormater = simpleEnityFormater;
    }

    public void printEntities(List<SimpleEntity> entityList) {
        ListIterator<SimpleEntity> listIterator = entityList.listIterator();
        while(listIterator.hasNext()) {
            SimpleEntity simpleEntity = listIterator.next();
            if(simpleEntity.getDate().getMonthValue() == 3) {
                System.out.println(simpleEnityFormater.formatSimpleEntity(simpleEntity));
            }
        }
    }
}