import java.util.LinkedList;

public class LinkedTest{
    public static void main(String[] args) {
        /**
        * This tests uses four lists differeing
        * in size and returns the first element.
        */

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
        System.out.println(" ");

        System.out.println("2-element list: \t" + gf2);
        System.out.println("First element: \t\t" + gf2.getFirst());
        System.out.println(" ");

        System.out.println("3-element list: \t" + gf3);
        System.out.println("First element: \t\t" + gf3.getFirst());
        System.out.println(" ");

        MyLinkedList<String> emptyList = new MyLinkedList<String>();

        System.out.println("\nTesting empty list: ");

        boolean firstFail = false;
        if(emptyList.getFirst() == null) {
            firstFail = true;
        }

        System.out.println(" ");
        System.out.println("Results: ");
        System.out.println("Test 1:\t\t\t" + (gf1.getFirst() == "node1" ? "PASSED" : "FAILED"));
        System.out.println("Test 2:\t\t\t" + (gf1.getFirst() == "node1" ? "PASSED" : "FAILED"));
        System.out.println("Test 3:\t\t\t" + (gf1.getFirst() == "node1" ? "PASSED" : "FAILED"));

        System.out.println("Null list test:\t\t" + (firstFail ? "PASSED" : "FAILED"));
        System.out.println("====================================");

        /*=====================================================*/

        /**
         * This tests uses four lists differeing
         * in size and returns the last element.
         */

        System.out.println("\ngetLast() Test:");
        System.out.println("------------------------------------");

        System.out.println("1-element list: \t" + gf1);
        System.out.println("Last element: \t\t" + gf1.getLast());
        System.out.println(" ");

        System.out.println("2-element list: \t" + gf2);
        System.out.println("Last element: \t\t" + gf2.getLast());
        System.out.println(" ");

        System.out.println("3-element list: \t" + gf3);
        System.out.println("Last element: \t\t" + gf3.getLast());
        System.out.println(" ");

        System.out.println("\nTesting empty list: ");

        boolean lastFail = false;
        if(emptyList.getLast() == null) {
            lastFail = true;
        }

        System.out.println(" ");
        System.out.println("Results: ");

        System.out.println("Test 1:\t\t\t" + (gf1.getLast() == "node1" ? "PASSED" : "FAILED"));
        System.out.println("Test 2:\t\t\t" + (gf2.getLast() == "node2" ? "PASSED" : "FAILED"));
        System.out.println("Test 3:\t\t\t" + (gf3.getLast() == "node3" ? "PASSED" : "FAILED"));

        System.out.println("Test for null list:\t" + (lastFail ? "PASSED" : "FAILED"));
        System.out.println("====================================");

        /*====================================================*/

        /**
         * This tests uses
         *
         */

        System.out.println("\n\nadd() Test:");
        System.out.println("------------------------------------");
        System.out.println("Element to add: \tadded");
        System.out.println(" ");
        MyLinkedList<String> addEmptyList = new MyLinkedList<String>();

        System.out.println("0-element list: \t" + addEmptyList);
        addEmptyList.add("added");
        System.out.println("After adding: \t\t" + addEmptyList);
        System.out.println(" ");

        System.out.println("1-element list: \t" + gf1);
        gf1.add("added");
        System.out.println("After adding: \t\t" + gf1);
        System.out.println(" ");

        System.out.println("2-element list: \t" + gf2);
        gf2.add("added");
        System.out.println("After adding: \t\t" + gf2);
        System.out.println(" ");

        System.out.println("3-element list: \t" + gf3);
        gf3.add("added");
        System.out.println("After adding: \t\t" + gf3);
        System.out.println(" ");

        System.out.println("\nResults:");
        System.out.println("1-element test:\t\t" + ((gf1.getLast() == "added") ? "PASSED" : "FAILED"));
        System.out.println("2-element test:\t\t" + ((gf2.getLast() == "added") ? "PASSED" : "FAILED"));
        System.out.println("3-element test:\t\t" + ((gf3.getLast() == "added") ? "PASSED" : "FAILED"));

        System.out.println("====================================");
        /*====================================================*/
        MyLinkedList<String> af = new MyLinkedList<String>();
        MyLinkedList<String> af1 = new MyLinkedList<String>();
        MyLinkedList<String> af2 = new MyLinkedList<String>();
        MyLinkedList<String> af3 = new MyLinkedList<String>();

        af.add("1");
        af.add("2");

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


        System.out.println(" ");
        System.out.println("Base List: ");
        int index = 0;
        af.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af);


