import java.util.*;

/**
 * Represents a word of the English alphabet.
 */
public class Word {
    
    /**
     * The String representation of the Word.
     */
    private String value;
    
    /**
     * The frequency of the value of the Word.
     */
    private int count;
    
    /**
     * The sentence numbers in which the value of the Word has appeared.
     */
    private LinkedList<Integer> sentenceNumbers;
    /**
     * Creates a new Word. The value should be the English representation of the Word.
     * each word is stored in sentence.
     */
    public Word(String s) {
    	this.value = s;
    	this.sentenceNumbers = new LinkedList<Integer>();
    }
        
    /**
     * Adds the sentence number in which the Word's value has appeared.
     * @param num an integer representation of a sentence in which this Word's value has appeared.
     */
    public void addSentenceNumber(int num) {
    	this.sentenceNumbers.add(num);
    }
    
    /**
     * Increments this Word's frequency by 1.
     */   
    public void incrementCount() {
    	this.count++;
    }
   
    /**
     * getWord returns the value of the Word.
     * @return value of this Word.
     */
    public String getWord() {
    	return this.value;
    }
    
    /**
     * getSentenceNumbers gets the sentence numbers in which the Word has appeared.
     * @return sentence number where this word appeared
     *
     */
    public LinkedList<Integer> getSentenceNumbers() {
       	return this.sentenceNumbers;
    }
    
    /**
     * getCount gets the frequency of the Word.
     * @return the number of times this Word's value has appeared.
     */
    public int getCount() {
     	return this.count;
    }
}