package org.izag.csvreaderandconverter;

public class SimpleEntityFilter implements Filter{

    @Override
    public boolean filterSimpleEntity(SimpleEntity simpleEntity) {
        if(simpleEntity.getDate().getMonthValue() == 3)
            return true;
        else return false;
    }
}