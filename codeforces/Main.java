import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Main implements Runnable {
 
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new Main(), "", 256 * (1L << 20)).start();
        }
 
        public void run() {
                try {
                        long t1 = System.currentTimeMillis();
                        in = new BufferedReader(new InputStreamReader(System.in));
                        out = new PrintWriter(System.out);
                        Locale.setDefault(Locale.US);
                        solve();
                        in.close();
                        out.close();
                        long t2 = System.currentTimeMillis();
                        //System.err.println("Time = " + (t2 - t1));
                } catch (Throwable t) {
                        t.printStackTrace(System.err);
                        System.exit(-1);
                }
        }
 
        String readString() throws IOException {
                while (!tok.hasMoreTokens()) {
                        tok = new StringTokenizer(in.readLine());
                }
                return tok.nextToken();
        }
 
        int readInt() throws IOException {
                return Integer.parseInt(readString());
        }
 
        long readLong() throws IOException {
                return Long.parseLong(readString());
        }
 
        double readDouble() throws IOException {
                return Double.parseDouble(readString());
        }
 
        // solution
 
        void solve() throws IOException {
                
            
            int tests = readInt();
            String [] sol = new String[tests];
            int i=0;
            while(tests>0){
                tests--;
                String line = readString();
                char R = line.charAt(0);
                char RPLUS1 = line.charAt(1);
                if(R=='R' &&  Character.isDigit(line.charAt(1)) && line.indexOf("C")!=-1){
                    sol[i]=covertToVersion1(line);                    
                }else{
                    sol[i]=covertToVersion2(line);
                }
                i++;
            }       
            for(String S:sol){
                System.out.println(S);
            }             
                
        }

        String covertToVersion1(String S){
            //System.out.println("first one");
            int indexOfC = S.indexOf("C");
            String colNum = S.substring(1,indexOfC);
            String rowNum = S.substring(indexOfC+1);
            int tr = Integer.parseInt(rowNum);
            StringBuilder buf = new StringBuilder();
            int rem=0;
            while(tr>=26){
                int t = 'A' + (tr/26)-1;
                char l = (char) t;
                buf.append(l);
                //System.out.println(buf.toString());
                tr=tr/26;
                rem = tr%26;
                //System.out.println("tr "+tr);
            }
            //System.out.println("rem "+rem);
            if(rem!=0){                
                int  t = 'A' + (rem);
                //System.out.println("t "+t);
                char l = (char) t;
                //System.out.println("l "+l);
                buf.append(l);
                //System.out.println(buf.toString());                
            }

            buf.append(colNum);
            return buf.toString();

        }
       String covertToVersion2(String S){
            //System.out.println("second one");
            StringBuilder buf = new StringBuilder();
            buf.append("R");
            int indexOfRow=-1;
            for(int i=0;i<S.length();i++){
                char c = S.charAt(i);
                if(c>='A' && c<='Z') continue;
                else{
                    indexOfRow=i;
                    break;
                }
            }
            
            String colNum= S.substring(0,indexOfRow);
            String rowNum = S.substring(indexOfRow);
            int col = Integer.parseInt(rowNum);
            buf.append(rowNum);
            buf.append("C"); 
            int tr =0;
            for(int i=0;i<colNum.length();i++){
                char l = colNum.charAt(i);
                //int t = l-'A'+1;
                //tr+=t*26;
                tr= tr*26+ (l-'A'+1);
                //System.out.println("tr "+tr);
            }/*
            if(colNum.length()>1){ 
                char l=(colNum.charAt(colNum.length()-1));             
                int t = l-'A'+1;             
                tr+=t;
            }*/
            buf.append(tr);
            return buf.toString();
        }
 
}