package ru.baevdev.stack;

public class Stack<T>{

    private Element head;

    class Element {
        T data;
        Element next;

        public Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public void push(T data) {
        head = new Element(data, head);
    }

    public T pop() {
        if (head == null) {
            throw new IllegalArgumentException("Head - null");
        }
        T dataHead = head.data;
        head = head.next;
        return dataHead;
    }

    public T peek() {
        return head.data;
    }

    public int size() {
        int counter = 0;
        Element tmpHead = head;

        while (tmpHead != null) {
            counter++;
            tmpHead = tmpHead.next;
        }
        return counter;
    }
}
