import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		nCopies();
		disjoint();
	}

	public static void disjoint() {
		final String[] elements1 = { "A", "B", "C" };
		final List<String> list1 = Arrays.asList(elements1);

		final String[] elements2 = { "D", "E", "F" };
		final List<String> list2 = Arrays.asList(elements2);

		boolean containCommonElements = Collections.disjoint(list1, list2);
		System.out.println("Contain common elements: " + containCommonElements);
	}

	public static void nCopies() {
		final String[] elements = { "A", "B", "C", "D", "E" };
		final List<String> list = Arrays.asList(elements);
		final List<List<String>> list2 = Collections.nCopies(2, list);
		System.out.println(list2);

		final String str = "Test";
		final List<String> list3 = Collections.nCopies(2, str);
		System.out.println(list3);

	}
}
