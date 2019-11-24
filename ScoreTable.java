// Name: Tianchen Zhang
// USC NetID: 4347909915
// CS 455 PA4
// Fall 2019

/**This class has information about how much each scrabble letter is worth.
 * It contains getScore method which can calcuate the score for a String.
*(1 point)-A, E, I, O, U, L, N, S, T, R (2 points)-D, G
*(3 points)-B, C, M, P
*(4 points)-F, H, V, W, Y
*(5 points)-K
*(8 points)- J, X (10 points)-Q, Z
 * @author timzhang
* */
public class ScoreTable {

    private int[] alphabetScore = new int[26]; // store the English Alphabet by index and its letter score.
    /**
     * The constructor class that uses array index to represent letter
     * and stores associated value
     */
    public ScoreTable()
    {
        alphabetScore['A'-'A'] = 1;
        alphabetScore['E'-'A'] = 1;
        alphabetScore['I'-'A'] = 1;
        alphabetScore['O'-'A'] = 1;
        alphabetScore['U'-'A'] = 1;
        alphabetScore['L'-'A'] = 1;
        alphabetScore['N'-'A'] = 1;
        alphabetScore['S'-'A'] = 1;
        alphabetScore['T'-'A'] = 1;
        alphabetScore['R'-'A'] = 1;

        alphabetScore['D'-'A'] = 2;
        alphabetScore['G'-'A'] = 2;

        alphabetScore['B'-'A'] = 3;
        alphabetScore['C'-'A'] = 3;
        alphabetScore['M'-'A'] = 3;
        alphabetScore['P'-'A'] = 3;

        alphabetScore['F'-'A'] = 4;
        alphabetScore['H'-'A'] = 4;
        alphabetScore['V'-'A'] = 4;
        alphabetScore['W'-'A'] = 4;
        alphabetScore['Y'-'A'] = 4;

        alphabetScore['K'-'A'] = 5;

        alphabetScore['J'-'A'] = 8;
        alphabetScore['X'-'A'] = 8;

        alphabetScore['Q'-'A'] = 10;
        alphabetScore['Z'-'A'] = 10;
    }

    /**
    The method checks value of each letter in a String
     and sums up the total score by addition of values.
     Only checks English letter.
     @param s is the string to lookup its score.
     */

    public int getScore (String s)
    {
        int score = 0;
        s = s.toLowerCase();
        for(int i=0; i<s.length();i++)
        {
            score+=alphabetScore[s.charAt(i)-'a'];
        }
        return score;
    }
}
