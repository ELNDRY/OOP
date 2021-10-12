package ru.nsu.yadryshnikova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.ArrayList;

class StackTest {

    class SomeClass{};

    Stack<Integer> intStack;

    @BeforeEach
    void stack_init() {
        intStack = new Stack<>();
    }

    @Test
    void push_pop_int() {
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(-100);
        intStack.push(-14);
        intStack.push(-16);
        Assertions.assertEquals(-16, intStack.pop());
        Assertions.assertEquals(-14, intStack.pop());
        Assertions.assertEquals(-100, intStack.pop());
        Assertions.assertEquals(4, intStack.pop());
        Assertions.assertEquals(3, intStack.pop());
        Assertions.assertEquals(2, intStack.pop());
        Assertions.assertEquals(1, intStack.pop());
    }

    @Test
    void push_pop_hugeInt() {
        int hugeInt;
        for (int i = 1; i < 15; i++) {
            hugeInt = i * 1000000;
            intStack.push(hugeInt);
        }

        for (int i = 14; i >=1; i--) {
            hugeInt = i * 1000000;
            Assertions.assertEquals(hugeInt, intStack.pop());
        }
    }

    @Test
    void pushStack_empty() {
        Stack<Integer> emptyStack = new Stack<>();
        intStack.pushStack(emptyStack);

        Assertions.assertEquals(0, intStack.count());
    }

    @Test
    void pushStack_int() {
        Stack<Integer> pushedStack = new Stack<>();
        pushedStack.push(14);
        pushedStack.push(-14);
        pushedStack.push(1000);
        pushedStack.push(-1000);
        intStack.pushStack(pushedStack);

        Assertions.assertEquals(-1000, intStack.pop());
        Assertions.assertEquals(1000, intStack.pop());
        Assertions.assertEquals(-14, intStack.pop());
        Assertions.assertEquals(14, intStack.pop());
    }

    @Test
    void pushStack_someType() {
        Stack<SomeClass> stack_1 = new Stack<>();
        Stack<SomeClass> stack_2 = new Stack<>();
        Stack<SomeClass> stack_3 = new Stack<>();
        Stack<SomeClass> stack_4 = new Stack<>();
        SomeClass someClass = new SomeClass();
        stack_1.push(someClass);
        stack_2.pushStack(stack_1);
        stack_3.pushStack(stack_2);
        stack_4.pushStack(stack_3);

        Assertions.assertEquals(someClass, stack_4.pop());
        Assertions.assertEquals(someClass, stack_3.pop());
        Assertions.assertEquals(someClass, stack_2.pop());
        Assertions.assertEquals(someClass, stack_1.pop());
    }

    @Test
    void popStack_empty() {
        Stack<Integer> emptyStack = intStack.popStack(0);
        Assertions.assertEquals(0, emptyStack.count());
    }

    @Test
    void popStack_int() {
        intStack.push(14);
        intStack.push(-14);
        intStack.push(1000);
        intStack.push(-1000);

        Stack<Integer> stack = intStack.popStack(4);

        Assertions.assertEquals(-1000, stack.pop());
        Assertions.assertEquals(1000, stack.pop());
        Assertions.assertEquals(-14, stack.pop());
        Assertions.assertEquals(14, stack.pop());
        Assertions.assertEquals(0, intStack.count());
    }

    @Test
    void popStack_someType() {
        Stack<SomeClass> stack_1 = new Stack<>();
        SomeClass someClass = new SomeClass();

        stack_1.push(someClass);
        Stack<SomeClass> stack_2 = stack_1.popStack(1);
        Assertions.assertEquals(someClass, stack_2.pop());
    }

    @Test
    void count() {
        Stack<Integer> countStack = new Stack<>();
        int cnt = 0;
       for (int i = 0; i < 100000; i++) {
           countStack.push(i);
           cnt += 1;
           Assertions.assertEquals(countStack.count(), cnt);
       }
    }

    @Test
    void forEach_int() {
        intStack.push(14);
        intStack.push(-14);
        intStack.push(1000);
        intStack.push(-1000);

        Integer[] expected = {14, -14, 1000, -1000};
        List<Integer> actual = new ArrayList<>();

        for (Integer item : intStack) {
            actual.add(item);
        }

        Assertions.assertArrayEquals(expected, actual.toArray());
    }
}