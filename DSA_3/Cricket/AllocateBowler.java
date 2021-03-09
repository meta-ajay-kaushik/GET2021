package Cricket;
import java.util.ArrayList;
// Main java class AllocateBowler
public class AllocateBowler {
    ArrayList<Bowler> bowlerHeap;
    int sizeOfHeap;
    // constructor
    public AllocateBowler() {
        bowlerHeap = new ArrayList<Bowler>();
    }
    // method to shift up
    public void shiftUp() {
        int newNode = bowlerHeap.size() - 1;
        while (newNode > 0) {
            int parentNode = (newNode - 1) / 2;
            Bowler bow = bowlerHeap.get(newNode);
            int bowlBowler = bow.getBalls();
            Bowler par = bowlerHeap.get(parentNode);
            int bowlParent = par.getBalls();

            if (bowlBowler > bowlParent) {
                bowlerHeap.set(newNode, par);
                bowlerHeap.set(parentNode, bow);

                // move one level up
                newNode = parentNode;
            } else {
                break;
            }

        }
    }
    // method to insert bowler into array
    public void insert(String name, int bowl) {
        Bowler newData = new Bowler(name, bowl);
        bowlerHeap.add(newData);
        shiftUp();
    }
    // method to show bowler
    public void show() {
        System.out.println(bowlerHeap);
    }
    // method to shift bowler down
    public void shiftDown() {
        int lastNode = 0;
        int leftChild = 2 * lastNode + 1;
        while (leftChild < bowlerHeap.size()) {
            int maximum = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < bowlerHeap.size()) {
                Bowler right = bowlerHeap.get(rightChild);
                int rightBowl = right.getBalls();
                Bowler left = bowlerHeap.get(leftChild);
                int leftBowl = left.getBalls();
                // if right child is greater than left then
                // increase maximum variable so that it point to right child
                if (rightBowl > leftBowl) {
                    maximum++;
                }
            }
            // This is the current node which comes from last at top
            Bowler bow = bowlerHeap.get(lastNode);
            int lastBall = bow.getBalls();

            // This is the child node
            Bowler max = bowlerHeap.get(maximum);
            int maxBall = max.getBalls();

            // Both current and child node are compare
            if (lastBall < maxBall) {
                // swap the node
                Bowler temp = bowlerHeap.get(lastNode);
                Bowler maxBowler = bowlerHeap.get(maximum);
                bowlerHeap.set(lastNode, maxBowler);
                bowlerHeap.set(maximum, temp);
                // initialize the last node to node which is swapped
                lastNode = maximum;
                leftChild = 2 * lastNode + 1;
            } else {
                break;
            }
        }
    }
    // method to delete bowler
    public Bowler delete() {
        Bowler result = new Bowler("", 0);
        if (bowlerHeap.size() == 0) {
            System.out.println("No element exists");
        } else if (bowlerHeap.size() == 1) {
            result = bowlerHeap.remove(0);
            // return "bowler deleted";
        } else {
            // store the deleted node
            Bowler hold = bowlerHeap.get(0);
            // bring the last element to top
            bowlerHeap.set(0, bowlerHeap.remove(bowlerHeap.size() - 1));
            shiftDown();
            result = hold;
        }
        return result;
    }
    // method to allocate bowler to Virat Kohli
    public ArrayList<String> allocateBowler(int ballPlayed) throws Exception {
        ArrayList<String> bowlers = new ArrayList<String>();
        for (int index = 0; index < ballPlayed; index++) {
            Bowler ball = delete();
            if (ball.getBalls() > 0) {
                bowlers.add(ball.getName());
                insert(ball.getName(), ball.getBalls() - 1);
            } else {
                throw new Exception();
            }
        }
        return bowlers;
    }
}