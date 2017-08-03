package com.company;

import java.util.Date;

//человек
public class Human {
    //фамилия
    private String familyName;
    //имя
    private String name;
    //отчество
    private String fatherName;
    //дата рождения
    private Date birthDate;
    //пол
    private Gender gender;

    public Human(String familyName, String name, String fatherName, Gender gender, Date birthDate) {
        this.familyName = familyName;
        this.name = name;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public enum Gender {
        male ("мужской"), female("женский");
        String description;

        Gender(String description) {
            this.description = description;
        }
    }

    public String getFullName(){
        return familyName + " " + name + " " + fatherName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
