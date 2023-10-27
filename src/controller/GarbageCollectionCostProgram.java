package controller;

import Repository.GarbageCollectionCostProcessRepository;
import java.util.ArrayList;
import java.util.List;

public class GarbageCollectionCostProgram {

    List<Integer> lt;
    GarbageCollectionCostProcessRepository program;

    public GarbageCollectionCostProgram() {
        lt = new ArrayList<Integer>();
        program = new GarbageCollectionCostProcessRepository();
    }

    public void run() {
        System.out.println("\t----- Garbage Collection -----");

        program.display(lt);
    }
}
