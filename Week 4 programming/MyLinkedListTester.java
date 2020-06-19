/**
 *
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> notList;
	MyLinkedList<Integer> lst;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

		lst = new MyLinkedList<Integer>();
	}

	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first",  "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(shortList.size);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}


	/* Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		int b = list1.remove(0);
		assertEquals("Remove: check a is correct ", 21, b);
		assertEquals("Remove: check element 0 is correct ", (Integer)42, list1.get(0));
		assertEquals("Remove: check size is correct ", 1, list1.size());

		// TODO: Add more tests here
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.remove(longerList.size);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

	}

	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		shortList.add("C");
		longerList.add(10);
		assertEquals("Check last", "C", shortList.get(2));
		assertEquals("Check last", (Integer) 10, longerList.get(LONG_LIST_LENGTH));
	}

	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size is correct ", 3, list1.size());
		assertEquals("Size: check size is correct ", 0, emptyList.size());
		assertEquals("Size: check size is correct ", 10, longerList.size());

		lst.add(0, 1);
		lst.remove(0);
		lst.add(0, 1);
		assertEquals("Size: check size is correct ", 1, lst.size());

		for (int i = 0; i < 1000; i++)
			emptyList.add(1);
		assertEquals("Size: check size is correct ", 1000, emptyList.size());

		try {
			notList.size();
			fail("Check null pointer list");
		}
		catch (NullPointerException e) {

		}
	}

	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		shortList.add(1, "D");
		longerList.add(5, 77);
		assertEquals("Check last", "D", shortList.get(1));
		assertEquals("Check last", (Integer) 77, longerList.get(5));
		try {
			longerList.add(-1, 11);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.add(longerList.size + 1, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.add(1, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {

		}
	}

	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			longerList.set(-1, 1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.set(longerList.size, 0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.set(0, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e){

		}
		try {
			longerList.set(4, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e){

		}
		shortList.set(0, "Z");
		longerList.set(9, 999);
		assertEquals("Check set", "Z", shortList.get(0));
		assertEquals("Check set", (Integer) 999, longerList.get(9));

	}


	// TODO: Optionally add more test methods.

}
