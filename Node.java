// Code modified from Project 2

public class Node {
	int line;
	int pos;
	String context;
	Node next;
	Node(int _line, int _pos) {
		line = _line;
		pos = _pos;
		next = null;
	}
	Node(int _line, int _pos, String _context) {
		line = _line;
		pos = _pos;
		context = _context;
		next = null;
	}
	public String toString() {
		String result = String.valueOf(line);
		result += ":";
		result += String.valueOf(pos);
		return result;
	}
	public static void main(String[] args) {
		Node test = new Node(3, 16);
		System.out.println(test);
	}
	public int getLine() {
		return line;
	}
}