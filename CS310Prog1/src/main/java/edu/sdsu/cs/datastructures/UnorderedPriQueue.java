package edu.sdsu.cs.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Code written by Thomas Martinson (cssc0208) and Blake Meyers (cssc0226)
 */

public class UnorderedPriQueue<E> implements IPriorityQueue<E>{

    private ArrayList<E> information = new ArrayList<E>();
    private Comparator judge = Comparator.naturalOrder();

    public UnorderedPriQueue(){}

    public UnorderedPriQueue(Comparator comparator){
        judge = comparator;
    }

    @Override
    public Comparator<E> comparator() {
        return judge;
    }

    @Override
    public void enqueue(E item) {
        information.add(item);
    }

    @Override
    public E poll() {
        //uses sequential search for removal
        if(information.size()>0) {
            E lowestPri = information.get(0);
            int indexOfLowest = 0;
            for (int i = 0; i < information.size(); i++) {
                if (comparator().compare(information.get(i),lowestPri) > 0) {
                    lowestPri = information.get(i);
                    indexOfLowest = i;
                }
            }

            information.remove(indexOfLowest);
            return lowestPri;
        }
        System.out.println("Invalid poll call, the list is empty.");
        return null;
    }


    @Override
    public E peek() {
        return information.get(0);
    }

    @Override
    public int size() {
        return information.size();
    }

    @Override
    public void clear() { information.clear(); }

    @Override
    public boolean isEmpty() {
        return information.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return information.iterator();
    }

}