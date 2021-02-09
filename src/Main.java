import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        long generalStartTime = System.nanoTime();
        FileReading f = new FileReading();
        File folder = new File("src/texts");
        List<String> sub_texts = f.subtexts(folder); // Stores subtexts into list.
        for (int a = 0; a < sub_texts.size(); a++) {
            long startTime = System.nanoTime();
            String main_file = f.getFileData("src/texts/main_text.txt"); // Reads data of main text.
            String sub_file = f.getFileData("src/texts/" + sub_texts.get(a)); //  // Reads data of current sub text.
            List<String> sub_ori = Arrays.asList(sub_file.trim().split("[.]")); // To print original sentences,we keep it.
            if(main_file.isEmpty()){
                System.out.println((a+1)+") The main_text.txt document is empty!");
                continue;
            }
            else if(sub_file.isEmpty()){
                System.out.println((a+1)+") The '"+sub_texts.get(a)+"' document is empty!");
                continue;
            }
            CreateHashMap hm = new CreateHashMap();
            Map hashmap = hm.hashmap(main_file, sub_file); // Creating a general hashmap for every word in main_file and sub_file. All unique word has unique integer values.
            // Main_text preprocessing
            TextPreprocessing tp = new TextPreprocessing();
            List<List<Integer>> main_list = tp.preprocessing(main_file,hashmap); // Main file converting into sentences represented with integers.
            // Sub_text preprocessing
            List<List<Integer>> sub_list = tp.preprocessing(sub_file,hashmap); // Sub file converting into sentences represented with integers.
            Searching s = new Searching();
            ArrayList<Records> records = s.search(main_list,sub_list); // Searching operations happen.
            Long g_similarity = s.general_similarity(records); // General Similarity calculated.

            //Printing Section
            System.out.println((a+1)+") The general similarity score is: %" + g_similarity + " with "+sub_texts.get(a)+" file");
            if(records.size() !=0){
                if(records.size() >=5){
                    for (int i = 0; i < 5; i++) {
                        System.out.println("   "+sub_ori.get(records.get(i).getS_sentence() - 1) + ". || %" + records.get(i).getPercentage());
                    }
                }
                else{
                    for (int i = 0; i < records.size(); i++) {
                        System.out.println("   "+sub_ori.get(records.get(i).getS_sentence() - 1) + ". || %" + records.get(i).getPercentage());
                    }
                }

            }
            else{
                System.out.println("There is no similar sentence");
            }
            long endTime   = System.nanoTime();
            long totalTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
            System.out.println("Completed in "+totalTime+"ms");
        }
        long generalEndTime   = System.nanoTime();
        long GeneralTotalTime = TimeUnit.NANOSECONDS.toMillis(generalEndTime - generalStartTime);
        System.out.println("/////////////////////////  "+sub_texts.size()+" Files Checked In "+GeneralTotalTime+"ms  /////////////////////////");
    }
}

