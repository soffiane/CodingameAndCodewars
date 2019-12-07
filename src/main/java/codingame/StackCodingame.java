package codingame;

import java.math.BigDecimal;
import java.util.EmptyStackException;

public class StackCodingame {

    // keep these two fields as they​​​​​​​‌‌‌​​‌​‌​‌​​​​​‌​‌​‌​‌​‌ are
    private Object[] elements;
	private int size = 0;

	public StackCodingame(int initialCapacity) {
		elements = new Object[initialCapacity];
	}

	public void push(Object object) {
		ensureCapacity();
		elements[size++] = object;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		return elements[--size];
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			Object[] old = elements;
			elements = new Object[2 * size + 1];
			System.arraycopy(old, 0, elements, 0, size);
		}
	}
	
	public static void main(String [] args){
		StackCodingame stack = new StackCodingame(10000);

		//showMemoryUse(); // before using the stack

//		for (int i = 0; i < 10000; i++) { // fill the stack
//		    s.push("a large, large, large, large, string " + i);
//		}
//		for (int i = 0; i < 10000; i++) { // empty the stack
//		    System.out.println(stack.pop());
//		}

		//showMemoryUse(); // after using the stack
		String pouet = String.valueOf(521);
		CharSequence c = String.valueOf(521);
		do {
			System.out.println();
		}while(!pouet.contains(c));
		
		System.out.println(pouet.contains(c));
	}
	
}
