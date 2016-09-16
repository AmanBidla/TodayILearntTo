class Rectangle {
	int x, y;
	int height, width;
}
public class IntersectingRectangles {

	public Rectangle findIntersectngRectangle(Rectangle r1, Rectangle r2) {

		Rectangle result = null;
		if (doesIntersect(r1, r2)) {

			result = new Rectangle( Math.max(r1.x, r2.x), Math.max(r1.y, r2.y),
					Math.min(r1.x+r1.width, r2.x+r2.width) - Math.max(r1.x,r2.x),
					Math.min(r1.y+r1.height, r2.y+r2.height)- Math.max(r1.y, r2.y));
		}
		return result;

	}

	private static boolean doesIntersect(Rectangle r1, Rectangle r2) {

		return r1.x <= r2.x +r2.width 
			&& r1.x+r1.width >= r2.x
			&& r1.y<= r2.y + r2.height
			&& r1.y + r1.height >= r2.y;
	}


}