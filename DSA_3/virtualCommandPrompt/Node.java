package virtualCommandPrompt;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Node class 
public class Node {
    String directoryName;
    String creationDate;
    List<Node> subDirectory = new ArrayList<Node>();
    Node parentNode = null;
    Node(String directoryName) {
        this.directoryName = directoryName;
        creationDate = new Date().toString();
    }
}