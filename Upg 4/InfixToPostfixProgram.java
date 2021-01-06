import java.util.*;

public class InfixToPostfixProgram {
    public static void main(String[] args) {

        LinkedList<String> exp = infixToPostfix();
    }

    public static LinkedList<String> infixToPostfix(){
        // stack - operations, list - values
        Stack<String> stack = new Stack<String>();
        Scanner input = new Scanner(System.in);
        System.out.println("input expression: ");
        String exp = input.next();
        LinkedList<String> list = new LinkedList<String>();

        for (int i = 0; i < exp.length(); i++) {
            String s = exp.charAt(i) + "";

            if (s.equals("+")) {
                while (!stack.isEmpty()) {
                    String tkn = stack.pop();
                    if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
                    list.add(tkn);
                    else {
                        stack.push(tkn);
                        break;
                    }
                }
                stack.push(s);

            }
            else if (s.equals("-")) {
                while (!stack.isEmpty()) {
                    String tkn = stack.pop();
                    if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
                    list.add(tkn);
                    else {
                        stack.push(tkn);
                        break;
                    }
                }
                stack.push(s);
            }



            else if (s.equals("*")) {
                while (!stack.isEmpty()) {
                    String tkn = stack.pop();
                    if (tkn.equals("*") || tkn.equals("/") || tkn.equals("^")) {
                        list.add(tkn);
                    }
                    else {
                        stack.push(tkn);

                        break;
                    }
                }
                stack.push(s);

            }
            else if (s.equals("/")) {

                while (!stack.isEmpty()) {
                    String tkn = stack.pop();
                    if (tkn.equals("*") || tkn.equals("/") || tkn.equals("^")) {
                        list.add(tkn);
                    }
                    else {
                        stack.push(tkn);
                        break;
                    }
                }
                stack.push(s);
            }

            else if (s.equals("^")) {
                stack.push(s);

            }
            /*
            else if (s.equals("(")){
            stack.push(s);

        }*/

        else if (s.equals(")")) {
            while(!stack.isEmpty()) {
                String tkn = stack.pop();
                if(tkn.equals("(")){
                    break;
                }

                list.add(tkn);
            }

        }

        else if (s.equals("(")){
            stack.push(s);

        }
        //to be able to calculate with num > 9
        else if(i+1 < exp.length()){
            String highVal = exp.charAt(i+1)+"";
            while(highVal.matches("^[A-Z0-9]+$")){
                i++;
                s = s + exp.charAt(i);
                if(i+1 >= exp.length())
                break;
                highVal = exp.charAt(i+1) + "";

            }
            list.add(s);
        }
        else {

            list.add(s);
        }
    }
    while(!stack.isEmpty()) {
        list.add(stack.pop());
    }

    System.out.println(list);

    return list;
}


}
