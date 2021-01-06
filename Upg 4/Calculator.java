import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private String buttonText[] = {"7", "8", "9", "^", "C", "4", "5", "6", "(", ")", "1", "2", "3", "*", "/", "0", "+", "-", "="};
    private JButton[] buttons = new JButton[19];
    private JTextField expressionField;
    private String exp="";

    public Calculator( ){
        super("Calculator");
        setSize(320, 240);
        expressionField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(4, 5));
        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonText[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }
        panel.add(new Label());
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(expressionField, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand() == "C"){
            exp = "";
            expressionField.setText(exp);
        }
        else if(e.getActionCommand() == "="){
            expressionField.setText(""+evaluate(infixToPostfix(exp)));
        }

        else{
            exp = exp + e.getActionCommand();
            expressionField.setText(exp);
        }

    }

    public static LinkedList<String> infixToPostfix( String exp){

        Stack<String> stack = new Stack<String>(); //for operators
        Scanner input = new Scanner(System.in);
        LinkedList<String> linkList = new LinkedList<String>(); //For values

        for (int i = 0; i < exp.length(); i++) {
            String s = exp.charAt(i) + "";

            if (s.equals("+")) {
                while (!stack.isEmpty()) {
                    String tkn = stack.pop();
                    if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
                    linkList.add(tkn);
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
                    linkList.add(tkn);
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
                        linkList.add(tkn);
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
                        linkList.add(tkn);
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

            else if (s.equals(")")) {
                while(!stack.isEmpty()) {
                    String tkn = stack.pop();
                    if(tkn.equals("(")){
                        break;
                    }

                    linkList.add(tkn);
                }

            }

            else if (s.equals("(")){
                stack.push(s);

            }
            //to be able to calculate num > 9
            else if(i+1 < exp.length()){
                String highVal = exp.charAt(i+1)+"";
                while(highVal.matches("^[A-Z0-9]+$")){
                    i++;
                    s = s + exp.charAt(i);
                    if(i+1 >= exp.length())
                    break;
                    highVal = exp.charAt(i+1) + "";

                }
                linkList.add(s);
            }


            else {

                linkList.add(s);
            }



        }
        while(!stack.isEmpty()) {
            linkList.add(stack.pop());
        }
        return linkList;
    }


    public static double evaluate( LinkedList<String> exp) {

        Stack<Integer> stack = new Stack<Integer>();
        Integer numA;
        Integer numB;

        while (!exp.isEmpty()){
            String s = exp.pop();

            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }

            else if (s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(s.equals("-")) {
                numA = stack.pop();
                numB = stack.pop();
                stack.push(numB - numA);
            }

            else if(s.equals("/")) {
                numA = stack.pop();
                numB = stack.pop();
                stack.push(numB / numA);

            }

            else if(s.equals("^")) {
                numA = stack.pop();
                numB = stack.pop();
                int tot = numB;
                for(int i = 0; i < numA-1; i++) {
                    tot = tot*numB;
                }
                stack.push(tot);
            }
            else stack.push(Integer.parseInt(s));
        }
        double ant = stack.pop();

        return ant;
    }

    public static void main(String [] CmdLn) {

        Calculator calc = new Calculator();
        calc.setVisible(true);

    }
}
