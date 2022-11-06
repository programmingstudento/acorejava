package com.learn.read;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LombokNoNullOnField {
     private int id;
     private double salary;
     @NonNull
     private String name;
     
}
