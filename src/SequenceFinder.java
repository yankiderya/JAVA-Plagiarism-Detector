import java.util.*;
public class SequenceFinder {
    /*This function divides a sentence in the main file into sublists starting
    from specified list length(startLength) and puts them in the hashmap.Then returns the hashmap.*/
    public Map createMainMap(List<Integer> main_text, int startLength) {
        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        int counter = 0;
        for (int length = startLength; length < main_text.size() + 1; length++) {
            for (int startIndex = 0; startIndex + length < main_text.size() + 1; startIndex++) {
                List<Integer> sublist = main_text.subList(startIndex, startIndex + length);
                map.put(sublist, counter);
                counter++;// [8,10]

            }
        }
        return map;
    }
    /*This function gets the whole subtext divides all sentences into sublists starting
    from specified list length(startLength) and puts them in the nested list.Then returns the list.*/
    public List<List<List<Integer>>> createSubLists(List<List<Integer>> sub, int startLength) {
        List<List<List<Integer>>> ListofLists = new ArrayList<>();
        for (int i = 0; i < sub.size(); i++) {
            List<List<Integer>> list = new ArrayList<>();
            int counter = 0;
            for (int length = startLength; length < sub.get(i).size() + 1; length++) {
                for (int startIndex = 0; startIndex + length < sub.get(i).size() + 1; startIndex++) {
                    List<Integer> sublist = sub.get(i).subList(startIndex, startIndex + length);
                    list.add(sublist);
                    counter++;//

                }
            }
            ListofLists.add(list);
        }
        return ListofLists;
    }
    /* This function compares two sentences depending on sublists.Checks if each sublist of the sentence is in the map */
    public List<List<Integer>> findCommonSequence(Map map, List<List<List<Integer>>> subListList, int sub_index) {
        List<List<Integer>> commons = new ArrayList<>();

        for (int i = 0; i < subListList.get(sub_index).size(); i++) {
            if (map.get(subListList.get(sub_index).get(i)) != null) {
                commons.add(subListList.get(sub_index).get(i));
            }
        }

        for (int k = 0; k < commons.size(); k++) { // There are common ones here but this also includes
                                                    // short clusters belonging to a longer cluster. We simply put "null" on shorts and remove nulls below.
            for (int l = commons.size() - 1; l > k; l--) {
                if (commons.get(l).containsAll(commons.get(k))) {
                    commons.set(k, null);
                    k++;
                    l = commons.size();
                }
            }
        }
        while (commons.remove(null)) {
        }
        return commons;

    }
}
