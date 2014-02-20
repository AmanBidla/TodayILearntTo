import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.HashMap;

/**
 * Concordance application - see 
 * http://www.sicsa.ac.uk/events/sicsa-multicore-challenge-phase-i-concordance-application
 * for spec
 */

public class Concord {
    
    public int N;  // max word length of phrases to store in concordance
    public String f; // input file name

    Vector<String> text; // Vector, single word per element, stores all words in text file
    HashMap<String,Vector<Integer>> concordance; /* map from string to list of offsets in text
                                                                          * vector where
                                                                          * that phrase begins
                                                                          */

    public static void main(String [] args) {
        // require 2 args
        // N is max length of phrases, in words, that are
        // stored in concordance
        // f is input text file.
        if (args.length != 2) {
            System.err.println("usage: java Concord N filename");
            System.exit(-1);
        }
        int N = Integer.parseInt(args[0]);
        String f = args[1];
        
        Concord c = new Concord(N,f);

        // read text input file to memory (text vector)
        System.out.println("init: #words is " + c.text.size());
        c.readInputFile();
        System.out.println("read input file: #words is " + c.text.size());
        
        // generate concordance (populate concordance hashmap)
        System.out.println("init: #entries is " + c.concordance.keySet().size());
        c.createConcordance();
        System.out.println("final: #entries is " + c.concordance.keySet().size());

        // debug: print out concordance to stdout (can pipe to file)
        c.printConcordance();
    }

    /**
     * constructor
     *  @arg N - max word length of phrases to store in concordance
     *  @arg f - input text file to process and generate concordance
     */
    public Concord(int N, String f) {
        // copy over cmd-line parameters
        this.N = N;
        this.f = f;

        // initialize empty Vector for text
        text = new Vector<String>();
        // initialize empty concordance 
        concordance = new HashMap<String,Vector<Integer>>();
    }

    /**
     * reads the input file from disk,
     * tokenizes it into separate words
     * (words are space-separated).
     * Reads the _entire_ input file into
     * a single Vector in memory, each word
     * is a separate element
     */
    public void readInputFile() {

        try {
            // use buffering, reading one line at a time
            BufferedReader input =  new BufferedReader(new FileReader(f));
            try {
                String line = null; //not declared within while loop
                
                while (( line = input.readLine()) != null) {
                    // tokenize line into individual space-separated words
                    // add these one-by-one to the Vector
                    
                    // FIXME - we can add a filter here to prevent
                    // some words from being added to the text vector...
                    if (line.length() == 0) continue;

                    String [] words = line.split(" ");
                    for (int i=0; i<words.length; i++) {
                        text.add(words[i]);
                    }
                    
                }
            }
            finally {
                input.close();
            }
        }
        catch (IOException e) {
            System.err.println("readInputFile: I/O exception ... " + e.getMessage());
            e.printStackTrace();
        }
    
        return;

    } // readInputFile()
    
    
    /**
     * iterates over text vector, for each phrase, insert its index
     * into the concordance HashMap
     */
    public void createConcordance() {
        int index = 0;
        while (index < text.size()) {
            // construct phrases at this index, lengths up to N words
            // for each phrase, add <phrase, index> to concordance
            int maxPhraseLength = N;
            if (index + N > text.size()) {
                maxPhraseLength = (index + N) - text.size();
            }
            StringBuffer phrase = new StringBuffer("");
            for (int i=0; i<maxPhraseLength; i++) {
                phrase.append(text.get(index+i));
                String concordanceEntry = phrase.toString();
                Vector<Integer> v = concordance.get(concordanceEntry);
                if (v == null) {
                    // set up new list for this entry, since it 
                    // is the first time we have seen it

                    // FIXME - concerns about memory bloat - default sizes of Vector too large...
                    v = new Vector<Integer>();
                    concordance.put(concordanceEntry,v);
                }
                v.add(index); // put the start-index for this phrase
            
                // now add space to end of phrase
                phrase.append(" ");
            } // end for
            // now advance to next index position in text vector
            index++;
        } // end while
        
    } // createConcordance()

    /**
     * print concordance to stdout, for debugging purposes
     */
    public void printConcordance() {
        // iterate over all entries in the concordance, print out list of start indices
        for (String entry : concordance.keySet()) {
            Vector<Integer> indices = concordance.get(entry);
            
            // print out the phrase String
            System.out.print(entry);
            System.out.print(":");
            // print out the list of indices where this phrase occurs
            for (Integer i : indices) {
                System.out.print(i.toString() + " ");
            }
            System.out.println("");
        }
    } // printConcordance()
}