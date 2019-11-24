// Name: Tianchen Zhang
// USC NetID: 4347909915
// CS 455 PA4
// Fall 2019

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   

   private File dictionary; //dictionary object used by constructor
   private Scanner scan; //Scanner object used by constructor.
   private Map<String, ArrayList<String>> dictionaryMap = new HashMap<>(); //A HashMap for storing a dictionary.
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      this.dictionary = new File(fileName);
      this.scan = new Scanner(dictionary);
      setDictionaryMap(scan);
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      return dictionaryMap.get(sortCharactersOfString(s));
   }

   /**
     Associate all words in a dictionary with its sorted String in a HashMap.
     A sorted String can link to multiple words.
     One word can only link to one sorted String.
     E.g. Both "battle" and "tablet" are linked to "abeltt".
     @param scan Scanner implemented in the constructor which takes a dictionary file.
    */
   private void setDictionaryMap(Scanner scan)
   {
      while(scan.hasNext())
      {

         String temp = scan.next();
         String tempSorted = sortCharactersOfString(temp);
         ArrayList<String> arr = dictionaryMap.get(tempSorted);
         if(arr==null)
         {
            arr = new ArrayList<>();
            arr.add(temp);
            dictionaryMap.put(tempSorted, arr);
         }
         else
         {
            arr.add(temp);
         }
      }
   }
   /**
    Get the sorted version of a input String using standard Collection.sort();
    @param s string to process
    @return sorted version of s
    */
   private static String sortCharactersOfString(String s)
   {
      ArrayList<Character> wordChars = new ArrayList<>();
      while(s.length()>0)
      {
         wordChars.add(s.charAt(0));
         s=s.substring(1);
      }
      Collections.sort(wordChars);
      StringBuilder word = new StringBuilder(wordChars.size());
      for(Character letter: wordChars)
      {
         word.append(letter);
      }
      String sortedString = word.toString();
      return sortedString;
   }
}
