package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //{{},{},{}}
        ArrayList<ArrayList<String>> excel = new ArrayList<>();

        //someday: select a file through gui

        //Source file
        File salesSource = new File("C:\\Users\\evgnn\\Desktop\\Excsales\\src\\_chat.txt");
        Scanner reader = new Scanner(salesSource);

        //Create output file
        File salesCSV = new File("C:\\Users\\evgnn\\Desktop\\Excsales\\src\\sales.csv");
        salesCSV.createNewFile();

        //Initialize writer
        FileWriter fiWrite = new FileWriter(salesCSV);
        BufferedWriter fiWrite2 = new BufferedWriter(fiWrite);

        while(reader.hasNextLine()){
            //System.out.println(reader.nextLine());
            String currentMessage = reader.nextLine();
            //System.out.println(currentMessage);
            if(currentMessage.contains("(")){
                //System.out.println(currentMessage);
                //Pattern getTuple = Pattern.compile("(Brochas, 85,45)");
                String trips = currentMessage.substring(currentMessage.indexOf("(")+1, currentMessage.indexOf(")"));
                //str.substring(str.indexOf("[") + 1, str.indexOf("]"));
                //System.out.println(result);
                System.out.println(trips);
                fiWrite2.write(trips);
                fiWrite2.newLine();
                //fiWrite.write();
            }
        }
        fiWrite2.close();




    }
}
