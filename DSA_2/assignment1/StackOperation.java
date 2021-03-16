package assignment1;
import java.util.LinkedList;
public class StackOperation implements Stack {
    public LinkedList<String> stack = new LinkedList<String>();
    public int topOfStack = -1;
    public int MaxSizeStack = 100;
    @Override
    public boolean push(String element) throws Exception {
        boolean flag = false;
        if ((this.topOfStack + 1) == MaxSizeStack)
            throw new Exception("stack is full");
        else {
            this.topOfStack++;
            this.stack.add(element);
            flag = true;
        }
        return flag;
    }
    @Override
    public String pop() throws Exception {
        String element = "";
        if (this.stack.isEmpty())
            throw new Exception("stack is already empty");
        else {
            element = this.stack.get(topOfStack);
            this.stack.remove(topOfStack);
            this.topOfStack--;
        }
        return element;
    }
    @Override
    public boolean isEmpty() {
        boolean flag = false;
        if (this.topOfStack == -1)
            flag = true;
        return flag;
    }
    @Override
    public String peek() throws Exception {
        if (topOfStack == -1)
            throw new Exception("stack underflow");
        return this.stack.get(topOfStack);
    }
}