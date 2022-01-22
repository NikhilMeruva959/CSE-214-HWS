package cse214hw1;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>{
    private int head;
    private int tail;
    private T[] queue;
    private int defaultCapacity = 5;


    public ArrayQueue(){
        queue = (T[]) new Object[defaultCapacity];
        head = tail = 0;
    }


    @Override
    public void add(T t){
        if (t == null) {
            throw new NullPointerException("Cant add a null value");
        }
        if((tail + 1) % queue.length == head){
            throw new NullPointerException("Array is Full");
        }
        queue[tail+1] = t;
        tail = (tail + 1)  % queue.length;
    }

    @Override
    public T remove(){
        if (head == tail) {
            throw new NoSuchElementException("Queue is empty");
        }
        T oldValue = queue[head];
        head = (head + 1) % queue.length;
        return  oldValue;
    }

    @Override
    public T peek(){
        if (head == tail) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[head];
    }
}

