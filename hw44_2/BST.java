/* Team Lemonade -- Alexia Leong and Taaseen Ali
APCS2 pd1
HW44 --  Prune Your Tree
2018-05-03 */


/*****************************************************
* class BST - v1:partial
* Implementation of the BINARY SEARCH TREE abstract data type (ADT)
*
* A BST maintains the invariant that, for any node N with value V,
* L<V && V<R, where L and R are node values in N's left and right
* subtrees, respectively.
* (Any value in a node's left subtree must be less than its value,
*  and any value in its right subtree must be greater.)
* This BST only holds ints (its nodes have int cargo)
*****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
  * default constructor
  *****************************************************/
  BST( )
  {
    _root = null;
  }


  /*****************************************************
  * void insert( int )
  * Adds a new data element to tree.
  *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
      stRoot.setLeft( newNode );
      else //recurse down left subtree
      insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
      stRoot.setRight( newNode );
      else //recurse down right subtree
      insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
    return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  /*****************************************************
  * TreeNode search(int)
  * returns pointer to node containing target,
  * or null if target not found
  *****************************************************/
  TreeNode search( int target )
  {
    return searchHelp(target, _root);
  }

  //TreeNode search helper
  TreeNode searchHelp(int target, TreeNode tmpRoot){
    if(tmpRoot.getValue() == target || tmpRoot == null){ //if current node contains target or empty tree
      return tmpRoot; //return current root
    }
    else if(tmpRoot.getValue() > target){ //if target is less than current
      return searchHelp(target, tmpRoot.getLeft()); //recursively search left subtree
    }
    else if(tmpRoot.getValue() < target){ //if target is greater than current
      return searchHelp(target, tmpRoot.getRight()); //recursively search right subtree
    }
    else{ //else not found
      return null;
    }

  }

  /*****************************************************
  * int height()
  * returns height of this tree (length of longest leaf-to-root path)
  * eg: a 1-node tree has height 0
  *****************************************************/
  public int height()
  {
    return heightHelper(_root);
  }

  public int heightHelper(TreeNode rt){
    if(rt == null) return 0; //no tree or you reached the end

    int leftBranch = heightHelper(rt.getLeft());   //height of left branch w/o root
    int rightBranch = heightHelper(rt.getRight());   //height of right branch w/o root

    if(leftBranch < rightBranch) return rightBranch + 1;  //height of the rightBranch is bigger but you need to add the root
    return leftBranch + 1;
  }

  /*****************************************************
  * int numLeaves()
  * returns number of leaves in tree
  *****************************************************/
  public int numLeaves()
  {
    return numLeavesHelper(_root);
  }

  public int numLeavesHelper(TreeNode rt){
    if(rt == null) return 0;
    if(rt.getLeft() == null && rt.getRight() == null) return 1;  //means this node is a leaf

    int leftBranch = numLeavesHelper(rt.getLeft());
    int rightBranch = numLeavesHelper(rt.getRight());

    return leftBranch + rightBranch;
  }

  //remove method
  public TreeNode remove(int val){
    TreeNode leader = _root;
    TreeNode follower = null;

    while(leader != null && leader.getValue() != val ){  //leader finds target node
      follower = leader;
      if(val < leader.getValue()) leader = leader.getLeft();   //if val is too small go towards left
      else if((val > leader.getValue())) leader = leader.getRight();  //when val is > than current node then go right
    }

    //different scenarios:
    if(leader == null) return null; //val is not in this tree

    //if node is a leaf
    if(leader.getLeft() == null && leader.getRight() == null){
      if(follower.getValue() > leader.getValue()) follower.setLeft(null);  //locate follower to leader
      else follower.setRight(null);
    }

    //if node has 1 child
    else if(leader.getLeft() == null) follower.setRight(leader.getRight());
    else if(leader.getRight() == null) follower.setLeft(leader.getLeft());
    
    //if node has 2 children then choose the predecessor in the inorder traversal (the greatest val on the left subtree)
    else{
      TreeNode tracker = leader.getLeft();
      while(tracker.getRight() != null){
        tracker = tracker.getRight();  //tracker is now greatest val on left branch
      }
      TreeNode newnode = remove(tracker.getValue());   //replacing leader with new value
      newnode.setLeft(leader.getLeft());
      newnode.setRight(leader.getRight());

      if(leader == _root) _root = newnode;   //locate where to replace with leader
      else{
        if (tracker.getValue() < tracker.getValue()) follower.setLeft(tracker);
        else follower.setRight(tracker);
      }
    }
    return leader;
  }

  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();

    System.out.println( "\n-----------------------------");

    System.out.println("Testing search: ");
    System.out.println(arbol.search(4));
    System.out.println(arbol.search(2));
    System.out.println(arbol.search(5));

    System.out.println("Height: " + arbol.height());  //should be 3
    System.out.println("Number of Leaves: " + arbol.numLeaves());  //should also be 3

    System.out.println("Testing remove:");
    arbol.remove(1);
    System.out.println("after removing 1:");
    arbol.preOrderTrav();
    arbol.remove(5);
    System.out.println("\nafter removing 5:");
    arbol.preOrderTrav();
    arbol.remove(4);
    System.out.println("\nafter removing 4:");
    arbol.preOrderTrav();
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
