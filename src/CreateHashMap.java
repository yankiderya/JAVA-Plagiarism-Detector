import java.util.HashMap;
import java.util.Map;

/* This class builds a hashmap using main and sub file words. First combines two documents.
Then puts every unique word as a key and gives them an integer as a value.It includes also some replacings.*/
public class CreateHashMap {
    public Map hashmap(String main,String sub){
        main = main.replaceAll(",", "").replaceAll(";", "").toLowerCase();
        sub = sub.replaceAll(",", "").replaceAll(";", "").toLowerCase();

        String combine = main + " " + sub;
        combine = combine.replaceAll("\\.", "");
        Map map = new HashMap();
        String[] words = combine.split(" ");
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        return map;
    }
}
