package oracle.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Provides sufficient test coverage for oracle.test.IteratorFlattener class.
 */
public class IteratorFlattenerTest {

public static void main(String args[]){
	ArrayList<Iterator<Integer>> aList=new ArrayList<Iterator<Integer>>();
	ArrayList<Integer> list1=new ArrayList<Integer>();
	list1.add(1);
	list1.add(2);
	aList.add(list1.iterator());
	ArrayList<Integer> list2=new ArrayList<Integer>();
	list2.add(5);
	
	aList.add(list2.iterator());
	ArrayList<Integer> list3=new ArrayList<Integer>();
	list3.add(6);
	list3.add(7);
	
	aList.add(list3.iterator());
	IteratorFlattener<Integer> itr=new IteratorFlattener<Integer>( aList.iterator());
	System.out.println(itr.hasNext());
	System.out.println(itr.next());
	System.out.println(itr.hasNext());
	System.out.println(itr.next());
	System.out.println(itr.hasNext());
	System.out.println(itr.next());
	itr.remove();
	System.out.println(itr.hasNext());
	System.out.println(itr.next());
}
}
