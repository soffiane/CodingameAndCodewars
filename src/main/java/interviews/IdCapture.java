package interviews;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class IdCapture {

	public static class Node {
		private String value;
		private List<Node> children;

		public Node(String value, Node... children) {
			this.value = value;
			this.children = Arrays.asList(children);
		}

		public String getValue() {
			return value;
		}

		public List<Node> getChildren() {
			return children;
		}

		private static String printHtmlTree(Node current) {
			StringBuilder builder = new StringBuilder();
			builder.append("<li>").append(current.getValue()).append("</li>");
			builder.append("<ul>").append(current.getChildren().stream().filter(Objects::nonNull).map(Node::printHtmlTree).collect(Collectors.joining(" "))).append("</ul>");
			return builder.toString();
		}

		public static void main(String[] args) {
			Node current = new Node("root", new Node("A", new Node("C"), new Node("D")), new Node("B"));
			System.out.println(printHtmlTree(current));
		}
	}

}
