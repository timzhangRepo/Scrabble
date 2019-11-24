// Name: Tianchen Zhang
// USC NetID: 4347909915
// CS 455 PA4
// Fall 2019
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A Word finder program which will finds words
 * that are anagram of the unique word you entered.
 * You can specify the dictionary you wish to use in the command line
 * by entering file after typing the program name.
 * This class contains the main method and also the findWord method
 * @author timzhang
 * */

public class WordFinder {
    /**
     * This method receives the user input filename and
     *calls the findWord method to start the program.
     * @param args
     */
    public static void main(String[] args)
    {
        String filename = ""; //The name of the dictionary file.
        if(args.length == 0)
        {
            filename = "sowpods.txt"; //default dictionary to use when no user specification
        }
        else
        {
            for (int i = 0; i < args.length; i++)
            {
                filename+=args[i];
            }
            filename="testFiles/"+filename;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Type . to quit.");
        System.out.print("Rack?"+" ");
        String unique = scan.next();
        while(!unique.equals("."))
        {
            findWord(unique, filename);
            System.out.print("Rack?"+" ");
            unique = scan.next();
        }
    }
    /**
     *Calls WordSolution to findWord all anagrams of the given word
     *@param unique the word to findWord its anagrams
     *@param filename the dictionary file name
     */
    public static void findWord(String unique, String filename)
    {
        try
        {
            AnagramDictionary ad = new AnagramDictionary(filename);
            WordSolution ws = new WordSolution(ad, 0,unique);
            ws.displaySolution();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
