package cse214hw1;

import java.util.NoSuchElementException;

public class ArrayDeque<T> implements Deque<T> {
    private int head;
    private int tail;
    private T[] queue;
    private int defaultCapacity = 5;
    private int capacity = defaultCapacity;

    private enum Mode {
        AddToFront,
        AddToEnd;
    }

    private void resizeArray(Mode mode) {
        T[] temp = (T[]) new Object[capacity * 2];
        if (tail > head && mode == Mode.AddToEnd) {
            for (int i = 0; i < queue.length; i++) {
                temp[i] = queue[i];
            }
        } else if (tail > head && mode == Mode.AddToFront) {
            for (int i = queue.length - 1; i >= 0; i--) {
                temp[i + capacity] = queue[i];
            }
            head += capacity;
            tail += capacity;
        } else if (tail < head) {
            for (int i = 0; i <= tail; i++) {
                temp[i] = queue[i];
            }
            for (int i = queue.length - 1; i >= head; i--) {
                temp[i + capacity] = queue[i];
            }
            head += capacity;
        }
        capacity = 2 * capacity;
        queue = temp;
    }


    public ArrayDeque() {
        queue = (T[]) new Object[defaultCapacity];
        head = 0;
        tail = 0;
    }

    public ArrayDeque(int x) {
        queue = (T[]) new Object[x];
        capacity = x;
        head = 0;
        tail = 0;

    }

    public static <T> ArrayDeque<T> of(T... args) {
        ArrayDeque<T> newArr = new ArrayDeque<T>(args.length);
        newArr.capacity = args.length;
        newArr.head = 0;
        newArr.tail = args.length - 1;
        for (int i = 0; i < args.length; i++) {
            newArr.queue[i] = args[i];
        }
        return newArr;
    }

    @Override
    public void addFirst(T t) {
        if (t == null) {
            throw new NullPointerException("Cant add a null value");
        }
        int newHead = head - 1 < 0 ? queue.length - 1 : head - 1;
        if (newHead == tail) {
            resizeArray(Mode.AddToFront);
        }
        queue[head] = t;
        head = head - 1 < 0 ? queue.length - 1 : head - 1;
    }

    @Override
    public void addLast(T t) {
        if (t == null) {
            throw new NullPointerException("Cant add a null value");
        }
        int newTail = tail + 1 >= queue.length ? 0 : tail + 1;
        if (newTail == head) {
            resizeArray(Mode.AddToEnd);
        }
        tail = tail + 1 >= queue.length ? 0 : tail + 1;
        queue[tail] = t;
    }


    @Override
    public T removeFirst() {
        if (head == tail) {
            throw new NoSuchElementException("Queue is empty");
        }
        head = head + 1 >= queue.length ? 0 : head + 1;
        T oldValue = queue[head];
        return oldValue;

    }

    @Override
    public T removeLast() {
        if (head == tail) {
            throw new NoSuchElementException("Queue is empty");
        }
        T oldValue = queue[tail];
        tail = tail - 1 < 0 ? queue.length - 1 : tail - 1;
        return oldValue;
    }

}





