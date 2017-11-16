/* Name: Generic LinkedList implementation 
 * Authors: James Ponwith and Patrick Hall
 * Date:  11/12/2017
 * Description: 
 * This program provides a usable, generic LinkedList class.
 * Methods available to this class are written blelow. 
 * Main method of this program tests the methods written.
 */

import java.util.LinkedList;

public class MyLinkedList<T> {
    // the Node class is a private inner class used (only) by the LinkedList class
    private class Node {
        private Object data;
        private Node next;

        public Node(Object a, Node n) {
            data = a;
            next = n;
        }
    }

    private Node first;
    private int length;  // to enable an O(1) size method

    public MyLinkedList() {
        first = null;
        length = 0;  // added after considering the size() method
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void addFirst(Object d) {
        /* These two lines can be reduced to the single line which follows
         *   Node temp = first;
         *   first = new Node(d,temp);
         */        
        first = new Node(d,first);
        length++;
    }

    public int size() {
        /*  This O(n) loop can be replaced by the O(1) return once we have the length field
            int count = 0;
            for (Node curr = first; curr != null; curr = curr.next)
            count++;
            return count;
            */
        return length;
    }

    public void clear() {
        first = null;
        length = 0;
    }

    public boolean contains(Object value) {
        for (Node curr = first; curr != null; curr = curr.next) {
            if (value.equals(curr.data)) {
                // this implies that the data must have an overridden .equals() method!
                return true;
            }
        }
        return false;
    }

    public Object get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return null;
        }
        Node curr = first;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.data;
    }

    public boolean remove(Object m) {
        if (isEmpty()) {
            return false;
        }
        if (m.equals(first.data)) {
            first = first.next;
            length--;
            return true;
        }
        Node curr = first;
        while (curr.next != null) {
            if (m.equals(curr.next.data)) {
                // this implies that the data must have an overridden equals() method!
                curr.next = curr.next.next;
                length--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();  //String result = "";

        for (Node curr = first; curr != null; curr = curr.next) {
            result.append(curr.data + "->");  //result = result + curr.data + "->";
        }
        result.append("[null]");
        return result.toString();   //return result + "[null]";
    }
    // ------------------------  HW4 methods start here ------------------------

    /**
     * Returns the first element's data of the list
     */
    public Object getFirst() {
        if (first == null) {
            System.out.println("Error - Linked List is empty");
            return null;
        }
        return first.data;
    }

    /**
     * Returns the last element's data
     */
    public Object getLast() {
        Node start = this.first;
        if (start == null) {
            System.out.println("Error - Linked List is empty");
            return null;
        }
        // loop through to the last element
        while(start.next != null) {
            start = start.next;
        }
        return start.data;
    }

    /**
     * Adds an node with the paramater's value
     * to the end of the list
     */
    public void add(Object value) {
        Node start = this.first;
        if (start == null) {
            addFirst(value);
            return;
        }
        // Loop through to end of the list
        while(start.next != null) {
            start = start.next;
        }
        Node newNode = new Node(value, null);
        start.next = newNode;
        length++;
    }

    /**
     * Add an element, (2nd param) after the specified index (1st param)
     */
    public void addAfter(int index, Object value) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return;
        }

        Node start = this.first;
        // loop up to index
        for(int counter = 0; counter < index; counter++) {
            start = start.next;
        }
        Node nextNode = start.next;
        // insert node at current location, having it point to the node after
        start.next = new Node(value, nextNode);
        length++;
    }

    /**
     * Set the value(2nd param) of the node at specified index (1st param)
     */
    public Object set(int index, Object newValue) {
        if (index < 0 || index >= length) {
            System.out.println("Index of " + index + " out of range");
            return null;
        }

        Node start = this.first;
        // loop until specified index
        for(int counter = 0; counter < index; counter++) {
            start = start.next;
        }
        // copy old data
        Object oldData = start.data;
        // set data to newValue
        start.data = newValue;
        return oldData;
    }

    /**
     * Returns the index of the last element
     */
    public int lastIndex(Object value) {
        Node start = this.first;
        int lastOccur = -1;

        for(int counter = 0; counter < this.size(); counter++) {
            if(start.data == value) {
                lastOccur = counter;
            }
            start = start.next;
        }

        if(lastOccur == -1) {
            return -1;
        }

        return lastOccur;
    }

    // Check  
    /**
     * Creates a shallow copy of this list
     */
    public MyLinkedList<T> clone() {
        MyLinkedList<T> clone = this;
        return clone;
    }

    /**
     * Removes all instances of the value passed
     */
    public void removeAll(Object value) {
        Node start = this.first;
        while (start.next != null) {
            if (start.next.data == value) {
                start.next = start.next.next;
            }
            else {
                start = start.next;
            }
        }
    }

    /**
     * Checks arrays are equal size and each element is equal
     */
    @Override
    public boolean equals(Object o) {
        MyLinkedList<T> list = null;
        try {
            @SuppressWarnings("unchecked")
            MyLinkedList<T> tempList = (MyLinkedList<T>)o;
            list = tempList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Node start1 = this.first;
        Node start2 = list.first;
        int counter = 0;
        if(this.length == list.length) {
            while(counter < list.length) {
                if(start1.data == start2.data) {
                    start1 = start1.next;
                    start2 = start2.next;
                }
                else {
                    return false;
                }
                counter++;
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + length;
        return hash;
        //return Objects.hash(length);
    } 

    /**
     * Splits the original list leaving the original with the
     * first half of the list and returns a reference to
     * a new list which contains the second half of the list
     */
    public MyLinkedList<T> split() {
        int middle;
        if (this.size() % 2 == 0) {
            middle = this.size() / 2 - 1;
        }
        else {
            middle = this.size() / 2;
        }
        if (this.size() == 0) {
            System.out.println("Cannot split");
            return this;
        }
        Node start = this.first;
        for (int i = 0; i < middle; i++) {
            start = start.next; 
        }
        MyLinkedList<T> back = new MyLinkedList<>();

        while (start.next != null) {
            Node newNode = new Node(start.data, start.next);
            back.add(newNode.data);
            start = start.next;
        }

        Node end = this.first;
        for (int i = 0; i < middle; i++) {
            end = end.next;
        }
        end.next = null;
        return back;
    }

    /**
     * Doubles each element of the list
     * Ex. Original: 1, 2, 3 --> 1, 1, 2, 2, 3, 3
     */
    public void doubler() {
        if (length == 0) {
            System.out.println("List is empty");
        }
        Node start = this.first;
        int pos = 0;
        //Loop to last element
        while (start.next != null) {
            this.addAfter(pos, start.data);
            start = start.next.next;
            pos += 2;
            length++;
        }
        // Add the last element 
        add(start.data);
    }

    /**
     * Returns a reference to a sublist of the original list
     */
    public MyLinkedList<T> sublist(int i, int j) {
        if ((i < 0 || i >= length) || (j < 0 || j >= length)) {
            System.out.println("Index of out of range");
            return null;
        }

        MyLinkedList<T> sub = new MyLinkedList<>();
        Node start = this.first;
        int pos = 0;
        while(pos < i) {
            start = start.next;
            pos++;
        }
        sub.add(start.data);
        while(start.next != null) {
            start = start.next;
            sub.add(start.data);
        }
        return sub;
    }

    public static void main(String[] args) {
        System.out.println("\ngetFirst() Test:");
        System.out.println("------------------------------------");

        MyLinkedList<String> gf1 = new MyLinkedList<String>();
        MyLinkedList<String> gf2 = new MyLinkedList<String>();
        MyLinkedList<String> gf3 = new MyLinkedList<String>();
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;
        
        gf1.add("node1");

        gf2.add("node1");
        gf2.add("node2");

        gf3.add("node1");
        gf3.add("node2");
        gf3.add("node3");

        System.out.println("1-element list: \t" + gf1);
        System.out.println("First element: \t\t" + gf1.getFirst());

        System.out.println("2-element list: \t" + gf2);
        System.out.println("First element: \t\t" + gf2.getFirst());

        System.out.println("3-element list: \t" + gf3);
        System.out.println("First element: \t\t" + gf3.getFirst());

        MyLinkedList<String> emptyList = new MyLinkedList<String>();

        boolean firstFail = false;
        if(emptyList.getFirst() == null) {
            firstFail = true;
        }

        System.out.println(" ");
        System.out.println("Results: ");
        System.out.println("Test 1:\t\t" + (gf1.getFirst() == "node1" ? "PASSED" : "FAILED"));
        System.out.println("Test 2:\t\t" + (gf1.getFirst() == "node1" ? "PASSED" : "FAILED"));
        System.out.println("Test 3:\t\t" + (gf1.getFirst() == "node1" ? "PASSED" : "FAILED"));

        System.out.println("Test for null list:\t\t" + (firstFail ? "PASSED" : "FAILED"));

        /*=====================================================*/

        System.out.println("\n\ngetLast() Test:");
        System.out.println("------------------------------------");

        System.out.println("1-element list: \t" + gf1);
        System.out.println("Last element: \t\t" + gf1.getLast());

        System.out.println("2-element list: \t" + gf2);
        System.out.println("Last element: \t\t" + gf2.getLast());

        System.out.println("3-element list: \t" + gf3);
        System.out.println("Last element: \t\t" + gf3.getLast());

        boolean lastFail = false;
        if(emptyList.getLast() == null) {
            lastFail = true;
        }

        System.out.println("Test 1:\t\t" + (gf1.getLast() == "node1" ? "PASSED" : "FAILED"));
        System.out.println("Test 2:\t\t" + (gf2.getLast() == "node2" ? "PASSED" : "FAILED"));
        System.out.println("Test 3:\t\t" + (gf3.getLast() == "node3" ? "PASSED" : "FAILED"));

        System.out.println("Test for null list:\t\t" + (lastFail ? "PASSED" : "FAILED"));

        /*====================================================*/

        System.out.println("\n\nadd() Test:");
        System.out.println("------------------------------------");
        System.out.println("Element to add: \tadded"); 

        System.out.println("1-element list: \t" + gf1);
        gf1.add("added");
        System.out.println("After adding: \t\t" + gf1);

        System.out.println("2-element list: \t" + gf2);
        gf2.add("added");
        System.out.println("After adding: \t\t" + gf2);

        System.out.println("3-element list: \t" + gf3);
        gf3.add("added");
        System.out.println("After adding: \t\t" + gf3);

        System.out.println("Results:");
        System.out.println("1-element test:\t" + ((gf1.getLast() == "added") ? "PASSED" : "FAILED"));
        System.out.println("2-element test:\t" + ((gf2.getLast() == "added") ? "PASSED" : "FAILED"));
        System.out.println("3-element test:\t" + ((gf3.getLast() == "added") ? "PASSED" : "FAILED"));

        /*====================================================*/
        MyLinkedList<String> af1 = new MyLinkedList<String>();
        MyLinkedList<String> af2 = new MyLinkedList<String>();
        MyLinkedList<String> af3 = new MyLinkedList<String>();
        
        af1.add("1");
        af1.add("2");
        af1.add("3");

        af2.add("1");
        af2.add("2");
        af2.add("3");
        af2.add("4");

        af3.add("1");
        af3.add("2");
        af3.add("3");
        af3.add("4");
        af3.add("5");
        af3.add("6");

        System.out.println("\n\naddAfter() Test:");
        System.out.println("------------------------------------");
        System.out.println("Element to add: \tadded"); 
        int index = 0;

        System.out.println("Index to add after:\t" + index);
        System.out.println("List 1: \t\t" + af1);
        af1.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af1);

        index++;
        System.out.println("Index to add after:\t" + index);
        System.out.println("List 2: \t\t" + af2);
        af2.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af2);
        
        index++;
        System.out.println("Index to add after:\t" + index);
        System.out.println("List 3: \t\t" + af3);
        af3.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af3);

        int indexError = 2;
        try {
            emptyList.addAfter(-7, 200);
            emptyList.addAfter(200, 200);

        }catch(Exception e) {
            System.out.println();
        }

        int indexT = 1;
        System.out.println("Results");
        System.out.println("List 1 Test\t\t" + ((af1.get(indexT) == "added")? "PASSED" : "FAILED"));
        System.out.println("List 2 Test\t\t" + ((af2.get(indexT+1) == "added")? "PASSED" : "FAILED"));
        System.out.println("List 3 Test\t\t" + ((af3.get(indexT+2) == "added")? "PASSED" : "FAILED"));
        
        try {
            System.out.println("Invalid index test\t\t" + (!(af3.get(indexT-7) == "added")? "PASSED" : "FAILED"));
            System.out.println("Invalid index test\t\t" + (!(af3.get(indexT+200) == "added")? "PASSED" : "FAILED"));
        }catch(Exception e) {
            System.out.println();
        }

        System.out.println("Invalid index test (Index -7):\t\t" + (!(emptyList.get(indexError-9) == "added")? "PASSED" : "FAILED"));
        System.out.println("Invalid index test (Index 200):\t\t" + (!(emptyList.get(indexError+198) == "added")? "PASSED" : "FAILED"));



        /*====================================================*/

        System.out.println("\n\nset() Test:");
        System.out.println("------------------------------------");
        
        index = 2;
        System.out.println("index to set: " + index);
        System.out.println("set value: " + 2.5);
        System.out.println("List before setting: \t\t" + af2);
        af2.set(index, "2.5");
        System.out.println("List after setting: \t\t" + af2);
        System.out.println(" ");
        System.out.println("Test for out of bounds index (index -1): \t" + af2.set(-1, 45));
        System.out.println("Test for out of bounds index (index 50): \t" + af2.set(50, 45));

        Integer setInt = 45;
        System.out.println("Results\n");
        System.out.println("Test 1: \t\t" + ((af2.get(2) == "2.5") ? "PASSED" : "FAILED"));

        System.out.println("Index -1 test:\t\t" + (!(af2.get(-1) == setInt) ? "PASSED" : "FAILED"));
        System.out.println("Index 50 test:\t\t" + (!(af2.get(50) == setInt) ? "PASSED" : "FAILED"));

        /*
        MyLinkedList<String> testList = new MyLinkedList<String>();
        System.out.println("Test for out of bounds index (index -1): \t" + testList.set(-3, 45));
        System.out.println("Test for out of bounds index (index 50): \t" + testList.set(50, 45));
        */

        /*====================================================*/

        System.out.println("\n\nlastIndex() Test:");
        System.out.println("------------------------------------");
        System.out.println("Testing for value of 2");
        System.out.println("List: \t\t" + af2);
        int last1 = af2.lastIndex("2");
        System.out.println("Last index: " + last1); 
        af2.add("2");
        System.out.println("List: \t\t" + af2);
        int last2 = af2.lastIndex("2");
        System.out.println("Last index: " + last2); 

        System.out.println("Results");
        System.out.println("Test 1 " + ((last1 == 1) ? "PASSED" : "FAILED"));
        System.out.println("Test 2 " + ((last2 == 5) ? "PASSED" : "FAILED"));

        /*====================================================*/

        System.out.println("\n\nclone() Test:");
        System.out.println("------------------------------------");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("List: \t\t" + list);
        MyLinkedList<Integer> listClone = new MyLinkedList<>();
        listClone = list.clone();
        System.out.println("Cloned List: \t" + listClone);

        /*====================================================*/

        System.out.println("\n\nremoveAll() Test:");
        System.out.println("------------------------------------");
        
        MyLinkedList<Integer> rmList = new MyLinkedList<>();

        rmList.add(1);
        rmList.add(2);
        rmList.add(2);
        rmList.add(2);
        rmList.add(3);
        rmList.add(4);

        Integer toRm = 2;
        System.out.println("Before removeAll(): \t\t" + rmList);
        System.out.println("Removing " + toRm);
        rmList.removeAll(toRm);
        System.out.println("After removeAll(): \t\t" + rmList);

        /*====================================================*/

        System.out.println("\n\nequals() Test:");
        System.out.println("------------------------------------");

        MyLinkedList<String> equals1 = new MyLinkedList<String>();
        MyLinkedList<String> equals2 = new MyLinkedList<String>();
        MyLinkedList<String> equals3 = new MyLinkedList<String>();

        equals1.add("Alpha");
        equals1.add("Bravo");
        equals1.add("Charlie");
        equals1.add("Delta");

        equals2.add("Alpha");
        equals2.add("Bravo");
        equals2.add("Charlie");
        equals2.add("Delta");

        equals3.add("Alpha");
        equals3.add("Bravo");
        equals3.add("Charlie");
        equals3.add("Echo");

        System.out.println("List 1\t\t" + equals1);
        System.out.println("List 2\t\t" + equals2);
        System.out.println("List 3\t\t" + equals3);

        System.out.println("\nlist1.equals(list2) = " + ((equals1.equals(equals2)) ? "PASSED" : "FAILED"));
        System.out.println("\nlist1.equals(list3) != " + (!(equals1.equals(equals3)) ? "PASSED" : "FAILED"));

        /*====================================================*/

        System.out.println("\n\nsplit() Test:");
        System.out.println("------------------------------------");

        MyLinkedList<String> split1 = new MyLinkedList<String>();
        MyLinkedList<String> split2 = new MyLinkedList<String>();
        MyLinkedList<String> split3 = new MyLinkedList<String>();
        MyLinkedList<String> split4 = new MyLinkedList<String>();

        split1.add("node1");
        split1.add("node2");
        split1.add("node3");
        split1.add("node4");
        
        System.out.println("List1 before splitting: \t" + split1);
        split2 = split1.split();

        System.out.println("List1 after splitting: \t\t" + split1);
        System.out.println("List2 after splitting: \t\t" + split2);

        split3.add("node1");
        split3.add("node2");
        split3.add("node3");
        split3.add("node4");
        split3.add("node5");

        System.out.println("List3 before splitting: \t" + split3);
        split4 = split3.split();

        System.out.println("List3 after splitting: \t\t" + split3);
        System.out.println("List4 after splitting: \t\t" + split4);

        System.out.println("Results\n");

        /*====================================================*/

        System.out.println("\n\ndoubler() Test:");
        System.out.println("------------------------------------");

        MyLinkedList<Integer> doubler1 = new MyLinkedList<>();
        MyLinkedList<Integer> doubler2 = new MyLinkedList<>();

        for (int i = 0; i < 4; i++) {
            doubler1.add(i);
        }

        System.out.println("Before doubling:\t" + doubler1);
        doubler1.doubler();
        System.out.println("After doubling:\t\t" + doubler1);

        try {
            emptyList.doubler();
        }catch (Exception e) {
            System.out.println("Null list test: \t" + " PASSED");
        }


        /*====================================================*/

        System.out.println("\n\nsublist() Test:");
        System.out.println("------------------------------------");

        MyLinkedList<Integer> subList = new MyLinkedList<>();
        MyLinkedList<Integer> subList2 = new MyLinkedList<>();

        subList.add(1);
        subList.add(2);
        subList.add(3);
        subList.add(4);
        subList.add(5);
        subList.add(6);

        System.out.println("Original list: \t" + subList);
        System.out.println("Sub List (Indexes 3 - 5): \t" + subList.sublist(3, 5));

        boolean sublistFail = false;
        try{
            if(subList.sublist(30, 40) == null) {
                sublistFail = true;
            }
            else{
                sublistFail = false;
            }

        }catch(Exception e){
            System.out.println("Null list test: \t" + "PASSED");
        }

        System.out.println("Index out of bounds test: \t" + (sublistFail ? "PASSED" : "FAILED"));
    }
}
