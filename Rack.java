// Name: Tianchen Zhang
// USC NetID: 4347909915
// CS 455 PA4
// Fall 2019

import java.util.*;

/**
 *This is the rack for scrabble tiles. It is for finding words in the dictionary
 * The class works by finding matching pair of a subset of a String with one in the dictionary
 * and stores all finding.
 * */

public class Rack {


   private ArrayList<String> subSets; //Store subsets generated from an unique word
   private ArrayList<String> words = new ArrayList<>(); //Store words from the dictionary.
   private AnagramDictionary anagramDictionary; //The dictionary used to lookup subsets Strings of the unique word

   /**
    * Class constructor for Rack class.
    * @param anagramDictionary the dictionary used to find anagrams
    * @param k the starting index of a String. e.g. k=1 for "hello" is "llo";
    * @param string the string for generating subsets.
    */
   public Rack(AnagramDictionary anagramDictionary, int k, String string){
      this.anagramDictionary = anagramDictionary;
      getAllSubsetsString(string, k);
   }

   /**
    * Find the anagrams of Strings in the subSets by
    * checking the anagramDictionary using getAnagramsOf method.
    * Words that are anagrams of that String will be added to the
    * words ArrayList.
    * @return an ArrayList of words.
    */
   public ArrayList<String> getAllWords()
   {
      for(int i = 0; i< subSets.size(); i++)
      {
         ArrayList<String> temp = anagramDictionary.getAnagramsOf(subSets.get(i));
         if(temp!=null)
         {
            for(int j=0; j<temp.size();j++)
            {
               words.add(temp.get(j));
            }
         }
      }
      return words;
   }
   /**
    *Find letter occurrence of each letter in a String passed in
    * E.g."aaabba" has an occurences of 4 for letter 'a'
    * and 2 for letter 'b'
    * Construct the unique letter based on previous finding.
    * Calls allSubsets helper method to find all subsets
    * @param str a regular string passed from other method.
    * @param k the smallest index of str considered.
    */
   private void getAllSubsetsString (String str, int k)
   {
      HashMap<Character, Integer> map = new HashMap<>();
      for(int i=0; i<str.length();i++)
      {
         char temp = str.charAt(i);
         if(map.get(temp)!=null)
         {
            int count = map.get(temp);
            count++;
            map.put(temp, count);  //add 1 to the value if same found same key in HashMap
         }
         else
         {
            map.put(temp,1); //set value to 1 with new Character as the key
         }
      }
      int[] mult = new int[map.size()];
      StringBuilder sb = new StringBuilder(map.size());
      Iterator<Map.Entry<Character,Integer>> entrySet = map.entrySet().iterator();//Iterator for all entry in HashMap
      for(int i=0; i<mult.length;i++)
      {
         Map.Entry<Character,Integer> entry = entrySet.next();
         mult[i] = entry.getValue();
         sb.append(entry.getKey());
      }
      String unique = sb.toString();
      subSets = allSubsets(unique, mult,k);
   }

   /**
    Finds all subsets of the multiset starting at position k in unique and mult.
    unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    unique.charAt(i).
    PRE: mult.length must be at least as big as unique.length()
    0 <= k <= unique.length()
    @param unique a string of unique letters
    @param mult the multiplicity of each letter from unique.
    @param k the smallest index of unique and mult to consider.
    @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
    each subset is represented as a String that can have repeated characters in it.
    @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      return allCombos;
   }
}
