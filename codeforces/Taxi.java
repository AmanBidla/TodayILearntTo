import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Taxi implements Runnable {
 
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new Taxi(), "", 256 * (1L << 20)).start();
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
 
        // solution
 
        void solve() throws IOException {
                int n = readInt();
                int [] array = new int[n];
                for(int i=0;i<n;i++){
                        array[i]= readInt();
                }
                Arrays.sort(array);
                int st=0;
                int end = array.length-1;
                int total=0;
                int remaining=0;
                while(st<end){
                    if(remaining==0)
                        remaining = array[st]+array[end];
                    else
                        remaining = remaining +  array[end];
                    if(remaining<4){
                        st++;
                        end--;
                        remaining+=array[st];
                        //System.out.println("st "+st+" end "+end+" remaining "+remaining+" total "+total);
                    }else if(remaining==4){
                        st++;
                        end--;
                        total++;
                        remaining=0;       
                        //System.out.println("st "+st+" end "+end+" remaining "+remaining+" total "+total+" equal to 4");
                    }else if(remaining>4){
                        //System.out.println("remaining is "+remaining+" end is "+array[end]+" neg "+(remaining-array[end]));
                        if(end>-1)
                                remaining-=array[end];
                        end--;
                        total++;                        
                //System.out.println("st "+st+" end "+end+" remaining "+remaining+" total "+total+" greater than 4");
                    }

                   //System.out.println("st "+st+" end "+end);

                }
                if(remaining>0){
                        total++;
                }
                System.out.println(total);
        }
 
}