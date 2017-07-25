import java.util.Arrays;

/**
 * Created by Steven on 7/24/2017.
 */
public class Util {

    public static void  arrayToString(int[][] array){
        String aString = "";
        for(int row = 0; row < array.length; row++) {
            for(int col = 0; col < array[row].length; col++) {
                aString += " " + array[row][col];
            }
            aString += "\r\n";
        }
        System.out.print(aString);
    }
}
