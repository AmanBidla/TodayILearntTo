import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class BullsEye implements Runnable {
 
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
 
        public static void main(String[] args) {
                new Thread(null, new BullsEye(), "", 256 * (1L << 20)).start();
        }
 
        public void run() {
                try {
                        long t1 = System.currentTimeMillis();
                        if (System.getProperty("ONLINE_JUDGE") != null) {
                                in = new BufferedReader(new InputStreamReader(System.in));
                                out = new PrintWriter(System.out);
                        } else {
                                in = new BufferedReader(new FileReader("A-small-practice.in"));
                                out = new PrintWriter("output.out");
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
                int total = readInt();
                long [] sol = new long[total];
                int index=0;
                while(total>0){
                        total--;
                        long area=0,count=0;
                        long r= readLong();
                        long t=readLong();
                        long totalArea=0;
                        long r1=r;
                        long r2=r1+1;
                        while(totalArea<=t){
                                area=(r2*r2)-(r1*r1);
                                if((area+totalArea)<=t){
                                        totalArea+=area;
                                        r1=r2+1;
                                        r2=r1+1;
                                        count++;                                        
                                        if(totalArea<=10)
                                        System.out.println("total area "+totalArea);

                                }else{
                                        break;
                                }
                        }
                        sol[index]=count;
                        index++;
                }
                for(int i=0;i<sol.length;i++){
                        long team = sol[i];
                        String sb="Case #"+(i+1)+": "+team;                         
                        out.println(sb);
                 }

                
        }
 
}