package com.company;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            String data = IOUtils.toString(fis, "UTF-8");

            TimeTracker tracker = new TimeTracker();
            tracker.findVisitors(data);

        }catch (Exception e){}
    }
}
