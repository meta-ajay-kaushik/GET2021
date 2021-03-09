package PriorityQueue;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
// class to test priority queue working
public class TestQueue {
    @Test
    public void test1() {
        try {
            PriorityQueue testQueue = new PriorityQueue(5);
            testQueue.enque(20);
            testQueue.enque(10);
            testQueue.enque(30);
            testQueue.enque(40); 
            testQueue.enque(50);
            int[] result = testQueue.show();
            int[] expected1 = new int[] { 50, 40, 30, 20, 10 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            PriorityQueue testQueue = new PriorityQueue(5);
            testQueue.enque(20);
            testQueue.enque(50);
            testQueue.enque(30);
            testQueue.enque(10);
            testQueue.enque(40);
            testQueue.deque();
            testQueue.deque();

            int[] result = testQueue.show();

            int[] expected1 = new int[] { 50, 40, 30, 0, 0 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }

    @Test
    public void test3() {
        try {
            PriorityQueue testQueue = new PriorityQueue(5);

            testQueue.enque(20);
            testQueue.enque(30);
            testQueue.enque(10);
            testQueue.deque();
            testQueue.deque();
            testQueue.enque(60);
            testQueue.enque(70);

            int[] result = testQueue.show();

            int[] expected1 = new int[] { 70, 60, 30, 0, 0 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }

    @Test
    public void test4() {
        try {
            PriorityQueue testQueue = new PriorityQueue(5);

            testQueue.deque();

            int[] result = testQueue.show();
            int[] expected1 = new int[] { 0, 0, 0, 0, 0 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }

    @Test
    public void test5() {
        try {
            PriorityQueue testQueue = new PriorityQueue(5);

            testQueue.enque(10);
            testQueue.enque(20);
            testQueue.enque(30);

            int[] result = testQueue.show();
            int[] expected1 = new int[] { 30, 20, 10, 0, 0 };
            assertArrayEquals(expected1, result);
        } catch (AssertionError e) {
            System.out.println("Assertion Error  " + e.getMessage());

        }
    }
}