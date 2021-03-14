package Counselling;
import java.util.HashMap;
public class Programs {
    String branchName;
    int capacity;
    HashMap<String,Integer> map;
    Programs(String branchName,int capacity){
        map.put(branchName, capacity);
    }
}