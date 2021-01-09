package com.nextBaseCRM.tests.utilities;

public class Sleep {

    public static void seconds(double seconds){
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
