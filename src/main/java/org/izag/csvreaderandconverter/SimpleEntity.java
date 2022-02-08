package org.izag.csvreaderandconverter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class SimpleEntity {

    private Integer id;
    private String name;
    private LocalDate date;
}