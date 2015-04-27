import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.lang.*;
class Points2D implements Comparable<Points2D> {
	
	double x;
	double y;


	public Points2D(double x, double y){
		this.x=x;
		this.y=y;
	}

  public double distanceTo(Points2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

	public int compareTo(Points2D that){

		if(this.y<that.y) return -1;
		if(this.y>that.y) return  1;
		if(this.x<that.x) return -1;
		if(this.x>that.x) return  1;
		return 0;
	}

	public String toString(){

		String s = "("+this.x+","+this.y+")";
		return s;
	}

	public  final Comparator<Points2D> POLAR_ORDER = new PolarOrder();

	private  class PolarOrder implements Comparator<Points2D>{

		public int compare(Points2D q1, Points2D q2){

			double dx1 = q1.x-x;
			double dx2 = q2.x-x;
			double dy1 = q1.y-y;
			double dy2 = q2.y-y;

				if(dy1>=0 && dy2<0) return -1;
		   else if(dy2>=0 && dy1<0) return  1;
		   else if(dy1==0 && dy2==0){
			   		if(dx1>=0 && dx2<0) return -1;
			   else if(dx2>=0 && dx1<0) return  1;
			   		else return 0;
		   }else{
		   	 return -ccw(Points2D.this, q1,q2);
		   }

		}

	}

	public  static int ccw (Points2D a, Points2D b, Points2D c){

		double area = ((b.x-a.x) * (c.y-a.y)) - ((b.y-a.y) * (c.x-a.x));

		if(area<0) return -1;
		if(area>0) return 1;
		else return 0;
	}
	
}

 public class GARDENHU {

	public static void main (String[] args) throws java.lang.Exception
	{
		
			BufferedReader buf = new BufferedReader( new InputStreamReader( System.in ));
			String line = buf.readLine();
			int N = Integer.parseInt(line);
			Points2D [] pts = new Points2D[N];
			for(int i=0;i<N;i++){
				line = buf.readLine();
				int X = Integer.parseInt( line.split(" ")[0] );
				int Y = Integer.parseInt( line.split(" ")[1] );
				pts[i]= new Points2D(X,Y);
			}
			
			System.out.println( convex(pts) );
		
	}
	
	private static int convex ( Points2D[] pts){
		Stack<Points2D> hull = new Stack<Points2D>();
		int N = pts.length;
		Points2D [] points = new Points2D[N];

		for(int i=0;i<N;i++){
			points[i]=pts[i];
		}

		Arrays.sort(points);

		Arrays.sort(points,1,N,points[0].POLAR_ORDER);

		int k1=0;
		for(k1=0;k1<N;k1++){
			if(!points[k1].equals(points[0])){
				break;
			}
		}

		if(k1==N) 
			return 0;

		hull.push(points[0]);

		int k2;
		for(k2=k1+1;k2<N;k2++){

			if(Points2D.ccw(points[0],points[k1],points[k2])!=0 ){
				break;
			}
		}

		hull.push(points[k2-1]);

		for(int i=k2+1;i<N;i++){

			Points2D top = hull.pop();
			while( Points2D.ccw( hull.peek(), top, points[i]) <=0){
				top = hull.pop();
			}

			hull.push(top);
			hull.push(points[i]);
		}		 
		int dis =0;
		Points2D p1 = hull.pop();	
		Points2D p0=p1;	 
		while(!hull.isEmpty()){
			Points2D p2 = hull.pop();			 			 
			dis+=p1.distanceTo(p2);
			p1=p2;
		}
		dis+=p1.distanceTo(p0);
		 
		return dis;

	}
	
	
}