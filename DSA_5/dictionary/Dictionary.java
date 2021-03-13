package dictionary;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * This class contains methods to:
 * 1. add an key value pair to dictionary, 
 * 2. delete a key value pair from the dictionary, 
 * 3. get the value corresponding to a specified key, 
 * 4. return sorted list of key value pairs, 
 * 5. return the sorted list of key value pairs for all the keys >=K1 and <=K2.
 */
public class Dictionary {
    Entry root;
    List<Entry> listOfNodes;
    public Dictionary() {
        root = null;
        listOfNodes = new ArrayList<>();
    }
    /**
     * this method calls another method to insert a key value pair in dictionary
     * @param key
     * @param value
     */
    public void insert(String key, String value) {
        root = insertInDictionary(root, key, value);
    }
    /**
     * This method inserts a key value pair in dictionary
     * @param root
     * @param key
     * @param value
     * @return updated root
     */
    Entry insertInDictionary(Entry root, String key, String value) {
        if (root == null) {
            root = new Entry(key, value);
            return root;
        }
        if (key.equals(root.key)) {
            throw new AssertionError("Duplicates are not allowed..!!");
        } else if (isLess(root.key, key)) {
            root.right = insertInDictionary(root.right, key, value);
        } else if (isLess(key, root.key)) {
            root.left = insertInDictionary(root.left, key, value);
        }
        return root;
    }
    /**
     * This method compares 2 strings if 1 string is less than other
     * @param string1
     * @param string2
     * @return true if string1<string 2
     */
    boolean isLess(String string1, String string2) {
        if (string1.equals(string2)) {
            return false;
        }
        int length1 = string1.length();
        int length2 = string2.length();
        int length = length1 > length2 ? length2 : length1;
        for (int count = 0; count < length; count++) {
            if (string1.charAt(count) > string2.charAt(count)) {
                return false;
            }
        }
        return true;
    }
    /**
     * This method calls another method to traverse the tree of dictionary
     * @return list of traversal
     */
    public List<Entry> inorder() {
        listOfNodes.clear();
        inorderTraversal(root);
        return listOfNodes;
    }
    /**
     * This method traverses the tree of dictionary
     * @param node
     */
    void inorderTraversal(Entry node) {
        if (node != null) {
            inorderTraversal(node.left);
            listOfNodes.add(node);
            inorderTraversal(node.right);
        }
    }
    /**
     * This method prints the list
     * @param list
     */
    void printList(List<Entry> list) {
        for (int count = 0; count < list.size(); count++) {
            System.out.println("Key : " + list.get(count).key + "\tValue : "
                    + list.get(count).value);
        }
    }
    /**
     * This method calls another method to delete an entry from dictionary
     * @param key
     */
    public void deleteKey(String key) {
        root = deleteSpecifiedKey(root, key);
    }
    /**
     * This method deletes a key from dictionary
     * @param root
     * @param key
     * @return updated root
     */
    Entry deleteSpecifiedKey(Entry root, String key) {
        if (root == null) {
            return root;
        }
        if (isLess(key, root.key)) {
            root.left = deleteSpecifiedKey(root.left, key);
        } else if (isLess(root.key, key)) {
            root.right = deleteSpecifiedKey(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            String keyMin = findMinKey(root.right);
            String value = searchValue(keyMin);
            root.key = keyMin;
            root.value = value;
            root.right = deleteSpecifiedKey(root.right, root.key);
        }
        return root;
    }

    /**
     * This method find minimum key from root
     * @param root
     * @return minimum key
     */
    String findMinKey(Entry root) {
        String minimumKey = root.key;
        while (root.left != null) {
            minimumKey = root.left.key;
            root = root.left;
        }
        return minimumKey;
    }

    /**
     * This method calls findValueRecursively to search for a value from tree
     * @param key
     * @return value of key
     */
    public String searchValue(String key) {
        Entry node = findValueRecursively(root, key);

        if (node == null) {
            return "No Key found..!!";
        }
        return node.value;
    }

    /**
     * This method calls another method to find keys between range of 2 keys
     * @param key1
     * @param key2
     * @return list of nodes in range
     */
    public List<Entry> findInRange(String key1, String key2) {
        listOfNodes.clear();
        findInRangeRecursively(root, key1, key2);
        return listOfNodes;
    }

    /**
     * This method searches for a value from tree
     * @param root
     * @param key
     * @return
     */
    Entry findValueRecursively(Entry root, String key) {
        if (root == null || root.key.equals(key)) {
            return root;
        }
        if (isLess(key, root.key)) {
            return findValueRecursively(root.left, key);
        } else {
            return findValueRecursively(root.right, key);
        }
    }

    /**
     * This method finds keys between range of 2 keys
     * @param node
     * @param key1
     * @param key2
     */
    void findInRangeRecursively(Entry node, String key1, String key2) {
        if (node == null) {
            return;
        }
        if (isLess(key1, node.key)) {
            findInRangeRecursively(node.left, key1, key2);
        }
        if (isLess(key1, node.key) || key1.equals(node.key)
                && isLess(node.key, key2) || key2.equals(node.key)) {
            listOfNodes.add(node);
        }
        if (isLess(node.key, key2)) {
            findInRangeRecursively(node.right, key1, key2);
        }
    }

    public static void main(String args[]) throws IOException, ParseException {
        Dictionary dictionary = new Dictionary();
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader("dictionary.json"));
        System.out.println(obj);
        for (Object Key : obj.keySet()) {
            dictionary.insert(Key.toString(), obj.get(Key).toString());
        }
        List<Entry> listOfNodes = dictionary.inorder();
        dictionary.printList(listOfNodes);
        dictionary.deleteKey("C");
        List<Entry> listOfNodes2 = dictionary.inorder();
        dictionary.printList(listOfNodes2);
        System.out.println(dictionary.searchValue("D"));
        System.out.println(dictionary.searchValue("A"));
        dictionary.insert("C", "Cat");
        List<Entry> keysBetweenKeys = dictionary.findInRange("B", "D");
        dictionary.printList(keysBetweenKeys);
    }
}