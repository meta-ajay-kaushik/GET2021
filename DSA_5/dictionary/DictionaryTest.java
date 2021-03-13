package dictionary;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DictionaryTest {

    @Test
    public void testCreateDictionaryAndSort() throws FileNotFoundException, IOException, ParseException {
        Dictionary dictionary = new Dictionary();
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader("dictionary.json"));
        for (Object Key : obj.keySet()) {
            dictionary.insert(Key.toString(), obj.get(Key).toString());
        }
        List<Entry> listOfNodes = dictionary.inorder();
        List<Entry> expected = new ArrayList<>();
        expected.add(new Entry("A","Apple"));
        expected.add(new Entry("B","Boy"));
        expected.add(new Entry("C","Cat"));
        expected.add(new Entry("D","Dog"));
        expected.add(new Entry("E","Eye"));
        for(int count = 0; count < 5; count++){
            assertEquals(listOfNodes.get(count).key,expected.get(count).key);
            assertEquals(listOfNodes.get(count).value,expected.get(count).value);
        }
    }
    
    @Test
    public void testAddInDictionary() throws FileNotFoundException, IOException, ParseException {
        Dictionary dictionary = new Dictionary();
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader("dictionary.json"));
        for (Object Key : obj.keySet()) {
            dictionary.insert(Key.toString(), obj.get(Key).toString());
        }
        dictionary.insert("F", "Fan");
        List<Entry> listOfNodes = dictionary.inorder();
        List<Entry> expected = new ArrayList<>();
        expected.add(new Entry("A","Apple"));
        expected.add(new Entry("B","Boy"));
        expected.add(new Entry("C","Cat"));
        expected.add(new Entry("D","Dog"));
        expected.add(new Entry("E","Eye"));
        expected.add(new Entry("F","Fan"));
        for(int count = 0; count < 6; count++){
            assertEquals(listOfNodes.get(count).key,expected.get(count).key);
            assertEquals(listOfNodes.get(count).value,expected.get(count).value);
        }
    }

    @Test
    public void testDeleteFromDictionary() throws FileNotFoundException, IOException, ParseException {
        Dictionary dictionary = new Dictionary();
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader("dictionary.json"));
        for (Object Key : obj.keySet()) {
            dictionary.insert(Key.toString(), obj.get(Key).toString());
        }
        dictionary.deleteKey("B");
        List<Entry> listOfNodes = dictionary.inorder();
        List<Entry> expected = new ArrayList<>();
        expected.add(new Entry("A","Apple"));
        expected.add(new Entry("C","Cat"));
        expected.add(new Entry("D","Dog"));
        expected.add(new Entry("E","Eye"));
        for(int count = 0; count < 4; count++){
            assertEquals(listOfNodes.get(count).key,expected.get(count).key);
            assertEquals(listOfNodes.get(count).value,expected.get(count).value);
        }
    }
    
    @Test
    public void testSearchFromDictionarySuccessfully(){
        Dictionary dictionary = new Dictionary();
        dictionary.insert("A","Apple");
        dictionary.insert("C","Cat");
        dictionary.insert("D","Dog");
        assertEquals("Apple",dictionary.searchValue("A"));
    }
    
    @Test
    public void testSearchFromDictionaryUnsuccessfully(){
        Dictionary dictionary = new Dictionary();
        dictionary.insert("A","Apple");
        dictionary.insert("C","Cat");
        dictionary.insert("D","Dog");
        assertEquals("No Key found..!!",dictionary.searchValue("E"));
    }
    
    @Test
    public void testFindInRange() throws FileNotFoundException, IOException, ParseException {
        Dictionary dictionary = new Dictionary();
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader("dictionary.json"));
        for (Object Key : obj.keySet()) {
            dictionary.insert(Key.toString(), obj.get(Key).toString());
        }
        List<Entry> listOfNodes = dictionary.findInRange("C","E");
        List<Entry> expected = new ArrayList<>();

        expected.add(new Entry("C","Cat"));
        expected.add(new Entry("D","Dog"));
        expected.add(new Entry("E","Eye"));

        for(int count = 0; count < 3; count++){
            assertEquals(listOfNodes.get(count).key,expected.get(count).key);
            assertEquals(listOfNodes.get(count).value,expected.get(count).value);
        }
    }
}
