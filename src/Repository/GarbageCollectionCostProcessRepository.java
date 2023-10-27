package Repository;

import DataAccess.GarbageCollectionCostDAO;
import java.util.List;

public class GarbageCollectionCostProcessRepository implements IGarbageCollectionCostProcessRepository {

    @Override
    public void display(List<Integer> lt) {
        GarbageCollectionCostDAO.Instance().display(lt);
    }

}
