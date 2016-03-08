import java.util.Stack;
public class Expression {




    public static void main(String[] args) {
        String S ="3-(14-(3-2-1))+5";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

         S ="3-(1-(3-2))+5";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

         S ="()";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

        S="1-2";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));

        S="(((((1))-2)+4))";
        System.out.println("Expression "+S);
        System.out.println("result "+parse(S));
    }

    public static int parse(String expression){

        Stack<String> stack = new Stack<String>();
        //(3-(14-(3-2-1))+5)
        for(int i=0;i< expression.length();i++){

            if( expression.charAt(i) != ')') {

                // push symbol
                if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '(') {
                    stack.push(String.valueOf(expression.charAt(i)));
                } else {
                    // push whole number
                    int start = i;
                    int j = i+1;
                    while(j < expression.length()
                            && expression.charAt(j) != '+'
                            && expression.charAt(j) != '-'
                            && expression.charAt(j) != '('
                            && expression.charAt(j) != ')' ){

                        j++;

                    }

                    String number = expression.substring(start, j);
                    i = j-1;
                    stack.push(number);

                }
            } else {

                while(stack.size()>0 && !stack.peek().equals("(")) {

                    int v1 = Integer.valueOf(stack.pop());

                    String next = stack.peek();


                    if(!next.equals("(") ){
                        String op = stack.pop();

                        int v2 = Integer.valueOf(stack.pop());

                        if(op.equals("+")) {
                            v1 = v1 + v2;
                        }else{
                            v1 = v2 - v1;
                        }
                    }
                    if(stack.peek().equals("(")){
                        stack.pop();
                        stack.push(String.valueOf(v1));
                        break;
                    } else {
                        stack.push(String.valueOf(v1));
                    }


                }


            }
        }

        if(stack.peek().equals("(")) {
            return 0;
        }

        Stack<String> reverse = new Stack<String>();
        while( stack.size()>0){
            reverse.push(stack.pop());
        }

        while(reverse.size() >1){

            int v1 = Integer.valueOf(reverse.pop());
            if(reverse.size() >0){
                String op = reverse.pop();
                int v2 = Integer.valueOf(reverse.pop());
                if(op.equals("+")) {
                    v1 = v1+v2;
                }else{
                    v1 = v1 -v2;
                }
                reverse.push(String.valueOf(v1));
            }

        }


            return Integer.valueOf(reverse.pop());



    }

}