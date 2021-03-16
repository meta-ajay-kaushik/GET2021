package assignment1;
public interface Stack {
	public boolean push(String element) throws Exception; 
	public String pop() throws Exception;
	public boolean isEmpty();
	public String peek() throws Exception;
}