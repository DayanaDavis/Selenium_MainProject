package com.buffaloCart.utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
    Faker faker=new Faker();
    public String userName(){
        String name=faker.name().username();
        return name;
    }
    public String firstName(){
        String fName=faker.name().firstName();
        return fName;
    }
    public String lastName(){
        String lName=faker.name().lastName();
        return lName;
    }
    public String eMail(){
        String email=faker.internet().emailAddress();
        return email;
    }
    public String passWord(){
        String password=faker.internet().password();
        return password;
    }
    public String decimalValue(){
        double num=faker.number().randomDouble(2,1,75);
        String value= String.valueOf(num);
        return value;
    }
    public String jobTitle(){
        String role=faker.job().position();
        return role;
    }
}
