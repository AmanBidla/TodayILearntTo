import java.util.Comparator;

public class Points2D implements Comparable<Points2D> {

	double x;
	double y;


	public Points2D(double x, double y){
		this.x=x;
		this.y=y;
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