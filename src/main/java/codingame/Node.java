package codingame;

class Node {

    // keep these​​​​​​‌​​​​‌‌​‌‌‌‌‌‌​‌​​‌‌​​​​​ fields
    Node left, right;
    int value;
    Node current = null;


    public Node find(int v) {
        Node current = this;
        // Keep navigating down the tree until either we've run
        // out of nodes to look at, or we've found the right value.
        while (current != null && current.value != v) {
            current = v < current.value ? current.left : current.right;
        }
        return current;
    }


    public static void main(String[] args) {
        Node small = new Node();
        small.value = 8;

        small.left = new Node();
        small.left.value = 5;
        small.right = new Node();
        small.right.value = 11;

		/*small.right.left = new Node();
		small.right.right = new Node();
		small.right.left.value = 3;
		small.right.right.value = 14;

		small.left.left = new Node();
		small.left.right = new Node();
		small.left.left.value = 4;
		small.left.right.value = 15;*/

        Node n = small.find(11);
        System.out.println(n.value);

        // Node x = large.find(100000);
    }

}
