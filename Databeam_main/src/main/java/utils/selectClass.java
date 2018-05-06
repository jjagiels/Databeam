package utils;


import uiForms.directDeposit;

import javax.swing.*;

public class selectClass {
    public static void select(Object obj){
        String className = obj.getClass().getSimpleName();

        switch (className.toLowerCase()){
            case "directdeposit":
                dataClasses.directDeposit DD = (dataClasses.directDeposit) obj;
                new uiForms.directDeposit(DD);
                break;

        }
    }
}
