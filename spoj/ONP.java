import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class ONP{
	
	public static void main(String[] args) throws IOException {
		
		Stack<String> op = new Stack<String>();
		Stack<String> val = new Stack<String>();

		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String line = buf.readLine();
		int test = Integer.parseInt(line);
		String [] result = new String[test];
		for(int t=0;t<test;t++){

			line = buf.readLine();
			for(int i=0;i<line.length();i++){
				char c = line.charAt(i);
				if(c=='(');
				else if(c=='+'){
					op.push("+");
				}else if(c=='-'){
					op.push("-");
				}else if(c=='*'){
					op.push("*");
				}else if(c=='/'){
					op.push("/");
				}else if(c=='^'){
					op.push("^");
				}else if(c==')'){

					String operation = op.pop();
					if(operation.equals("+")){
						String b= val.pop();
						String a= val.pop();
						String c1= a+b+"+";
						val.push(c1);
					}else if(operation.equals("-")){
						String b= val.pop();
						String a= val.pop();
						String c1= a+b+"-";
						val.push(c1);
					}else if(operation.equals("*")){
						String b= val.pop();
						String a= val.pop();
						String c1= a+b+"*";
						val.push(c1);
					}else if(operation.equals("/")){
						String b= val.pop();
						String a= val.pop();
						String c1= a+b+"/";
						val.push(c1);
					}else if(operation.equals("^")){
						String b= val.pop();
						String a= val.pop();
						String c1= a+b+"^";
						val.push(c1);
					}



				}else{
					val.push(String.valueOf(c));
				}				

			}

			result[t]=val.pop();

		}
		for(int t=0;t<test;t++){
			System.out.println(result[t]);
		}

	}

}