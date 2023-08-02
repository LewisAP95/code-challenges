import java.util.ArrayList;

public class App {
    //Problem description: Given a list of words, find all pairs of unique indices such that the concatenation of the two words is a palindrome.
    //For example, given the list ["code", "edoc", "da", "d"], return [(0, 1), (1, 0), (2, 3)].

    public static void main(String[] args) throws Exception {
        String[] sourceWords = {"code", "edoc", "da", "d"};
        System.out.println(pairChecker(sourceWords));
    }

    public static ArrayList<String> pairChecker(String[] wordList){
        //Make an arraylist to export the comfirmed pairs
        ArrayList<String> palindromePairs = new ArrayList<String>();

        //For each word in the list, loop through the list again so that every pair is checked
        for(int i = 0; i < wordList.length; i++){
            for(int j = 0; j < wordList.length; j++){
                if(wordList[i] == wordList[j]){
                    //Skip comparing words to themselves
                    ;
                }else{
                    //Pass the current pair out to the palindrome checker, add their indices to the result list if the check comes back true
                    if(palindromeCheck(wordList[i], wordList[j])){
                        palindromePairs.add(String.format("(%s, %s)", i, j));
                    }
                }
            }
        }
        return palindromePairs;
    }

    public static boolean palindromeCheck(String firstWord, String secondWord){
        //Concats the two strings and then converts it to an array of chars for looping through
        char[] fullWord = (firstWord+secondWord).toCharArray();

        //Uses two counters, 'i' to check forward through the array, 'j' to check backwards through it
        //If the full word is palindromic the chars at these indices should always be the same as each other
        //Returns false if these ever do not match
        int j = fullWord.length - 1;
        for(int i = 0; i < fullWord.length; i++){
            if(fullWord[i] != fullWord[j]){
                return false;
            }
            j--;
        }
        return true;
    }
}
