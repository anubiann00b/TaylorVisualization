package taylor.math;

import java.util.Stack;
import taylor.math.operation.Operation;

public class Function {
    
    public static String[] operators = { "*/","+-","(" };
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
        
        Stack<String> opStack = new Stack<String>();
        
        String newStr = "";
        
        String[] tokens = newEq.split(" ");
        
        System.out.println(newEq);
        
        for (String s : tokens) {
            if (s.equals("(")) {
                opStack.push(s);
            } else if (isOperator(s)) {
                    while (!opStack.empty() && (getPrecedence(opStack.peek()) <= getPrecedence(s)))
                        newStr += opStack.pop() + " ";
                opStack.push(s);
            } else if (s.equals(")")) {
                while (!opStack.peek().equals("("))
                    newStr += opStack.pop() + " ";
                opStack.pop();
            } else {
                newStr += s + " ";
            }
        }
        
        while (!opStack.empty())
            newStr += opStack.pop() + " ";
        
        String[] terms = newStr.split(" ");
        
        Stack<Expression> termStack = new Stack<Expression>();
        
        String currentTerm;
        
        for (int i=0;i<terms.length;i++) {
            currentTerm = terms[i];
            if (isNumber(currentTerm)) {
                termStack.add(new Constant(Integer.parseInt(currentTerm)));
            } else if (isOperator(currentTerm)) {
                Expression e2 = termStack.pop();
                Expression e1 = termStack.pop();
                termStack.push(Operation.getOperation(currentTerm,e1,e2));
            }
        }
        
        exp = termStack.pop();
        System.out.println(exp);
    }
    
    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
    private int getPrecedence(String s) {
        for (int i=0;i<operators.length;i++) {
            if (operators[i].contains(s))
                return i;
        }
        return -1;
    }
    
    private boolean isOperator(String s) {
        return getPrecedence(s) != -1;
    }
    
    public int getY(int x) {
        return exp.getY(x);
    }
}
