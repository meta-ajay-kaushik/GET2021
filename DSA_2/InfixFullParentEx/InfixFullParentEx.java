package InfixFullParentEx;
import java.util.StringTokenizer;
// java class implements stack interface
public class InfixFullParentEx implements Stack{
	// method to evaluate infix expression
    public String evaluateInfix(String exps){
//        remove if any spaces
        exps = exps.replaceAll("\\s+", "");
//        create object of stack class
        MyStack<String> stack = new MyStack<String>(exps.length());
//        break the expression into tokens
        // create token
        StringTokenizer tokens = new StringTokenizer(exps, "{}()*/+-<><=>=||==&&!=", true);
        while(tokens.hasMoreTokens()){
            String tkn = tokens.nextToken();
            /**read each token and take action**/
            if(tkn.equals("(") 
                    || tkn.equals("{")
                    || tkn.matches("[0-9]+") 
                    || tkn.equals("*")
                    || tkn.equals("/")
                    || tkn.equals("+")
                    || tkn.equals("-")
                    || tkn.equals("<")
                    || tkn.equals(">")
                    || tkn.equals("<=")
                    || tkn.equals(">=")
                    || tkn.equals("!=")){
                /**push token to the stack**/
                stack.push(tkn);
            } else if(tkn.equals("}") || tkn.equals(")")){
                try {
                    int op2 = Integer.parseInt(stack.pop()); 
                    String oprnd = stack.pop();
                    int op1 = Integer.parseInt(stack.pop());
                    /**Below pop removes either } or ) from stack**/
                    if(!stack.isStackEmpty()){
                        stack.pop();
                    }
                    int result = 0;
                    if(oprnd.equals("*")){
                        result = op1*op2;
                    } else if(oprnd.equals("/")){
                        result = op1/op2;
                    } else if(oprnd.equals("+")){
                        result = op1+op2;
                    } else if(oprnd.equals("-")){
                        result = op1-op2;
                    } else if(oprnd.equals("<")){
                        result = op1<op2?1:0;
                    } else if(oprnd.equals(">")){
                        result = op1>op2?1:0;
                    } else if(oprnd.equals(">=")){
                        result = op1>=op2?1:0;
                    } else if(oprnd.equals("<=")){
                        result = op1<=op2?1:0;
                    }
                    /**push the result to the stack**/
                    stack.push(result+"");
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        String finalResult = "";
        try {
            finalResult = stack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalResult;
    }
    // main method
    public static void main(String a[]){
    	InfixFullParentEx obj=new InfixFullParentEx();
        String expr = "((( 3 < 4 ) + (4 * 3)) / (11 - 9))";
        System.out.println("Expression: "+expr);
        System.out.println("Final Result: "+obj.evaluateInfix(expr));
    }
}
// stack class
class MyStack<T extends Object> {
    private int stackSize;
    private T[] stackArr;
    private int top;
    // stack constructor
    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        this.stackSize = size;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }
    // method to push into stack
    public void push(T entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
    // method to pop from stack
    public T pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        T entry = this.stackArr[top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }
    // method to find peek of stack
    public T peek() {
        return stackArr[top];
    }
    // method to increase size of stack
    private void increaseStackCapacity(){
        @SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
    // method to check stack is empty or not
    public boolean isStackEmpty() {
        return (top == -1);
    }
    // method to check stack is full or not
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
}