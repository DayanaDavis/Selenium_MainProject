package com.buffaloCart.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableUtility {
    public List<ArrayList<String>> getGridData(List<WebElement> rowItems, List<WebElement> cellItems) {
        int rSize = rowItems.size();
        int cSize = cellItems.size();
        int colomnSize = (cSize/rSize)-1;
        System.out.println("rSize =" + rSize + "  cSize=" + cSize + "  clistSize= " + colomnSize);
        String[] columnList = new String[colomnSize]; // 20/5 --->4
        List<ArrayList<String>> gridData = new ArrayList<ArrayList<String>>();
        int x = 0;
        for (int i = 1; i <= rSize; i++) {
            for (int j = 0; j < columnList.length; j++) {
                columnList[j] = cellItems.get(x).getText();
                x++;
            }
            gridData.add(new ArrayList<String>(Arrays.asList(columnList)));//adding 1Darray to 2DarrayList
        }
        return gridData;
    }
}
