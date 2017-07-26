import java.util.ArrayList;
import java.util.List;

public class Correction {

    public static List<TST.edContainer> reccommend(ArrayList<TST.edContainer> list){
        list.sort(TST.edContainer::compareTo);
        return list.subList(0, 3);
    }


}
