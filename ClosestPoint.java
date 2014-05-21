import java.util.Arrays;

public class ClosestPoint {
	private double bestDistance = Double.POSITIVE_INFINITY;
	private Point2D best1, best2;

	public ClosestPoint(Point2D[] points){

		int N = points.length;
		if(N<=1) return;

		Point2D[] pointsByX = new Point2D[N];
		Point2D[] pointsByY = new Point2D[N];
		Point2D[] aux = new Point2D[N];
		
		populate(pointsByX, points);
        Arrays.sort(pointsByX, Point2D.X_ORDER);
		if(isCoincidentPointsPresent(pointsByX))
			return;

		populate(pointsByY,pointsByX);
		closest(pointsByX,pointsByY,aux,0,N-1);
	}


	private double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux,int lo, int hi){

		if(hi<=lo) return Double.POSITIVE_INFINITY;
		int mid= lo+(hi-lo)/2;
		Point2D median = pointsByX[mid];

		double delta1 = closest(pointsByX,pointsByY,aux,lo,mid);
		double delta2 = closest(pointsByX,pointsByY,aux,mid+1,hi);
		double delta  = Math.min(delta1,delta2);

		/* merge and sort by y coordinate */
		merge(pointsByY,aux,lo,mid,hi);
		int M =0;
		/* points closer than delta from median */
	 	for(int i=lo;i<=hi;i++){
	 		if(Math.abs(pointsByY[i].getX()-median.getX())<delta){
	 			aux[M++]=pointsByY[i];
	 		}
	 	}

	 	/* points closer than delta in points sorted by y coordinate */
	 	for(int i=0;i<M;i++){
	 		for(int j=i+1;j<M && aux[i].getY()-aux[j].getY()<delta;j++){
	 			double distance = aux[i].distanceTo(aux[j]);
	 			if(distance<delta){
	 				distance= delta;
	 				if(distance<bestDistance){
	 					bestDistance=distance;
	 					best1= aux[i];
	 					best2=aux[j];
	 				}
	 			}
	 		}
	 	}
	 	return bestDistance;
		
	}


	private void merge(Point2D [] pointsByY, Point2D[]aux,int lo, int  mid, int hi){

		for(int k=lo;k<hi;k++){
			aux[k]=pointsByY[k];
		}

		int i=lo,j=mid-1;

		for(int k=lo;k<hi;k++){
			if(i>mid) pointsByY[k]=aux[j++];
			if(j>hi) pointsByY[k]=aux[i++];
			if(less(aux[j],aux[i])) pointsByY[k]=aux[j++];
			else pointsByY[k]=aux[i++];
		}	
	}

	private boolean less(Point2D v, Point2D w){
		return v.compareTo(w)<0;
	}

	private boolean isCoincidentPointsPresent(Point2D[] pointsByX){
		int N = pointsByX.length;
		for(int i=0;i<N-1;i++){
			if(pointsByX[i]==pointsByX[i+1]){
				bestDistance=0;
				best1=pointsByX[i];
				best2= pointsByX[i+1];
				return true;
			}
		}
		return false;
	}

	private void populate(Point2D[] pol , Point2D[] p){
		for(int i=0;i<p.length;i++)
			pol[i]=p[i];
	}
}