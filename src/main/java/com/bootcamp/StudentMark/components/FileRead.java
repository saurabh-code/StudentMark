package com.bootcamp.StudentMark.components;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileRead {
    public String getFilePath(){
        return "src/resources/mark_report.txt";
    }

    public  Map <String,  ArrayList> fetchMarkFromFile() throws IOException {

        Map <String, ArrayList> markReport = new HashMap<String, ArrayList>();

        File file =
                new File(getFilePath());
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String [] temp = sc.nextLine().split(" ");

            ArrayList < Integer> mark = new ArrayList<Integer>();

            for( int  i = 1; i < temp.length; i++){
                mark.add(Integer.parseInt(temp[i]));
            }

            markReport.put( temp[0], mark);

        }

        return markReport;

    }
}
