import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* In this class, with the preprocesses applied to the texts, integers given uniquely
for each word are taken from the previously created map, and each sentence is expressed with that integers.*/
public class TextPreprocessing {
public List<List<Integer>> preprocessing(String str, Map map){
    str = str.replaceAll(",", "").replaceAll(";", "").toLowerCase();
    List<String> sentences = Arrays.asList(str.trim().split("[.]")); // This is for sentence splitting.
    List<List<Integer>> arr = new ArrayList<>();
    for (int i = 0; i < sentences.size(); i++) {
        List<String> temp = Arrays.asList(sentences.get(i).trim().split("\\s+")); // This makes a word list of current sentence.
        List<Integer> temp_int = new ArrayList<>();
        for (int j = 0; j < temp.size(); j++) {
            if((map.get(temp.get(j))) != null){
                temp_int.add((int) map.get(temp.get(j))); // This gets the integer value for specific word from previously created map and adds to the list.
            }
        }
        arr.add(temp_int); // This creates a list, which includes whole sentences represented with integers.

    }
    return arr;
}
}
