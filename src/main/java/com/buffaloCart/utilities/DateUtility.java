package com.buffaloCart.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    public  String getCurrentDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date=new Date();
        String currentDate=formatter.format(date);
        return currentDate;
    }
}
