package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>(null);
		head.next = tail;
		this.tail = new LLNode<E>(null);
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) {
		if (element == null)
		    throw new NullPointerException();

		LLNode<E> n = new LLNode<>(element);

		if (size == 0) {
			n.next = tail;
			n.prev = head;
			head.next = n;
			tail.prev = n;
		}
		else {
			n.next = tail;
			n.prev = tail.prev;
			n.prev.next = n;
			tail.prev = n;
		}
		size++;
		return true;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */

	public E get(int index)
	{
		// TODO: Implement this method.
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();

		LLNode<E> result = head.next;

		for (int i = 0; i < index; i++)
			result = result.next;

		return result.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if (element == null)
		    throw new NullPointerException();


		if (index < 0 || index >= size && size != 0)
            throw new IndexOutOfBoundsException();


		LLNode<E> newNode = new LLNode<E>(element);

		LLNode<E> oldNode = head.next;


		if (index < size) {
			for (int i = 0; i < index; i++)
			{
				oldNode = oldNode.next;
			}
			LLNode<E> oldPrev = oldNode.prev;
			newNode.prev = oldPrev;
			newNode.next = oldNode;

			oldPrev.next = newNode;
			oldNode.prev = newNode;
		} else {
			if (size == 0)
				newNode.next = tail;
				newNode.prev = head;
				head.next = newNode;
				tail.prev = newNode;
		}
		size++;
	}


	/** Return the size of the list */
	public int size()
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	public E remove(int index)
	{
		// TODO: Implement this method
		if (index < 0 || index > size - 1)
	        throw new IndexOutOfBoundsException();

		LLNode<E> removeNode = head.next;
		E tmpValue = null;

		if (index == 0) {
			tmpValue  = removeNode.data;
	        head.next = removeNode.next;
	        removeNode.next.prev = head;
	        removeNode.next = null;
	        removeNode.prev = null;
	        removeNode.data = null;

	    } else {
	    	for (int i = 0; i < index; i++)
	    		removeNode = removeNode.next;

	    	tmpValue = removeNode.data;
	    	removeNode.next.prev = removeNode.prev;
	    	removeNode.prev.next = removeNode.next;
	    	removeNode.next = null;
	        removeNode.prev = null;
	        removeNode.data = null;
	    }
		size--;
	    return tmpValue;
	}


	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();

		if (element == null)
		    throw new NullPointerException();

		E newData = element;
		E oldData = null;
		LLNode<E> nodeToSet = head.next;

		for (int i = 0; i < index; i++)
			nodeToSet = nodeToSet.next;

		oldData = nodeToSet.data;
		nodeToSet.data = newData;

		return newData;
	}

}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e)
	{
		this.data = e;
	}

	public LLNode(LLNode<E> prev, LLNode<E> next) {
		this.prev = prev;
		this.next = next;
	}

}
