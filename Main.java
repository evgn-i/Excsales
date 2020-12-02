package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //ToDo someday: select a file through gui
        //ToDo someday: refinement.txt

        //Source file
        Scanner sourceReader = getSourceFile("C:\\Users\\evgnn\\Desktop\\Excsales\\src\\_chat.txt");

        //Create output file
        File salesCSV = makeOutputFile("C:\\Users\\evgnn\\Desktop\\Excsales\\src\\sales.csv");

        //Convert source file to csv, and save it
        sourceToCSV(sourceReader,salesCSV);

    }

    //Given a scanner on the source file, and a File object for the destination file, puts tuples into a .csv file
    //Assumes each tuple in the file is of the same size
    private static void sourceToCSV(Scanner sourceReader, File salesCSV) throws IOException {

        //Initialize writer
        FileWriter fiWrite = new FileWriter(salesCSV);
        BufferedWriter fiWrite2 = new BufferedWriter(fiWrite);

        //Convert to csv file
        while(sourceReader.hasNextLine()){
            String currentMessage = sourceReader.nextLine();
            //If current line has a tuple, add it to our csv file
            if(currentMessage.contains("(")){
                String trips = currentMessage.substring(currentMessage.indexOf("(")+1, currentMessage.indexOf(")"));
                fiWrite2.write(trips);
                fiWrite2.newLine();
            }
        }
        fiWrite2.close();
    }

    //Given a specified path for the output (including the desired name of the *.csv file), will make a file
    //  and return a File object to that file
    private static File makeOutputFile(String destination) throws IOException {
        File salesCSV = new File(destination);
        salesCSV.createNewFile();
        return salesCSV;
    }

    //Given a path to a text file, will return a scanner on that file
    private static Scanner getSourceFile(String filePath) throws FileNotFoundException {
        File salesSource = new File(filePath);
        Scanner reader = new Scanner(salesSource);
        return reader;
    }
}
