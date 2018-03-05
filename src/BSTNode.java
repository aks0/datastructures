
public class BSTNode {

  private final int value;

  private BSTNode left;
  private BSTNode right;

  public BSTNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public BSTNode getLeft() {
    return left;
  }

  public BSTNode getRight() {
    return right;
  }

  public BSTNode setLeft(BSTNode left) {
    this.left = left;
    return this;
  }

  public BSTNode setRight(BSTNode right) {
    this.right = right;
    return this;
  }

  public void visit() {
    System.out.print(value + " ");
  }

  public void visitList() {
    BSTNode node = this;
    do {
      node.visit();
      node = node.right;
    } while (node != this);
  }
}
