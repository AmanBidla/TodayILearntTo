/* code to mirror a binary tree */

private void mirror(BSTNode node) {
  if (node != null) {
    	mirror(node.left);
    	mirror(node.right);

    // swap the left/right pointers
    Node temp = node.left;
    node.left = node.right;
    node.right = temp;
  }
}