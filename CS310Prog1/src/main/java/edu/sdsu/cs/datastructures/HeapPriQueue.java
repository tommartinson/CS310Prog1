package edu.sdsu.cs.datastructures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Code written by Thomas Martinson (cssc0208) and Blake Meyers (cssc0226)
 */

public class HeapPriQueue<E> implements IPriorityQueue<E>{

    private PriorityQueue<E> queue = new PriorityQueue<E>();
    private Comparator gauge = Comparator.naturalOrder();


    public HeapPriQueue(){}
    public HeapPriQueue(Comparator comparator){
        gauge = comparator;
    }


    @Override
    public Comparator comparator() {

        return gauge;

    }

    @Override
    public void enqueue(E item) {
        queue.add(item);

    }

    @Override
    public E poll() {
        return queue.poll();
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public int size() {

        return queue.size();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }
}
