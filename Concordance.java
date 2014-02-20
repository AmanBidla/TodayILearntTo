import java.util.*;
import java.io.*;

/**
 * Generates and prints a concordance from a text document written in English.
 */
public class Concordance
{
    /**
     * Stores English words in lowercase as keys and the related Word objects as values. 
     * Each Word Object can be used to extract the frequency of the word 
     * and the sentence numbers in which the word appeared. 
     * TreeMaps is used to store keys as TreeMap stores the data in a sorted tree structure.  
     * TreeMap will store the Word Objects in alphabetical order by default as they are lowercase.
     */
    private static TreeMap<String, Word> concordanceWordMap = new TreeMap<String, Word>(); 

    /**
     * The current sentence number in the document that is being read.
     */
    private static int sentenceNumber= 1;

   /**
    * A String representation of the contents of the file document.
    */
    private static String fileContent;

   /*
    * The length of the String representation of the file document.
    */
    private static int length;

    /* current index of the document */
    private static int currentIndex = 0;


    /**
    * create concordance reads word by word from the 
    * document and checks if the the word is present
    * in the concordanceWordMap. If the word is present
    * in the concordanceWordMap then 
    *   1.increment the word count from the value ( Word Object )
    *   2. add the sentence number to the key.
    *   3. Update the concordanceWordMap with new updated value
    * 
    *  
    */
    private static void generateConcordance(){
        while(currentIndex<length){
            //System.out.println("finding next word ");
            String current = readNextWord();
            //System.out.println("next word is "+current);
            Word w = new Word(current);
            if(concordanceWordMap.containsKey(current)) {
                w = concordanceWordMap.get(current);
            }
            w.incrementCount(); //increment frequency by 1
            //System.out.println("sentence is "+sentenceNumber);
            w.addSentenceNumber(sentenceNumber); // add sentence number where word is found 
            concordanceWordMap.put(current, w); //insert updated word object back to map
        }
    }

    /** 
    *  readNextWord read the next word from the input file
    *  character by character. If the character is while space
    *  then word end is noted. If character is '.' then it is 
    *  either end of word (period ) or abbreviations like 'i.e'.  
    *  check abbreviations by comparing the current length and index of
    *  '.' in the word.
    *  append the characters as individual words
    *  increment the sentence numbers 
    *  return the lowercase representation of individual word 
    *
    * @param() 
    * @return String (lower case representation of individual word)
    */
    private static String readNextWord(){
        StringBuffer individualWord = new StringBuffer();
        //System.out.println("current index is "+currentIndex+" and length is "+length);
	   while(currentIndex<length){
            char ch = fileContent.charAt(currentIndex);
            currentIndex++;
            if(Character.isWhitespace(ch)){ //end of word
                break;
            } else if(Character.isLetter(ch)) { //append all letters
                individualWord.append(ch);
            } else if(ch=='.') { //abbreviations like 'i.e.' if there are periods between letters
                if (currentIndex<length && (Character.isLetter(fileContent.charAt(currentIndex)) || fileContent.charAt(currentIndex-3)=='.')){
                    //System.out.println("fileContent.charAt(currentIndex) "+fileContent.charAt(currentIndex)+" and fileContent.charAt(currentIndex-3) "+fileContent.charAt(currentIndex-3));
                    individualWord.append(ch); //append the period if the next character is a letter or if there was a period two characters before the current one
                }
            }

            // new sentence if we find a period followed by an uppercase letter
            if((currentIndex>2 && fileContent.charAt(currentIndex-3) == '.') && Character.isUpperCase(ch)){
                //System.out.println("fileContent.charAt(currentIndex-3) "+fileContent.charAt(currentIndex-3)+"fileContent.charAt(currentIndex) "+fileContent.charAt(currentIndex));
                sentenceNumber++;
            } 
        }
        //System.out.println("current index is "+currentIndex+" and length is "+length);
        //System.out.println("individual word is "+individualWord.toString().toLowerCase());
        return individualWord.toString().toLowerCase();
    } 
    
    /** 
    * print concordance prints the frequencies ,word and word count and sentence numbers 
    * Iterate over all the keys (Word object) in concordanceWordMap
    * for each key in Keyset of concordanceWordMap
    * retrieve the value (word) from concordanceWordMap
    * sentence is substring from 1 and length of sentence -1 after replacing all spaces with ""
    * format and print the output to console
    */
    private static void outputConcordance(){
            Set<String> keySet = concordanceWordMap.keySet();
            int counter = 1;
            for (String s : keySet) {
                Word word = concordanceWordMap.get(s);
                String sentences = word.getSentenceNumbers().toString();
                sentences = sentences.substring(1, sentences.length()-1).replaceAll("\\s","");
                Formatter formatter = new Formatter();
                System.out.println(formatter.format("%-5s %-20s %-20s", getAlpha(counter)+".", word.getWord(), "{" + word.getCount() + ":" + sentences + "}"));
                counter++;
            }
    }

    /** 
    * getAlpha accepts a number that maps number to alphabets
    *  a is denoted by 1 and z is denoted by 26 
    *  Note 0 is not denoted by a
    *  to represent in unicode value add 97 ( 97 is lower case for a )
    * append the unicode representation to String to return the lower case
    * representation of the this String 
    *
    * @param (int (number))
    * @return (String appended unicode representation)
    */

    private static String getAlpha(int num) {
            StringBuffer result = new StringBuffer();
            num--; //so 1 => 'a', not 0 => 'a'
            int remainder = (num) % 26;
            char digit = (char) (remainder + 97); //add to unicode value of 'a'
            for(int i = num/26; i>=0; i--) {
                    result.append(digit); //keep inserting the same digit
            }
            return result.toString();
    }

 
 /** 
 * fileToString uses Scanner class to read 
 * a file line by line and stores the string
 * representation of each line in fileContent.
 * 
 * @params(String (name of file to be read))
 */
private static void fileToString(String fileName) {
        try{
            StringBuffer content = new StringBuffer();
            Scanner reader = new Scanner(new File(fileName));
            while(reader.hasNext()) {
                content.append(reader.nextLine());
            }
            reader.close();
            fileContent = content.toString();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }}

    /**
    * MAIN program
    * read the argument provided by user
    * if argument length is 1 then read the file where args[0] is the file name
    * if argument length is not 1 then use the default content as file string
    */
    public static void main(String args[]){
            if (args.length == 1) {
                    System.out.println("----------------------");
                    System.out.println("reading from "+args[0]);
                    System.out.println("----------------------");
                    fileToString(args[0]);
                 
            }else{
                fileContent = "Given an arbitrary text document written in English, write a program that will generate a concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. Bonus: label each word with the sentence numbers in which each occurrence appeared.";                
            }
            
		    length = fileContent.length();
        	generateConcordance();
            outputConcordance();
    }
}