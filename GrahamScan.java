import java.util.Stack;
import java.util.Arrays;

public class GrahamScan {
	
	private Stack<Points2D> hull = new Stack<Points2D>();


	private Stack<Points2D> convex ( Points2D[] pts){

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
			return hull;

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

		return hull;

	}

	public static void main(String[] args) {
		

		Points2D[ ] pts =  new Points2D[8];
		pts[0] = new Points2D(30,60);
		pts[1] = new Points2D(50,40);
		pts[2] = new Points2D(70,30);
		pts[3] = new Points2D(55,20);
		pts[4] = new Points2D(50,10);
		pts[5] = new Points2D(20,0);
		pts[6] = new Points2D(15,25);
		pts[7] = new Points2D(0,30);

		GrahamScan graham = new GrahamScan();

		Stack<Points2D> convex = graham.convex(pts);

		while( !convex.isEmpty()){
			Points2D p = convex.pop();
			System.out.println( p.toString());
		}
	}
}