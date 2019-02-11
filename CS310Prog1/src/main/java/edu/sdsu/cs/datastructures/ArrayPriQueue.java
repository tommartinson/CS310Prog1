package edu.sdsu.cs.datastructures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Code written by Thomas Martinson (cssc0208) and Blake Meyers (cssc0226)
 */

public class ArrayPriQueue<E> implements IPriorityQueue<E>{

    private ArrayList<E> storage = new ArrayList<E>();
    private Comparator evaluate = Comparator.naturalOrder();

    public ArrayPriQueue(){}

    public ArrayPriQueue(Comparator comparator){
        evaluate = comparator;
    }
    @Override
    public Comparator<E> comparator() {
        return evaluate;
    }

    @Override
    public void enqueue(E item) {
        int indexOf = binarySearch(storage, item, 0,size());
        storage.add(indexOf, item);

    }
    //Binary Search
    private int binarySearch(ArrayList<E> list, E target, int lo, int hi) {
        if(hi <= lo)
            return hi;
        int mid = (lo+hi)/2;
        int comp = ((Comparable<E>)target).compareTo(list.get(mid));
        if(comp == 0)
            return mid;
        if(comp < 0)
            return binarySearch(list, target, lo, mid);
        else return binarySearch(list, target, mid+1, hi);
    }


    @Override
    public E poll() {
        E removedVal = storage.get(0);
        storage.remove(0);
        return removedVal;
    }

    @Override
    public E peek() { return storage.get(0); }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() { storage.clear(); }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return storage.iterator();
    }
}