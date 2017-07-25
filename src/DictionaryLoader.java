import java.io.*;
import java.util.ArrayList;

public class DictionaryLoader {

    /*
 * Adds the Strings from two text files in alternating order.
 */
    public static void loadFromTwoTXT(TST tst, String fileNameOne, String fileNameTwo) throws FileNotFoundException, IOException {
        File firstFile = new File(fileNameOne);
        ArrayList<String> firstList = new ArrayList<String>();
        try(BufferedReader br = new BufferedReader(new FileReader(firstFile))) {
            for(String line; (line = br.readLine()) != null; )
                firstList.add(line);
        }
        ArrayList<String> secondList = new ArrayList<String>();
        File secondFile = new File(fileNameTwo);
        try(BufferedReader br = new BufferedReader(new FileReader(secondFile))) {
            for(String line; (line = br.readLine()) != null; )
                secondList.add(line);
        }
        int smallest = (firstList.size()<=secondList.size())?firstList.size():secondList.size();
        for(int i=0;i<smallest;i++){
            tst.add(firstList.get(i));
            tst.add(secondList.get(i));
        }
        //GET EXTRAS
        if(firstList.size()<secondList.size()){
            for(int i=firstList.size()+1;i<secondList.size()-firstList.size();i++){
                tst.add(secondList.get(i));
            }
        } else if(secondList.size()<firstList.size()){
            for(int i=secondList.size()+1;i<firstList.size()-secondList.size();i++){
                tst.add(firstList.get(i));
            }
        }
    }

    public static void loadPopular(TST tst, String fileName) throws FileNotFoundException, IOException {
        File firstFile = new File(fileName);
        ArrayList<String> firstList = new ArrayList<String>();
        try(BufferedReader br = new BufferedReader(new FileReader(firstFile))) {
            for(String line; (line = br.readLine()) != null; )
                tst.setFrequency(line, 5);
        }

    }
}

