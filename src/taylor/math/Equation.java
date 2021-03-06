package taylor.math;

import java.util.Stack;
import taylor.math.function.Function;
import taylor.math.operation.Addition;
import taylor.math.operation.Division;
import taylor.math.operation.Exponent;
import taylor.math.operation.Multiplication;
import taylor.math.operation.Operation;
import taylor.math.operation.Subtraction;

public class Equation {
    
    public static String[] operators = { "^","*/","+-","(" };
    public static String functions = "scl";
    public Expression exp;
    
    public Equation(Equation e) {
        exp = e.exp;
    }
    
    public Equation(Expression e) {
        exp = e;
        exp = exp.simplify();
    }
    
    public Equation(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(" ");
        for (String s : split)
            sb.append(s);
        String eq = sb.toString();
        
        StringBuilder newSb = new StringBuilder();
        
        eq = eq.replace("sin","s");
        eq = eq.replace("cos","c");
        eq = eq.replace("ln","l");
        
        int len = eq.length();
        int c = 0;
        
        for (int i=0;i<len-1;i++) {
            newSb.append(eq.charAt(c));
            String s1 = String.valueOf(eq.charAt(c));
            String s2 = String.valueOf(eq.charAt(c+1));
            if (!(isNumber(s1) || isVariable(s1)) || !(isNumber(s2) || isVariable(s2))) {
                newSb.append(" ");
            }
            c++;
        }
        newSb.append(eq.charAt(c));
        
        String newEq = newSb.toString();
                
        Stack<String> opStack = new Stack<String>();
        
        String newStr = "";
        
        String[] tokens = newEq.split(" ");
        
        for (int i=0;i<tokens.length;i++) {
            String s = tokens[i];
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
            } else if (isFunction(s)) {
                if (tokens[i+1].equals("(")) {
                    opStack.push(s);
                } else {
                    newStr += tokens[i+1] + " " + s + " ";
                    i++;
                }
            } else {
                newStr += s + " ";
            }
        }
        
        while (!opStack.isEmpty())
            newStr += opStack.pop() + " ";
        
        String[] terms = newStr.split(" ");
        
        Stack<Expression> termStack = new Stack<Expression>();
        
        String currentTerm;
        
        for (int i=0;i<terms.length;i++) {
            currentTerm = terms[i];
            if (isNumber(currentTerm)) {
                termStack.add(new Constant(Integer.parseInt(currentTerm)));
            } else if (isVariable(currentTerm)) {
                termStack.add(new Variable(currentTerm.length()==1?1:Integer.parseInt(currentTerm.substring(0,currentTerm.length()-1))));
            } else if (isOperator(currentTerm)) {
                Expression e2 = termStack.pop();
                Expression e1 = termStack.pop();
                termStack.push(Operation.getOperation(currentTerm,e1,e2));
            } else if (isFunction(currentTerm)) {
                Expression e = termStack.pop();
                termStack.push(Function.getFunction(currentTerm,e));
            }
        }
        
        if (!termStack.isEmpty())
            exp = termStack.pop();
        else
            exp = new Constant(0);
        
        exp = exp.simplify();
    }
    
    public Expression getTaylorPolynomial(int n, double p) {
        if (n==0)
            return new Constant(exp.getY(p));
        
        Expression d = exp;
        for (int i=0;i<n;i++)
            d = d.derive();
        d.simplify();
        Expression e = 
            new Multiplication (
                new Division (
                    new Constant(d.getY(p)),
                    new Constant(factorial(n))
                ),
                new Exponent (
                    new Subtraction (
                        new Variable(1),
                        new Constant(p)
                    ),
                    new Constant(n)
                )
            );
        
        if (!e.isValid(n,n))
            return null;
        
        Expression e2 = getTaylorPolynomial(n-1,p);
        if (e2 == null)
            return null;
        
        return new Addition(e,e2);
    }
    
    public boolean isValid(double x1, double x2) {
        return exp.isValid(x1,x2);
    }
    
    @Override
    public String toString() {
        return exp.toString();
    }
    
    public int factorial(int n) {
        int r = 1;
        for (int i=1;i<=n;i++)
            r = r*i;
        return r;
    }
    
    public Equation derive() {
        return new Equation(exp.derive());
    }
    
    public static boolean isVariable(String str) {
        return str.endsWith("x") && (str.length()==1 || str.substring(0,str.length()-1).matches("-?\\d+(\\.\\d+)?"));
    }
    
    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
    public static boolean isFunction(String str) {
        return functions.contains(str);
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
    
    public double getY(double x) {
        return exp.getY(x);
    }
}
