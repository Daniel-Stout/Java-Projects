import java.util.ArrayList;

public class Pyramid {
	private int size = 0;
	private char character;
	public ArrayList<String> pyramid = new ArrayList<>();;
	
	public Pyramid(int num, char c) {
		if (num % 2 != 0)
			num++;
		
		this.character = c;
		this.size = num / 2;
		
		
		String s = String.valueOf(character);
		String line = "";
		while (size > 0) {
			line = "";
			for (int k = 0; k < size; k++) {
				line += s;
			}
			pyramid.add(line);
			size--;
		}
	}
	
	public Pyramid() {
		this(0, '#');
	}
	
	public Pyramid(int num) {
		this(num, '#');
	}
	
	public void print() {
		ArrayList<String> temp = this.getArray();
		int x = temp.size();
		int i = 0;
		while (x-- > 0) {
			String s = "";
			for (int k = 0; k < (x); k++) {
				s += " ";
			}
			s += temp.get(x);
			
			System.out.printf("%s%s%n", s, temp.get((temp.size() - i) - 1));
			i++;
		}
	}
	
	private ArrayList<String> getArray() {
		return pyramid;
	}
	
	private String getStr(int index) {
		return pyramid.get(index);
	}
	
	
}
