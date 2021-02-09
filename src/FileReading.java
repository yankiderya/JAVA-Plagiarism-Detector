import java.io.File;  // Import the File class
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileReading {
    public String getFileData(String filename)  // This function simply reads the file and returns the data.
    {
        String data = "";

        {
            try {
                data = new String(Files.readAllBytes(Paths.get(filename)));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return data;
    }
    public <T> List<String> subtexts(File folder){  // This function gets the all files names under specified folder and puts all sub documents into list the returns it.
        File[] listOfFiles = folder.listFiles();
        List<String> sub_texts = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("main_text.txt")) {
                sub_texts.add(listOfFiles[i].getName());
            }
        }
        return sub_texts;
    }
}
