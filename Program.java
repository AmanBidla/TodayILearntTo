import java.util.*;
import java.io.*;

/**
 * Generates and prints a concordance from a text document written in English.
 */
public class Program
{
    /**
     * Stores English words in lowercase as keys and the related Word objects as values. 
     * Each Word Object can be used to extract the frequency of the word 
     * and the sentence numbers in which the word appeared. 
     * TreeMaps is used to store keys as TreeMap stores the data in a sorted tree structure.  
     * TreeMap will store the Word Objects in alphabetical order by default as they are lowercase.
     */
    private static TreeMap<String, Word> word_map = new TreeMap<String, Word>(); 

    /**
     * The current sentence number in the document that is being read.
     */
    private static int sentenceNumber= 1;

   /**
    * A String representation of the contents of the document.
    */
    private static String fileContent;

   /**
    * The length of the String representation of the document.
    */
    private static int length;


    private static int currentIndex = 0;
private static void createConcordance(){
        while(currentIndex<length){
            String current = readNextWord();
            Word w = new Word(current);
            if(word_map.containsKey(current)) {
                w = word_map.get(current);
            }
            w.incrementCount(); //add 1 to the frequency
w.addSentenceNumber(sentenceNumber);
            word_map.put(current, w); //put the Word in the concordance
        }
    }
private static String readNextWord(){
        StringBuffer individualWord = new StringBuffer();
	   while(currentIndex<length){
            char ch = fileContent.charAt(currentIndex);
            currentIndex++;
            if(Character.isWhitespace(ch)){ //end of word
                break;
            } else if(Character.isLetter(ch)) { //append all letters
                individualWord.append(ch);
            } else if(ch=='.') { //abbreviations like 'i.e.' if there are periods between letters
                if (currentIndex<length && (Character.isLetter(fileContent.charAt(currentIndex)) || fileContent.charAt(currentIndex-3)=='.')){
                    individualWord.append(ch); //append the period if the next character is a letter or if there was a period two characters before the current one
                }
            }

            // new sentence if we find a period followed by an uppercase letter
            if((currentIndex>2 && fileContent.charAt(currentIndex-3) == '.') && Character.isUpperCase(ch)){
                sentenceNumber++;
            } 
        }
        return individualWord.toString().toLowerCase();
    } 
private static void printConcordance(){
            Set<String> keySet = word_map.keySet();
            int num = 1;
            for (String s : keySet) {
                Word word = word_map.get(s);
                String sentences = word.getSentenceNumbers().toString();
                sentences = sentences.substring(1, sentences.length()-1).replaceAll("\\s","");
                Formatter formatter = new Formatter();
                System.out.println(formatter.format("%-5s %-20s %-20s", getAlpha(num)+".", word.getWord(), "{" + word.getCount() + ":" + sentences + "}"));
                num++;
            }
    }

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

    
private static void fileToString(String fileName) {
        try{
            StringBuffer str = new StringBuffer();
            Scanner reader = new Scanner(new File(fileName));
            while(reader.hasNext()) {
                str.append(reader.nextLine());
            }
            reader.close();
            fileContent = str.toString();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }}

    public static void main(String args[]){
            fileContent = "Given an arbitrary text document written in English, write a program that will generate a concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. Bonus: label each word with the sentence numbers in which each occurrence appeared.";            
		    length = fileContent.length();
        	createConcordance();
            printConcordance();
    }
}