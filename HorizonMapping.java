 
import java.util.*;
    
class Building {
        int left;
        int right;
        int height;
        public Building(int l, int h, int r) {
            left=l;
            right=r;
            height=h;
        }
        @Override
        public String toString() {
            return  "("+left+","+height+")";
        }
}

class Strip{

    int x,ht;
    public Strip(int x, int ht){
        this.x=x;
        this.ht=ht;
    }
}


class Skyline{

    Strip [] strips;
    int count;
    int startLoc;

    public Skyline(int N){

        count=0;
        startLoc=0;
        strips= new Strip[N];
    }


    public void add(Strip S){
        strips[startLoc+count]=S;
        count++;
    }

    public Strip head(){
        return strips[startLoc];
    }

    public Strip removeHead(){
        Strip strip = strips[startLoc];
        count--;
        startLoc++;
        return strip;
    }

    public String toString(){
        String str="";
        Strip prev = strips[startLoc];
        str= prev.x+","+prev.ht;
        for(int i=(startLoc+1);i<(startLoc+count);i++){
            Strip curr = strips[i];
            if(prev.ht==curr.ht) continue;
            else{
                str+=",";
                str+=curr.x+","+curr.ht;
                prev=curr;
            }
            
        }

        return "("+str+")";
    }

}

public class HorizonMapping  {

    
    public static void main(String[] args) {
        
        Building[] buildings = new Building[8];
        buildings[0]=new Building(1,11,5);
        buildings[1]=new Building(2,6,7);
        buildings[2]=new Building(3,13,9);
        buildings[3]=new Building(12,7,16);
        buildings[4]=new Building(14,3,25);
        buildings[5]=new Building(19,18,22);
        buildings[6]=new Building(23,13,29);
        buildings[7]=new Building(24,4,28);

        Skyline  result = findSkyline(buildings,0,7);
        System.out.println(result.toString());

 
        //Example output: 1, 11, 3, 13, 9, 0, 12, 7, 16, 3, 19, 18, 22, 3, 23, 13, 29, 0 
        //(1,11, 3,13, 9,0, 12,7, 16,3, 19,18, 22,3, 23,13, 29,0)
        //(1,11, 3,13, 9,0, 12,7, 16,3, 19,18, 22,3, 23,13, 29,0)

    }


    public static Skyline findSkyline(Building [] buildings, int lo, int hi){

        if(lo==hi){


            Skyline sk = new Skyline(2);
            int left = buildings[lo].left;
            int height = buildings[lo].height;
            int right = buildings[lo].right;
            Strip S0 = new Strip(left,height);
            Strip S1 = new Strip(right,0);
            sk.add(S0);
            sk.add(S1);
            return sk;
        }

        int mid = (lo+hi)/2;
        Skyline sk1 = findSkyline(buildings,lo,mid);
        Skyline sk2 = findSkyline(buildings,mid+1,hi);
        return merge(sk1,sk2);
    }

    public static Skyline merge(Skyline sk1, Skyline sk2){

        Skyline result = new Skyline(sk1.count+sk2.count);
        int h1=0,h2=0;
        while(sk1.count>0 && sk2.count>0){

            if(sk1.head().x < sk2.head().x ){

                int currX = sk1.head().x;
                h1 = sk1.head().ht;
                int currH = Math.max(h1,h2);
                Strip currStrip = new Strip(currX,currH);
                result.add(currStrip);
                sk1.removeHead();

            }else{

                int currX = sk2.head().x;
                h2 = sk2.head().ht;
                int currH = Math.max(h1,h2);
                Strip currStrip = new Strip(currX,currH);
                result.add(currStrip);
                sk2.removeHead();
            }
        }

        while(sk1.count>0){
            Strip sk = sk1.removeHead();
            result.add(sk);
        }

        while(sk2.count>0){
            Strip sk = sk2.removeHead();
            result.add(sk);
        }

        return result;
    }



      

 
} 