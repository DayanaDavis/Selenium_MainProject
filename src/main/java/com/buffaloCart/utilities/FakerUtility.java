package com.buffaloCart.utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.Options;
import com.github.javafaker.PhoneNumber;

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
        double num=faker.number().randomDouble(2,10,75);
        String value= String.valueOf(num);
        if(value.length()==4)
        {
         value.concat("0");
        }
        return value;
    }
    public String jobTitle(){
        String role=faker.job().position();
        return role;
    }
    public String prefix(){
        String pre=faker.options().option("Mr","Miss","Mrs");
        return pre;
    }

    public  String contactNumber(){
         String num=faker.phoneNumber().cellPhone();
        return num;
    }
    public String address(){
        String add=faker.address().fullAddress();
        return add;
    }
}
