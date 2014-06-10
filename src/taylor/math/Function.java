package taylor.math;

import java.util.Stack;

public class Function {
    
    public static String operators = "*/+-(";
    public Expression exp;
    
    public Function(String str) {
        /*
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (String str : split)
            sb.append(str);
        String eq = sb.toString();

        char[] chars = eq.toCharArray();
        */
        
        Expression e1;
        Expression e2;
        Stack<String> stack = new Stack<String>();
        
        String newStr = "";
        
        String[] tokens = str.split(" ");
        
        System.out.println(str);
        
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
    
    public int getY(int x) {
        return exp.getY(x);
    }
}
