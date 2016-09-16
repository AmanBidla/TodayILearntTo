 

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

class TaskOne implements Runnable {

    private Queue<Double> q1;
    private Queue<Double> q2;
    private Stream<Double> s;
    private Lock rLock;
    private SharedCalculate sh;


    public TaskOne(Queue<Double> q1, Queue<Double> q2, Stream<Double> s, Lock rLock, SharedCalculate sh) {
        this.q1 = q1;
        this.q2 = q2;
        this.s = s;
        this.sh =sh;
        this.rLock = rLock;
    }

    public void run() {

        Iterator<Double> iter = s.iterator();
        while(true){
            double val  = iter.next();
            //System.out.println("next value "+val+" in task two");
            rLock.lock();
            sh.calculate(q1,q2,val);
            rLock.unlock();
            if(!iter.hasNext()) break;
        }

    }

}

class TaskTwo implements Runnable {

    private Queue<Double> q1;
    private Queue<Double> q2;
    private Stream<Double>  s;
    private Lock rLock;
    private SharedCalculate sh;


    public TaskTwo(Queue<Double> q1, Queue<Double> q2, Stream<Double> s, Lock rLock, SharedCalculate sh) {
        this.q1 = q1;
        this.q2 = q2;
        this.s = s;
        this.sh =sh;
        this.rLock = rLock;
    }

    public void run() {

        Iterator<Double> iter = s.iterator();
        while(true){
            double val  = iter.next();
            //System.out.println("next value "+val+" in task two");
            rLock.lock();
            sh.calculate(q2,q1,val);
            rLock.unlock();
            if(!iter.hasNext()) break;
        }

    }

}

class Pair{
    double v1, v2;
    public Pair(double v1, double v2){
        this.v1 = v1;
        this.v2=v2;
    }

    @Override
    public String toString(){
        return "["+v1+","+v2+"]";
    }
}

class SharedCalculate {

    List<Pair> pairs = new ArrayList<Pair>();

    public void calculate(Queue<Double> q1, Queue<Double> q2, double val) {
         
        q1.offer(val);
 
        while(!q2.isEmpty() && q2.peek()-val>=1){
            q2.remove();
        }
         
        Iterator<Double> it = q2.iterator();
        while(it.hasNext()) {
            double num = it.next();
          
            if(Math.abs(num-val) < 1.0) {
           
                Pair pair = new Pair(num, val);
                pairs.add(pair);
                System.out.println(pair.toString());
            }
         }



    }

    public void showResult() {
        System.out.println("pair size "+pairs.size());
        for(Pair p : pairs){
            System.out.println(p.toString());
        }
    }
}




public class PrintTimeStampDiffWithThreads {

    public static void main(String[] args) {


        Lock rLock = new ReentrantLock();
        Queue<Double> q1 = new LinkedList<Double>();
        Queue<Double> q2 = new LinkedList<Double>();
        SharedCalculate sh = new SharedCalculate();


        Stream<Double> streamOne = Arrays.asList(0.2,1.4,3.0).stream();
        Stream<Double> streamTwo = Arrays.asList(1.0,1.1,3.5).stream();

        TaskOne taskOne = new TaskOne(q1,q2,streamOne,rLock,sh);
        TaskTwo taskTwo = new TaskTwo(q1,q2,streamTwo,rLock,sh);

        Thread t1 = new Thread(taskOne);
        Thread t2 = new Thread(taskTwo);

        t1.start();
        t2.start();



    }




}