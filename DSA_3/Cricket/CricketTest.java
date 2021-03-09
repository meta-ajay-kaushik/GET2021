package Cricket;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.ArrayList;
// class to test bowler allocation is right or not
public class CricketTest {
    @Test
    public void test1() {
        int noOfBall = 6;
        ArrayList<String> result = new ArrayList<String>();
        String[] expected = new String[] { "C", "D", "C", "D", "C", "A" };
        AllocateBowler bowl = new AllocateBowler();
        try {
            bowl.insert("A", 3);
            bowl.insert("B", 2);
            bowl.insert("D", 4);
            bowl.insert("C", 5);
            result = bowl.allocateBowler(noOfBall);
            assertArrayEquals(expected, result.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        int noOfBall = 6;
        ArrayList<String> result = new ArrayList<String>();
        String[] expected = new String[] { "F", "D", "F", "D", "F", "A" };
        AllocateBowler bowl = new AllocateBowler();
        try {
            bowl.insert("A", 6);
            bowl.insert("B", 4);
            bowl.insert("D", 7);
            bowl.insert("C", 3);
            bowl.insert("E", 5); 
            bowl.insert("F", 8);

            result = bowl.allocateBowler(noOfBall);

            assertArrayEquals(expected, result.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void test3() {
        int noOfBall = 16;
        ArrayList<String> result = new ArrayList<String>();
        String[] expected = new String[] { "D", "D", "D", "D", "A", "D", "A",
                "D", "B", "D", "B", "A", "C", "A", "C", "D" };
        AllocateBowler bowl = new AllocateBowler();
        try {
            bowl.insert("A", 13);
            bowl.insert("B", 12);
            bowl.insert("D", 17);
            bowl.insert("C", 11);
            result = bowl.allocateBowler(noOfBall);

            assertArrayEquals(expected, result.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        int noOfBall = 8;
        ArrayList<String> result = new ArrayList<String>();
        String[] expected = new String[] {};
        AllocateBowler bowl = new AllocateBowler();
        try {
            bowl.insert("A", 1);
            bowl.insert("B", 0);
            bowl.insert("D", 1);
            bowl.insert("C", 2);
            result = bowl.allocateBowler(noOfBall);
            assertArrayEquals(expected, result.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}