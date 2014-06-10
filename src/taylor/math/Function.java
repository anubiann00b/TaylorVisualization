package taylor.math;

import java.util.Stack;

public class Function {
    
    public static String operators = "*/+-(";
    public Expression exp;
    
    public Function(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(" ");
        for (String s : split)
            sb.append(s);
        String eq = sb.toString();
        
        System.out.println(eq);
        
        StringBuilder newSb = new StringBuilder();
        
        int len = eq.length();
        int c = 0;
        
        for (int i=0;i<len-1;i++) {
            newSb.append(eq.charAt(c));
            if (!Character.isDigit(eq.charAt(c)) || !Character.isDigit(eq.charAt(c+1))) {
                newSb.append(" ");
            }
            c++;
        }
        newSb.append(eq.charAt(c));
        
        String newEq = newSb.toString();
        
        Expression e1;
        Expression e2;
        Stack<String> stack = new Stack<String>();
        
        String newStr = "";
        
        String[] tokens = newEq.split(" ");
        
        System.out.println(newEq);
        
        for (String s : tokens) {
            if (s.equals("(")) {
                stack.push(s);
            } else if (operators.contains(s)) {
                    while (!stack.empty() && (operators.indexOf(stack.peek()) <= operators.indexOf(s)))
                        newStr += stack.pop() + " ";
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("("))
                    newStr += stack.pop() + " ";
                stack.pop();
            } else {
                newStr += s + " ";
            }
        }
        
        while (!stack.empty())
            newStr += stack.pop() + " ";
        
        System.out.println(newStr);
    }
    
    private boolean isOperator(char c) {
        return operators.indexOf(c) != -1;
    }
    
    public int getY(int x) {
        return exp.getY(x);
    }
}
