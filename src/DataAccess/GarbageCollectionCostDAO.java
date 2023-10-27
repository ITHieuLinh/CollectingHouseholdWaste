package DataAccess;

import common.Library;
import java.util.List;

public class GarbageCollectionCostDAO {

    private static GarbageCollectionCostDAO instance = null;
    Library l;

    public GarbageCollectionCostDAO() {
        l = new Library();
    }

    public static GarbageCollectionCostDAO Instance() {
        if (instance == null) {
            synchronized (GarbageCollectionCostDAO.class) {
                if (instance == null) {
                    instance = new GarbageCollectionCostDAO();
                }
            }
        }
        return instance;
    }

    public void getGarbage(List<Integer> lt) {
        int n = l.getIntNoLimit("How many location you want to input: ");
        int i = 0;
        while (i < n) {
            int input = l.getIntNoLimit("Enter the amount of garbage at each station(in kg): ");
            lt.add(input);
            i++;
        }

    }

    public float calculator(List<Integer> lt) {
        int totalGarbage = 0;
        int time = 0;
        int count = 1;
        for (int i = 0; i < lt.size(); i++) {
            time += 8;
            if ((totalGarbage + lt.get(i)) >= 10000) {
                time += 30;
                totalGarbage = 0;
                count++;
            }
            totalGarbage += lt.get(i);

        }
        if (totalGarbage > 0) {
            time += 30;
        }
        float time1 = (float) time / 60;
        float totalCost = (time1 * 120000) + (57000 * count);
        return totalCost;
    }

    public void display(List<Integer> lt) {
        while (true) {
            getGarbage(lt);
            float a = calculator(lt);
            System.out.println("The total cost: " + a + "VND");
            lt.clear();
            if (!l.checkInputYN("Do you want to continue(Y/N)?: ")) {
                return;
            }
        }
    }
}
