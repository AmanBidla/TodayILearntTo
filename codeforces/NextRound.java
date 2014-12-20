import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class NextRound implements Runnable {
 
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new NextRound(), "", 256 * (1L << 20)).start();
        }
 
        public void run() {
                try {
                        long t1 = System.currentTimeMillis();
                        if (System.getProperty("ONLINE_JUDGE") != null) {
                                in = new BufferedReader(new InputStreamReader(System.in));
                                out = new PrintWriter(System.out);
                        } else {
                                in = new BufferedReader(new FileReader("input.txt"));
                                out = new PrintWriter("output.txt");
                        }
                        Locale.setDefault(Locale.US);
                        solve();
                        in.close();
                        out.close();
                        long t2 = System.currentTimeMillis();
//                        System.err.println("Time = " + (t2 - t1));
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
 
        // NextRound
 
        void solve() throws IOException {
                 
                 int n= readInt();
                 int k = readInt();
                 int [] array = new int[n];
                 int limit=0;
                 for( int i=0;i<n;i++){
                        array[i]=readInt();
                        if(i+1 == k){
                                limit = array[i];
                        }
                 }
                 
                 System.out.println("n is "+n+" k is ");                  
                 int count=0;                
                 for(int i=0;i<array.length;i++){
                        if(limit!=0 && array[i]>=limit){
                                count++;
                                System.out.println(array[i]+" count : "+count);
                        }else{
                                break;
                        }
                 }
                 System.out.println(count);

        }
 
}