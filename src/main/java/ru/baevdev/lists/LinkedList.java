package ru.baevdev.lists;

public class LinkedList <T> {
    private Element head;
    private Element tail;
    private class Element {
        T data;
        Element next;

        public Element(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "data=" + data +
                    '}';
        }
    }

    public void addStart(T data) {
        Element element = new Element(data);
        if (head == null) {
            head = tail = element;
        } else {
            element.next = head;
            head = element;
        }
    }

    public void addEnd(T data) {
        Element element = new Element(data);
        if(tail == null) {
            head = tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
    }

    public T deleteStart() {
        if(head == null) {
            throw new IllegalArgumentException("List is null");
        }
        T dataElement = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return dataElement;
    }

    public T deleteEnd() {
        T dataElement;
        if(tail == null) {
            throw new NullPointerException("List is null");
        }
        if(head.next == null) {
            dataElement = head.data;
            head = tail = null;
            return dataElement;
        }

        Element currentElement, prevElement;
        for(currentElement = head, prevElement = currentElement; currentElement.next != null; prevElement = currentElement,
            currentElement = currentElement.next) {}
        dataElement = currentElement.data;
        prevElement.next = null;
        tail = prevElement;
        return dataElement;
    }

    public void showList() {
        Element tmpHead = head;

        while (tmpHead != null) {
            System.out.print(tmpHead.data + " ");
            tmpHead = tmpHead.next;
        }
        System.out.println();
    }

    public int size() {
        int counter = 0;
        Element tmpHead = tail;

        while (tmpHead != null) {
            counter++;
            tmpHead = tmpHead.next;
        }
        return counter;
    }
}