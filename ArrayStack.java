// Code modified from Project 2

public class ArrayStack {
	private Node[] array;
	private int _length;
	private int _array_length;
	ArrayStack(int initialCapacity) {
		array = new Node[initialCapacity];
		_length = 0;
		_array_length = initialCapacity;
	}
	public int length() {
		return _length;
	}
	public int arrayLength() {
		return _array_length;
	}
	public String toString() {
		// String str = "[";
		String str = "";
		int cur = 0;
		while (cur < _length) {
			str += array[cur].toString();
			if (cur < _length-1) {
				str += ", ";
			}
			cur++;
		}
		// str += " <-";
		return str;
	}
	private void doubleCapacity() {
		_array_length *= 2;
		Node[] newArray = new Node[_array_length];
		for (int i = 0; i < _length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	public void push(Node node) {
		if (_length >= _array_length) {
			doubleCapacity();
		}
		// Node node = new Node(line, pos);
		array[_length++] = node;
	}
	public Node peek() {
		return array[_length-1];
	}
	public Node pop() {
		return array[--_length];
	}
	public static void main(String[] args) {
		ArrayStack test = new ArrayStack(4);
		test.push(new Node(1,1));
		test.push(new Node(2,1));
		test.push(new Node(3,1));
		test.push(new Node(4,1));
		test.push(new Node(5,1));
		test.push(new Node(6,1));
		test.push(new Node(7,1));
		test.push(new Node(8,1));
		test.push(new Node(9,1));
		System.out.println(test);
		// System.out.println(test.pop());
		// System.out.println(test.pop());
		// System.out.println(test.length());
	}
}