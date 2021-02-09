import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Searching {
    public <T>ArrayList<Records> search(List<List<Integer>> main,List<List<Integer>> sub){
        ArrayList<Records> records = new ArrayList<>(); // Arraylist of Records class
        ArrayList<TempRecords> t_records = new ArrayList<>(); // Arraylist of tempRecords class
        SequenceFinder sf = new SequenceFinder();
        List<List<List<Integer>>> subListList = sf.createSubLists(sub,2); // We call this function once, give sub file and startLength parameters.It creates all sublists and stores here.
        for (int i = 0; i < main.size(); i++) {
            List<Integer> list1 = new ArrayList(main.get(i)); // Creates a list of current sentence for main.

            Map main_map =sf.createMainMap(list1,2); // Calls createMainMap function every new sentence of main and creates a hashmap for current sentence.
            for (int j = 0; j < sub.size(); j++) {
                List<List<Integer>> common_s = sf.findCommonSequence(main_map,subListList,j); // Returns common subsequences between current sub sentence and main sentence and stores the in list.

                if (common_s.size() > 0) {
                    int score = 0; // Score is the individual subsequences length.
                    for (int k = 0; k < common_s.size(); k++) { // This loop iterates whole common_s list , gets every subsequence length and sums up them.
                        score = score + common_s.get(k).size(); // For example we have common_s:[[2,5],[3,4,7],[9,10,1,2]] . Score is 2+3+4=9.
                    }
                    Long percentage = (long) (score * 100 / list1.size()); // This is the percentage calculation.
                    TempRecords tr = new TempRecords(); // We store percentage and sub sentence informations in t_records below using this "tr" object.
                    tr.setPercentage(percentage);
                    tr.setS_sentence(j + 1);
                    t_records.add(tr);
                }


            }
            if(t_records.size()>0){
                t_records.sort(new TempSorter()); // We sort the t_records first.
                Records r = new Records();
                r.setM_sentence(i + 1); // Put current main sentence.
                r.setPercentage(t_records.get(0).getPercentage()); // Gets the first index as a maximum percentage for current main sentence,and stores it.
                r.setS_sentence(t_records.get(0).getS_sentence()); // Gets the sub sentence combined with max percentage and stores it.
                records.add(r); // Put all information to the records arraylist.
                t_records.clear();
            }




        }
        records.sort(new Sorter()); // Sorting happens for records depending on percentages.
        return records;
    }
    public Long general_similarity(ArrayList<Records> records){ // This function returns arithmetic mean of percentages stored in records list.
        Long g_similarity = (long) 0;
        for (int i = 0; i < records.size(); i++) {
            g_similarity = g_similarity + records.get(i).getPercentage();
        }
        if(records.size() !=0){
            g_similarity = g_similarity / records.size();
        }
        return g_similarity;
    }
}
