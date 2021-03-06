import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class TheatreSquare implements Runnable {
 
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
                
                long m = readLong();
                long n = readLong();
                long a = readLong();

                if(m==1 && n==1) System.out.println(1);
                else if(m==n && n==a) System.out.println(1);
                //else if(a==1) System.out.println(m*n);
                else{
                    
                    long rows =0;
                     if((m%a)!=0){
                        //System.out.println("m "+m);
                        rows = m/a;
                        rows++;
                        //System.out.println("m "+m);
                     }else{
                        rows = m/a;
                     }
                     long cols=0;
                     if(n%a!=0){
                        cols = n/a;
                        cols++;
                        //System.out.println("n "+n);
                     }else{
                        cols=n/a;
                     }
                        
                      System.out.println( rows*cols);
                     


                    //System.out.println(N);
                    //N+=1;
                    
                }
                    
                
        }
 
}