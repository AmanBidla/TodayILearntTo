import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
 
class Point{

	int left,height;
	public Point(int left,int height){
		this.left=left;
		this.height=height;
	}
}

class Building{

	int left, height, right;
	public Building(int left, int height,int right){
		this.left=left;
		this.height=height;
		this.right=right;
	}
}
public class Skyline{

	public static void main(String[] args) {
		
		Building [] buildings = new Building[8];
		 buildings[0]=new Building(1,11,5);
        buildings[1]=new Building(2,6,7);
        buildings[2]=new Building(3,13,9);
        buildings[3]=new Building(12,7,16);
        buildings[4]=new Building(14,3,25);
        buildings[5]=new Building(19,18,22);
        buildings[6]=new Building(23,13,29);
        buildings[7]=new Building(24,4,28);

        List<Point> result = findSkyline(buildings,0,7);
        Point prev = result.get(0);
        String str=prev.left+","+prev.height;
        for(int i=1;i<result.size();i++){
        	Point curr = result.get(i);
        	if(curr.height==prev.height) continue;
        	else{
        		str+=", ";
        		str+=curr.left+","+curr.height;
        		prev=curr;
        	}
        }

        System.out.println("("+str+")");
	}

	public static  List<Point> findSkyline(Building[] array,int lo, int hi){


		if(lo==hi){

			Point p1 = new Point(array[lo].left,array[lo].height);
			Point p2 = new Point(array[lo].right,0);
			List<Point> list = new ArrayList<Point>();
			list.add(p1);
			list.add(p2);
			return list;
		}else{

			int mid = lo+(hi-lo)/2;

			List<Point> left = findSkyline(array,lo,mid);
			List<Point> right = findSkyline(array,mid+1,hi);
					 

			return merge(left,right);

		}

	}

	public static List<Point> merge(List<Point> sk1, List<Point> sk2){

		List<Point> result = new ArrayList<Point>();
		int i=0,j=0;
		int h1=0,h2=0;
		while(i<sk1.size() && j<sk2.size()){

			if(sk1.get(i).left < sk2.get(i).left){

				int pLeft = sk1.get(i).left;
					   h1 = sk1.get(i).height;
				int pHeight = Math.max(h1,h2);
				result.add( new Point(pLeft,pHeight));
				sk1.remove(i);
			}else{

					int pLeft = sk2.get(j).left;
					   h2 = sk2.get(j).height;
				int pHeight = Math.max(h1,h2);
				result.add( new Point(pLeft,pHeight));
				sk2.remove(j);
			}
		}

		while(i<sk1.size()){
			Point p = sk1.get(i);
			result.add(p);
			sk1.remove(i);
		}

		while(j<sk2.size()){
			Point p = sk2.get(j);
			result.add(p);
			sk2.remove(j);
		}

		return result;		

	}




}