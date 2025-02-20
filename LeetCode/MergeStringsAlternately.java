/*
 * 1768. Merge Strings Alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 * 
 * - Complejidad:
 *     - Tiempo: O(n),
*/
class MergeStringsAlternately {
    public String solution(String word1, String word2) {
        String mergeWord ="";

        String longestWord = (word1.length() >= word2.length())? word1: word2;

        for( int i = 0; i < longestWord.length() ; i++){
            if (word1.length() > i)mergeWord += String.valueOf(word1.charAt(i));
            if (word2.length() > i)mergeWord += String.valueOf(word2.charAt(i));
        }

        return mergeWord;
    }
}