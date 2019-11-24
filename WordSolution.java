// Name: Tianchen Zhang
// USC NetID: 4347909915
// CS 455 PA4
// Fall 2019

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *Find and display the solution for a user typed word.
 * Find the word by using AnagramDictionary and
 * store all finding in an ArrayList.
 * Sort and display all words inside the ArrayList by its score in
 * decreasing order using a ScoreTable.
 * All words with the same score will be sorted in alphabetical order.
 * @author timzhang
 */
public class WordSolution {
    private Rack rack;
    private String unique;
    private ArrayList<String> words;
    ScoreTable scoreTable = new ScoreTable();

    /**
     * Create a WordSolution from the given dictionary, string, and k value
     * @param anagramDictionary is the dictionary file used to findWord anagrams
     * @param string is the string used to findWord its anagrams.
     * @param k the starting index for the string used to findWord anagrams.
     *          Refer Rack class for more details
     */

    public WordSolution(AnagramDictionary anagramDictionary, int k, String string)
    {
        this.rack = new Rack(anagramDictionary, k, string);
        this.words = rack.getAllWords();
        this.unique=string;
        sortWordsByDecreasingOrder();
    }

    /**
     * Display all words found to the user.
     * Items that displayed are
     * size of the array; unique; All elements in the ArrayList words.
     */
    public void displaySolution()
    {
        System.out.println("We can make "+words.size()+" words from "+"\""+unique+"\"");
        if(words.size()!=0){System.out.println("All of the words with their scores (sorted by score):");}
        for(int i=0; i<words.size();i++)
        {
            System.out.println(scoreTable.getScore(words.get(i))+": "+words.get(i));

        }
    }
    /**
    Sort all words in the ArrayList by using Collection.sort method using
     WordScoreComparator
     */
    private void sortWordsByDecreasingOrder()
    {
        Collections.sort(words, new WordScoreComparator());
    }
    /**
    A Compparator that compares two String by its score value get from the
     ScoreTable in decreasing order OR string with higher score value
     come before String with lower score value.
     For Strings that have the same score value, they will be compared alphabetically
     e.g. 'a' come before 'b', 'bz' come before 'ca'
     */
    class WordScoreComparator implements Comparator<String>
    {
        public int compare(String a, String b)
        {
            if(scoreTable.getScore(b)- scoreTable.getScore(a)==0)
            {
                //Compare two String alphabetically when their score are the same
                return a.compareTo(b);
            }
            return scoreTable.getScore(b)- scoreTable.getScore(a);
        }
    }
}
