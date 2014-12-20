public class DivistionWithoutAdditionMultiplicationOrSubtraction{

	//http://codereview.stackexchange.com/questions/55644/implementing-division-without-addition-multiplication-division-or-subtraction/55649#55649

	public static void main(String[] args) {
		
		int a=1,b=2,s=0;
		boolean isNeg=false,sign=true;;
		//System.out.println("adding "+a+" with "+ b+" = "+add(a,b));//gives 3
		a=1;b=-2;
		//System.out.println("adding "+a+" with "+ b+" = "+add(a,b));//gives -1
		a=11;b=12;s=0;;
		//System.out.println("multiply "+a+" with "+ b+" = "+mul(a,b));//gives 132
		a=-11;b=3;s=0;;
		//System.out.println("multiply "+a+" with "+ b+" = "+mul(a,b));//gives -33
		a=8;b=-3;
			System.out.println("divide "+a+" with "+b+" = "+divide(a,b));
		a=6;b=5;
			System.out.println("divide "+a+" with "+b+" = "+divide(a,b));
		a=-6;b=-3;
			System.out.println("divide "+a+" with "+b+" = "+divide(a,b));
		a=5;b=10;
			System.out.println("divide "+a+" with "+b+" = "+divide(a,b));
		a=9;b=6;
			System.out.println("divide "+a+" with "+b+" = "+divide(a,b));
		a=7;b=2;
			System.out.println("divide "+a+" with "+b+" = "+divide(a,b));
		a=42;b=6;
			System.out.println("divide "+a+" with "+b+" = "+divide(a,b));
	}

	private static boolean isBothNegative(int a, int b){

		return (a<0 && b<0);
	}

	/*private static int divide(int a , int b){

		boolean isNeg=false,sign=true,bothNegative=false;
		int quotient=1;

		if(isBothNegative(a,b)){
			bothNegative=true;
		}
		else if(isALessThanZero(a) || isBLessThanZero(b)) {
			
			isNeg=true;
			sign=true;
			
		}

			a=Math.abs(a);
			b=Math.abs(b);


		if(a<b) return 0;
		else{

			int s=add(a,-b);
			int divisor =b;
			//System.out.println(" first s "+s);

			while(Math.abs(s)>=Math.abs(divisor)){
				b=add(b,divisor);
				s=add(a,-b);
				quotient=add(quotient,1);
				//System.out.println(" quotient "+quotient);		
				//System.out.println(" s "+s+" a "+a +" b "+b);	
				if(isNeg){
					sign=!sign;
				}
			}

			if(bothNegative){
				return quotient;

			}else if(isNeg && !sign){
				quotient=add(0,-quotient);
				//System.out.println(" negating sub "+quotient);			
			}

			return quotient;
		}

	}*/

	privat static int betterDivide(int dividend, int divisor) { 

    int denom=divisor;
    int current = 1;
    int answer=0;

    if ( denom > dividend) 
        return 0;

    if ( denom == dividend)
        return 1;

    while (denom < dividend) {
        denom = denom << 1;
        current = current << 1;
    }

    while (current!=0) {
        if ( dividend >= denom) {
            dividend -= denom;
            answer |= current;
        }
        current = current >> 1;
        denom = denom >> 1;
    }
    return answer;
}

	private static int divide(int a, int b) {
    boolean swapSign = a < 0 ^ b < 0;
    a = Math.abs(a);
    b = Math.abs(b);
    int result = 0;
    while (a >= b) {
        a = add(a, -b);
        result = add(result, 1);
    }
    return swapSign ? -result : result;
}

	private static int  division(int a, int b){
		boolean isNeg=false;
		if(b<0){
			isNeg=true;
		}else{
			b=-b;
		}
		
		int s=add(a,b);
		//System.out.println("first sub "+s);
		while(Math.abs(s)>Math.abs(b)){
			b=add(b,b);
			s=add(a,b);
			//System.out.println("sub "+s);
		}
		//System.out.println("final sub "+s);
		if(isNeg){
			s=add(0,-s);
			//System.out.println(" negating sub "+s);			
		}
		return s;
	}

	private static boolean isALessThanZero(int a){
		return a<0;
	}

	private static boolean isBLessThanZero(int b){
		return b<0;
	}

	private static int mul(int a,int b){
		boolean isNeg =false,sign=true;
		int s=0;

		if(isALessThanZero(a) || isBLessThanZero(b)) {
			
			isNeg=true;
			sign=true;
			
			a=Math.abs(a);
			b=Math.abs(b);
		}

		while(b>0){
			s=add(a,s);
			b=add(b,-1);
			//System.out.println(s);
			if(isNeg){
				sign=!sign;
				System.out.println(sign);
			}
		}

		if(isNeg && !sign){
			s=-s;
		}

		return s;

	}

	private static int add(int a , int b){
		//
		do{

			a=a^b;
			b=(a^b)&b;
			b=b<<1;
			//System.out.println("a ="+a+" b= "+b);
		}while(Math.abs(b)!=0);

		return a;
	}

	private static int mutiplication(int a, int b){
 		boolean isNeg=false,sign=true;
		int s=0;
		if(a<0){
			isNeg=true;
			sign=true;
		}
		for(int i=0;i<Math.abs(b);i++){
 					if(isNeg){
						s=add(-a,s);
						sign=!sign;
					}else
						s=add(a,s);
					
				}
				if(!sign){
					s=add(-s,0);
 				}
		return s;

	}


}