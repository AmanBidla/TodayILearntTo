import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;


public class PDFReader {

	
	public static void main(String[] args) {
		readFile();
	}
	
	private static void readFile(){
		String url ="http://www.hafl.bfh.ch/fileadmin/docs/Forschung_Dienstleistungen/Agrarwissenschaften/Nachhaltigkeitsbeurteilung/DUE_Art_EMILI_fulltextC.Haeni.pdf";
 		try {
			PdfReader reader = new PdfReader(url);
			String txt = "output.txt";
			   PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
		        PrintWriter pdftext = new PrintWriter(new FileOutputStream("pdftext"));
 		        TextExtractionStrategy strategy;
		        Trie trie = new Trie((char)0,null);
		        int totalWords =0;
		        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
		            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
		            String key = strategy.getResultantText();
		            key = key.replace("\n", "").replace("\r", "");

		            
		            String [] words = key.split(" ");
		            totalWords+=words.length;
		            for(String st:words)
		            	trie.insert(st.toCharArray(), 0);
		            pdftext.println(key); 		            	
		            System.out.println("i = "+i);
		        }
		        
		        reader.close();
		        
		        Heap<Trie> heap = new Heap<Trie>( 100, Trie.getComparator() );
		        for( Trie t : trie ){
		        	heap.add(t);
		        }
		        
		        for( Trie t : heap ){
		        	System.out.println(t + "\t:>>" + t.occurrence );
		        	out.println(t + "\t:>>" + (t.occurrence/totalWords)*100 );
		        }
		        out.flush();
		        out.close();
		        pdftext.flush();
		        pdftext.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
