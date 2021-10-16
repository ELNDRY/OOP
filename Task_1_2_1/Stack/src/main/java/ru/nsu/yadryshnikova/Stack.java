package ru.nsu.yadryshnikova;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Arrays;

public class Stack<T> implements Iterable<T> {

    private T[] arrayStack;
    private int count = 0;
    private int maxSize = 30;
    final private int LENGTHS_INCREASE = 2;

    public Stack() {
        arrayStack = (T[]) new Object[maxSize];
    }

    public void push(T item) {
        sizeChange(count + 1);
        arrayStack[count] = item;
        count += 1;
    }

    public void pushStack(Stack<T> stack) {
        int thisSize = stack.count + this.count;
        this.sizeChange(thisSize);
        System.arraycopy(stack.arrayStack, 0, this.arrayStack, this.count, stack.count);
        this.count += stack.count;
    }

    public T pop() {
        if (count <= 0) {
            throw new EmptyStackException();
        }
        count -= 1;
        return arrayStack[count];
    }

    public Stack<T> popStack(int size) {
        if (size < 0 || size > count) {
            throw new EmptyStackException();
        }
        Stack<T> poppedStack = new Stack<>();
        poppedStack.sizeChange(size);
        System.arraycopy(this.arrayStack, 0, poppedStack.arrayStack, 0, size);
        poppedStack.count = size;
        this.count -= size;
        return poppedStack;
    }

    public int count() {
        return count;
    }

    private void sizeChange(int toSize) {
        while (arrayStack.length < toSize) {
            arrayStack = Arrays.copyOf(arrayStack, arrayStack.length * LENGTHS_INCREASE);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterate();
    }

    private class Iterate implements Iterator<T> {
        int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < count;
        }

        @Override
        public T next() {
            pointer += 1;
            return arrayStack[pointer - 1];
        }
    }
}