        System.out.println("Index to add after:\t" + index);
        System.out.println(" ");
        System.out.println("List 1: \t\t" + af1);
        af1.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af1);

        index++;
        System.out.println("Index to add after:\t" + index);
        System.out.println(" ");
        System.out.println("List 2: \t\t" + af2);
        af2.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af2);

        index++;
        System.out.println("Index to add after:\t" + index);
        System.out.println(" ");
        System.out.println("List 3: \t\t" + af3);
        af3.addAfter(index, "added");
        System.out.println("After adding: \t\t" + af3);
        index++;
        System.out.println("Index to add after:\t" + index);
        System.out.println(" ");
        System.out.println("Testing invalid Indexes: ");

        int indexError = 2;
        try {
            emptyList.addAfter(-7, 200);
            emptyList.addAfter(200, 200);

        }catch(Exception e) {
            System.out.println();
        }

        int indexT = 1;
        System.out.println("\nResults:");
        System.out.println("List 1 Test\t\t\t" + ((af1.get(indexT) == "added")? "PASSED" : "FAILED"));
        System.out.println("List 2 Test\t\t\t" + ((af2.get(indexT+1) == "added")? "PASSED" : "FAILED"));
        System.out.println("List 3 Test\t\t\t" + ((af3.get(indexT+2) == "added")? "PASSED" : "FAILED"));

        System.out.println("Invalid (Index -7) test:\t\t" + (!(emptyList.get(indexError-9) == "added")? "PASSED" : "FAILED"));
        System.out.println("Invalid (Index 200)test:\t\t" + (!(emptyList.get(indexError+198) == "added")? "PASSED" : "FAILED"));

        System.out.println("====================================");
        /*====================================================*/

        System.out.println("\n\nset() Test:");
        System.out.println("------------------------------------");

        index = 2;
        System.out.println("index to set: " + index);
        System.out.println("set value: " + 2.5);
        System.out.println(" ");
        System.out.println("List before setting: \t\t" + af2);
        af2.set(index, "2.5");
        System.out.println("List after setting: \t\t" + af2);
        System.out.println(" ");

        MyLinkedList<String> testList = new MyLinkedList<String>();
        System.out.println("Testing out of bounds indexes: ");
        testList.set(-50, 45);
        testList.set(50, 45);

        System.out.println("\nResult:");
        System.out.println("Test 1: \t\t" + ((af2.get(2) == "2.5") ? "PASSED" : "FAILED"));

        System.out.println("Test index 50: \t\t" + ((testList.get(50) == null) ? "PASSED" : "FAILED"));
        System.out.println("Test index -50: \t" + ((testList.get(50) == null) ? "PASSED" : "FAILED"));

        System.out.println("====================================");
        /*====================================================*/

        System.out.println("\n\nlastIndex() Test:");
        System.out.println("------------------------------------");
        System.out.println("Testing for value of 2");
        System.out.println(" ");
        System.out.println("List: \t\t" + af2);
        int last1 = af2.lastIndex("2");
        System.out.println("Last index: " + last1);
        af2.add("2");
        System.out.println(" ");
        System.out.println("List: \t\t" + af2);
        int last2 = af2.lastIndex("2");
        System.out.println("Last index: " + last2);

        System.out.println("\nResults:");
        System.out.println("Test 1 " + ((last1 == 1) ? "PASSED" : "FAILED"));
        System.out.println("Test 2 " + ((last2 == 5) ? "PASSED" : "FAILED"));

        System.out.println("====================================");
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

        System.out.println("====================================");
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

        System.out.println("\nTest for element not in list (10)");
        rmList.removeAll(10);
        System.out.println("After: " + rmList);

        System.out.println("====================================");
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
        equals3.add("ECHO");

        System.out.println("List 1\t\t" + equals1);
        System.out.println("List 2\t\t" + equals2);
        System.out.println("List 3\t\t" + equals3);

        System.out.println("\nResults: ");
        System.out.println("Testing list 1 and 2 = " + ((equals1.equals(equals2)) ? "PASSED" : "FAILED"));
        System.out.println("Testing list 1 and 3 = " + (!(equals1.equals(equals3)) ? "PASSED" : "FAILED"));

        System.out.println("====================================");
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
        System.out.println("Return List (second half): \t" + split2);

        split3.add("node1");
        split3.add("node2");
        split3.add("node3");
        split3.add("node4");
        split3.add("node5");

        System.out.println("\nList3 before splitting: \t" + split3);
        split4 = split3.split();

        System.out.println("List3 after splitting: \t\t" + split3);
        System.out.println("Return List (second half): \t" + split4);

        System.out.println("====================================");
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


        System.out.println("\nTesting empty list:");
        try {
            emptyList.doubler();
        }catch (Exception e) {
            System.out.println("\nResults: ");
            System.out.println("Null list test: \t" + " PASSED");
        }

        System.out.println("====================================");
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
        System.out.println("\nSub List (Indexes 3 - 5): \t" + subList.sublist(3, 5));

        boolean sublistFail = false;

        System.out.println("Sub List (Indexes 2 - 4): \t" + subList.sublist(2, 4));
        System.out.println("\nTest invalid indexes (30 and 40): ");
        try{
            if(subList.sublist(30, 40) == null) {
                sublistFail = true;
            }
            else{
                sublistFail = false;
            }

        }catch(Exception e){
        }

        System.out.println("\nResults: ");
        System.out.println("Index out of bounds test: \t" + (sublistFail ? "PASSED" : "FAILED"));
        System.out.println("====================================");
        /*
        MyLinkedList<String> list0 = new MyLinkedList<String>();
        MyLinkedList<String> list1 = new MyLinkedList<String>();
        MyLinkedList<String> list2 = new MyLinkedList<String>();

        list1.addFirst("node1");
        System.out.println("1-element list: " + list1);
        list2.addFirst("node2"); list2.addFirst("node1");
        System.out.println("2-element list: " + list2);

        System.out.println("\nTesting getFirst...");
        System.out.println(list0.getFirst());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getFirst().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getFirst().equals("node1")?"PASSED":"**FAILED**");

        System.out.println("\nTesting getLast...");
        System.out.println(list0.getLast());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getLast().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getLast().equals("node2")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);

        System.out.println("\nTesting add...");
        MyLinkedList<String> list3 = new MyLinkedList<String>();
        MyLinkedList<String> list4 = new MyLinkedList<String>();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        System.out.println("3-element list: " + list3);
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        System.out.println("4-element list: " + list4);

        System.out.println("\nTesting addAfter...");
        MyLinkedList<String> listAddAfter1 = new MyLinkedList<String>();
        listAddAfter1.add("node1");
        listAddAfter1.add("node2");
        listAddAfter1.add("node3");
        listAddAfter1.add("node4");
        listAddAfter1.addAfter(2, "after 2");
        System.out.println("Add-after-2: " + listAddAfter1);


        System.out.println("\nTesting set...");
        MyLinkedList<String> test = new MyLinkedList<String>();
        System.out.println("  empty list test = " + ((test.set(2,"bad") == null)?"PASSED":"**FAILED**"));
        test.addFirst("Mark");
        test.addFirst("Sohaib");
        test.addFirst("Salman");
        System.out.println("  return value test = " + ((test.set(1,"Nora")).equals("Sohaib")?"PASSED":"**FAILED**"));
        System.out.println("  non-empty test = " + ((test.get(0).equals("Salman") && test.get(1).equals("Nora") &&
                           test.get(2).equals("Mark"))?"PASSED":"**FAILED**"));

        System.out.println("\nTesting addAfter...");
        MyLinkedList<String> other = new MyLinkedList<String>();
        other.add("one");
        other.add("two");
        other.add("three");
        other.add("four");
        System.out.println(other.size() + " " + other);
        other.addAfter(2,"three.5");
        System.out.println((other.get(3).equals("three.5")?"PASSED":"**FAILED**"));
        System.out.println(other.size() + " " + other);

        System.out.println("\nTesting lastIndex...");
        System.out.println((test.lastIndex("Salman")==0)?"PASSED":"**FAILED**");
        test.addFirst("Mark");
        System.out.println((test.lastIndex("Mark")==3)?"PASSED":"**FAILED**");

        System.out.println("\nTesting clone...");
        MyLinkedList<String> empty = new MyLinkedList<String>();
        list1 = empty.clone();
        System.out.println("  empty list test = " + (list1.isEmpty()?"PASSED":"**FAILED**"));
        MyLinkedList<String> another = other.clone();
        System.out.println(another.size() + " " + another);
        System.out.println("  making sure nodes not shared...");
        other.remove("two");
        System.out.println(other.size() + " " + other);
        System.out.println(another.size() + " " + another);

        System.out.println("\nTesting removeAll...");
        other.add("three");
        System.out.println(other);
        other.removeAll("three");
        System.out.println(other);
        //time for you to write some tests!

        System.out.println("\nTesting equals...");
        System.out.println("  reflexive test = " + (list2.equals(list2)?"PASSED":"**FAILED**"));
        MyLinkedList<String> emptyList = new MyLinkedList<String>();
        list0.clear();
        list1.clear();
        list1.add("node1");
        System.out.println("  empty list test/true = " + (emptyList.equals(list0)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test1/false = " + (!emptyList.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test2/false = " + (!list1.equals(emptyList)?"PASSED":"**FAILED**"));
        list0.add("node1");
        System.out.println("  singleton test = " + (list0.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 1/false = " + (!list1.equals(list2)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 2/false = " + (!list2.equals(list1)?"PASSED":"**FAILED**"));
        list0.add("node2"); list0.add("node3"); list0.add("node4");
        list0.add("node5"); list0.add("node6"); list0.add("node7");
        list4.add("node5"); list4.add("node6"); list4.add("node7");
        System.out.println("  7-element test/true = " + (list0.equals(list4)?"PASSED":"**FAILED**"));
        list0.remove("node4");
        list0.add("node5");
        System.out.println("  7-element test/false = " + (!list0.equals(list4)?"PASSED":"**FAILED**"));
        System.out.println("  7-element test/false = " + (!list4.equals(list0)?"PASSED":"**FAILED**"));


        System.out.println("\nTesting split...");
        MyLinkedList<String> toSplit = new MyLinkedList<String>();
        MyLinkedList<String> back = new MyLinkedList<String>();

        toSplit.add("node1");
        toSplit.add("node2");
        toSplit.add("node3");
        toSplit.add("node4");
        toSplit.add("node5");


        System.out.println("Before splitting:\n" + toSplit);
        back = toSplit.split();
        System.out.println("Front\n" + toSplit);
        String backString = back.toString();
        System.out.println("Back:\n" + backString);


        System.out.println("\nTesting doubler:\n");
        MyLinkedList<String> toDouble = new MyLinkedList<String>();
        toDouble.add("node1");
        toDouble.add("node2");
        toDouble.add("node3");
        toDouble.add("node4");
        System.out.println("Before doubling " + toDouble);
        toDouble.doubler();
        System.out.println("After doubling " + toDouble);


        System.out.println("\nTesting sublist:\n");
        MyLinkedList<String> sub = new MyLinkedList<String>();
        sub.add("node1");
        sub.add("node2");
        sub.add("node3");
        sub.add("node4");
        MyLinkedList<String> subList = new MyLinkedList<String>();
        subList = toDouble.sublist(2, 4);
        System.out.println("After sublist " + subList.toString());

        System.out.println("\nTesting sublist\n");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list.subList(2, 5));

        MyLinkedList<String> result = new MyLinkedList<>();
        list0.clear();
        list1.clear();
        list1.add("node1");
        list2.clear();
        list2.add("node1");
        list2.add("node2");
        list3.clear();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        list4.clear();
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        MyLinkedList<String> list5 = new MyLinkedList<String>();
        list5.add("node1"); list5.add("node2"); list5.add("node3"); list5.add("node4");
        list5.add("node5");
        MyLinkedList<String> list6 = new MyLinkedList<String>();
        list6.add("node1"); list6.add("node2"); list6.add("node3"); list6.add("node4");
        list6.add("node5"); list6.add("node6");
        System.out.print("SPLIT ");
        System.out.println(list0.size() + " " + list0);
        result = list0.split();
        System.out.println("  list " + list0.size() + " " + list0);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list1.size() + " " + list1);
        result = list1.split();
        System.out.println("  list " + list1.size() + " " + list1);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list2.size() + " " + list2);
        result = list2.split();
        System.out.println("  list " + list2.size() + " " + list2);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list3.size() + " " + list3);
        result = list3.split();
        System.out.println("  list " + list3.size() + " " + list3);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list4.size() + " " + list4);
        result = list4.split();
        System.out.println("  list " + list4.size() + " " + list4);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list5.size() + " " + list5);
        result = list5.split();
        System.out.println("  list " + list5.size() + " " + list5);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list6.size() + " " + list6);
        result = list6.split();
        System.out.println("  list " + list6.size() + " " + list6);
        System.out.println("  result " + result.size() + " " + result);
        */

    }
}
