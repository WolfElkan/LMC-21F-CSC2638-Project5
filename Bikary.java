// From "bi" meaning 2, 
// and "baker" meaning "baker's dozen" or 13
// 2 * 13 = 26
// Could also be called a "Literal Search Tree"
// or "Hexavigesimal Search Tree"
class Bikary {
	// String sofar;
	Bikary[] children = new Bikary[26];
	ArrayStack entries = new ArrayStack(16);
	Bikary() {}
	boolean isLetter(char c) {
		if (('A' <= c) && (c <= 'Z')) {
			return true;
		} else if (('a' <= c) && (c <= 'z')) {
			return true;
		} else {
			return false;
		}
	}
	void addWord(String suffix, Node occurance) {
		while (suffix.length() > 0 && !isLetter(suffix.charAt(0))) {
			suffix = suffix.substring(1);
		}
		if (suffix.length() > 0) {
			char c = suffix.charAt(0);
			int index = (int) c;
			index -= 65;
			index %= 32;
			if (children[index] == null) {
				children[index] = new Bikary();
			}
			children[index].addWord(suffix.substring(1), occurance);
		} else {
			entries.push(occurance);
		}
	}
	void showTree(int level, char c) {
		for (int j = 0; j < level; j++) {
			System.out.print("  ");
		}
		System.out.print(c);
		System.out.print(' ');
		System.out.println(entries);
		for (int i = 0; i < 26; i++) {
			if (children[i] != null) {
				children[i].showTree(level+1, (char) (i+65));
			}
		}
	}
	void showTree() {
		showTree(0, '*');
	}
	void showDict(String prefix) {
		if (entries.length() > 0) {
			System.out.print(prefix);
			System.out.print(' ');
			System.out.println(entries);
		}
		for (int i = 0; i < 26; i++) {
			if (children[i] != null) {
				char c = (char) (i+65);
				children[i].showDict(prefix + c);
			}
		}		
	}
	void showDict() {
		showDict("");
	}
	public static void main(String[] args) {
		Bikary test = new Bikary();
		Node node = new Node(0,0);
		test.addWord("word", node);
		test.addWord("abc", node);
		test.showDict();
		// 845 - 21960
		// String a = "arrow";
		// char c = 'x';
		// System.out.println(a+c);
	}
}