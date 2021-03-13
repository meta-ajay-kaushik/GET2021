package dictionary;
public class Entry {
    public String key;
    public String value;
    Entry left,right;
    public Entry(String key,String value){
        this.key=key;
        this.value=value;
        left=right=null;
    }
    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
}