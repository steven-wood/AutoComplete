import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Steven on 7/24/2017.
 */
public class Main {
    public static void main(String[] args){
        TST tst = new TST();
        //tst.add("hello");
        //tst.add("pello");
        try {
            DictionaryLoader.loadFromTwoTXT(tst,"res/dict3", "res/dict2");
            DictionaryLoader.loadPopular(tst, "res/popular");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //tst.increaseFrequency("computer");
        Frame f = new Frame();
        //System.out.println(Correction.reccommend(tst.getAllWordsUnderEditDistance("comoter", 2)));
    }


}
