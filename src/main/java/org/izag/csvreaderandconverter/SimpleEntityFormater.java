package org.izag.csvreaderandconverter;

public class SimpleEntityFormater implements Formater{

    @Override
    public String formatSimpleEntity(SimpleEntity simpleEntity) {
        String simpleEntityAsString;
        simpleEntityAsString = simpleEntity.getId().toString() + " " + setPrefix(simpleEntity) + " " + setMaskForYear(simpleEntity);
        return simpleEntityAsString;
    }

    private String setPrefix(SimpleEntity simpleEntity) {
        String nameWithPrefix;
        if(! simpleEntity.getName().startsWith("The Greatest")) {
           nameWithPrefix = "The Greatest " + simpleEntity.getName();
        } else {
            nameWithPrefix = simpleEntity.getName();
        }
        return nameWithPrefix;
    }

    private String setMaskForYear(SimpleEntity simpleEntity) {
        String formattedDate;
        if(simpleEntity.getDate().getYear() >= 2020) {
           formattedDate = "####-" + "0" + simpleEntity.getDate().getMonthValue() + "-" + simpleEntity.getDate().getDayOfMonth();
        } else {
            formattedDate = simpleEntity.getDate().toString();
        }
        return formattedDate;
    }
}