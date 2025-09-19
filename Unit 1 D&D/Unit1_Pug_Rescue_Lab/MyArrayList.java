/* See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E [] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[])new Object[8];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity){
		this.internalArray = (E[])new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	//O(1)
	public int size() {
		return objectCount;
	}

	/* Are there zero objects in the array list? */
	//O(1)
	public boolean isEmpty() {
		if (objectCount == 0){
			return true;
		}
		return false;
	}

	/* Get the index-th object in the list. */
	//O(1)
	public E get(int index) {
		if (index < 0 || index >= objectCount) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}

		return internalArray[index];
	}

	/* Replace the object at index with obj.  returns object that was replaced. */
	//O(1)
	public E set(int index, E obj) {
		if (index < 0 || index >= objectCount) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}

		E temp = internalArray[index];
		internalArray[index] = obj;
		return temp;
	}

	/* Returns true if this list contains an element equal to obj;
	 otherwise returns false. */
	 //O(n)
	public boolean contains(E obj) {
		for (int i = 0; i < objectCount; i++) {
			if (internalArray[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		if (index < 0 || index > objectCount) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}

		if (internalArray[index] == null) {
			internalArray[index] = obj;
		}

		if (objectCount == internalArray.length) {
			Object[] newArray = (E[]) new Object[internalArray.length * 2];
			for (int i = 0; i < objectCount; i++) {
				newArray[i] = internalArray[i];
			}
			internalArray = (E[])newArray;
		}

		for (int i = objectCount; i > index; i--) {
			internalArray[i] = internalArray[i-1];
		}

		// newArray[index] = obj;
		// for (int i = index; i < objectCount; i++) {
		// 	newArray[i+1] = internalArray[i];
		// }
		// internalArray = (E[])newArray;

		internalArray[index] = obj;
		objectCount++;
	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		// if (internalArray.length != objectCount) {
		// 	internalArray[objectCount] = obj;
		// 	objectCount++;
		
		if (internalArray.length == objectCount) {
			E[] newArray = (E[]) new Object[internalArray.length * 2];
			for (int i = 0; i < objectCount; i++) {
				newArray[i] = internalArray[i];
			}
			internalArray = newArray;
		}

		internalArray[objectCount] = obj;
		objectCount++;
		return true;
	}

	/* Remove the object at index and shift.  Returns removed object. */
	//@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index < 0 || index >= internalArray.length) {
			throw new IndexOutOfBoundsException("Index out of bounds. ");
		}
		
		E removed = internalArray[index];

		//Object[] newArray = (E[]) new Object[internalArray.length * 2];
		// for (int i = 0; i < index; i++) {
		// 	newArray[i] = internalArray[i];
		// }

		for (int i = index; i < objectCount - 1; i++) {
			internalArray[i] = internalArray[i + 1];
		}

		internalArray[objectCount - 1] = null;
		objectCount--;
		return removed;
	}

	/* Removes the first occurrence of the specified element from this list, 
	 * if it is present. If the list does not contain the element, it is unchanged. 
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
	 * Returns true if this list contained the specified element (or equivalently, 
	 * if this list changed as a result of the call). */
	//O(n)
	//@SuppressWarnings("unchecked")
	public boolean remove(E obj) {
		if (obj == null) {
			return false;
		}
		if (this.contains(obj)) {
			for (int i = 0; i < objectCount; i++) {
				if (internalArray[i].equals(obj)) {
					remove(i);
					return true;
				}
			}
		} else {
			throw new IllegalArgumentException("Object isn't in list. ");
		}

		objectCount--;
		return false;
	}


	/* For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the elements in the ArrayList.
	 * If the array is empty, it should return "[]".  If there is one element, "[X]", etc.
	 * Elements are separated by a comma and a space. */
	//O(n) but could be O(n^2) if 2D array
	public String toString() {
		if (internalArray.length == 0) {
			return "[]";
		}

		StringBuilder str = new StringBuilder("[");
		for (int i = 0; i < objectCount; i++) {
			if (internalArray[i] != null) {
				str.append(internalArray[i]);
				if (i < objectCount - 1) {
					str.append(", ");
				}
			} else {
				continue;
			}
		}

		str.append("]");
		return str.toString();
	}
}