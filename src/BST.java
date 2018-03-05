
public class BST {

  private BSTNode root;

  public static BST newBST() {
    int arr[] = new int[] {7, 5, 15, 1, 100, 4, 6, 9};
    BST tree = new BST();

    for (int i = 0; i < arr.length; i++) {
      tree.insert(arr[i]);
    }

    return tree;
  }

  public void insert(int value) {
    if (root == null) {
      root = new BSTNode(value);
      return;
    }

    insertInternal(root, value);
  }

  private void insertInternal(BSTNode node, int value) {
    if (value >= node.getValue()) {
      if (node.getRight() != null) {
        insertInternal(node.getRight(), value);
      } else {
        BSTNode bstNode = new BSTNode(value);
        node.setRight(bstNode);
      }
    } else {
      if (node.getLeft() != null) {
        insertInternal(node.getLeft(), value);
      } else {
        BSTNode bstNode = new BSTNode(value);
        node.setLeft(bstNode);
      }
    }
  }

  public void inOrderTraversal() {
    inOrderTraversalInternal(root);
  }

  private static void inOrderTraversalInternal(BSTNode node) {
    if (node == null) {
      return;
    }

    if (node.getLeft() != null) {
      inOrderTraversalInternal(node.getLeft());
    }

    node.visit();

    if (node.getRight() != null) {
      inOrderTraversalInternal(node.getRight());
    }
  }

  /**
   * <a href="https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/">
   *   Question</a>
   * @return
   */
  public BSTNode toDoublyLinkedList() {
    return toDoublyLinkedListInternal(root);
  }

  private BSTNode toDoublyLinkedListInternal(BSTNode node) {
    if (node == null) {
      return null;
    }

    BSTNode prevListStart = null;
    BSTNode nextListStart = null;
    if (node.getLeft() != null) {
      prevListStart = toDoublyLinkedListInternal(node.getLeft());
    }

    if (node.getRight() != null) {
      nextListStart = toDoublyLinkedListInternal(node.getRight());
    }

    node.setLeft(node);
    node.setRight(node);

    if (prevListStart == null) {
      prevListStart = node;
    }

    if (prevListStart.getLeft() != null) {
      prevListStart.getLeft().setRight(node);
      node.setLeft(prevListStart.getLeft());

      prevListStart.setLeft(node);
      node.setRight(prevListStart);
    }

    if (nextListStart == null) {
      return prevListStart;
    }

    BSTNode lastNode = nextListStart.getLeft();

    prevListStart.getLeft().setRight(nextListStart);
    nextListStart.setLeft(prevListStart.getLeft());

    prevListStart.setLeft(lastNode);
    lastNode.setRight(prevListStart);

    return prevListStart;
  }

  public static void main(String args[]) {
    BST bst = BST.newBST();
    bst.inOrderTraversal();

    System.out.println();
    System.out.print("List: ");

    BSTNode listStart = bst.toDoublyLinkedList();
    listStart.visitList();
  }
}
