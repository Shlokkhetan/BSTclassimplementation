package Tree;



public class BinaryTree  {
    Node root;

    public void add(int data){
        Node nodeToAdd = new Node(data);

        if(root == null){
            root = nodeToAdd;
        }

        traverseAndAdd(root,nodeToAdd);
        // if the data is less than the current node traverse left else right untill a node is reached that cannot be traversed.


    }
    private void traverseAndAdd(Node node, Node nodeToAdd){


        if(nodeToAdd.data<node.data){
            if(node.leftChild == null){
                nodeToAdd.parent = node;
                node.leftChild = nodeToAdd;
            }else{
                traverseAndAdd(node.leftChild, nodeToAdd);
            }

        }
        if(nodeToAdd.data>node.data){
            if(node.rightChild == null){
                nodeToAdd.parent = node;
                node.rightChild = nodeToAdd;
            }else{
                traverseAndAdd(node.rightChild, nodeToAdd);
            }

        }

    }

    public void traverse(){

        //preorder,in,post
        if(root != null){
            Node nodeToTraverse = root;

            if(nodeToTraverse.leftChild == null&& nodeToTraverse.rightChild == null){
                System.out.println(nodeToTraverse.data);
            }else{
                postOrder(nodeToTraverse);




            }




        }
    }

    private void inOrderTraversal(Node node){


        //inorder

        if(node.leftChild!= null){
            inOrderTraversal(node.leftChild);

        }
        System.out.println(node.data);
        if(node.rightChild!=null){
            inOrderTraversal(node.rightChild);

        }

    }

    private void preOrder(Node node){
        System.out.println(node.data);


        //inorder

        if(node.leftChild!= null){
            preOrder(node.leftChild);

        }
        if(node.rightChild!=null){
            preOrder(node.rightChild);

        }

    }

    private void postOrder(Node node){



        //inorder

        if(node.leftChild!= null){
            postOrder(node.leftChild);

        }
        if(node.rightChild!=null){
            postOrder(node.rightChild);

        }
        System.out.println(node.data);

    }
    public boolean delete(int val){
        Node nodeToDelete = findNode(val);
        if(nodeToDelete != null){

            if(nodeToDelete.leftChild == null && nodeToDelete.rightChild==null){
                deletecase1(nodeToDelete);
            }else if(nodeToDelete.rightChild!=null&&nodeToDelete.leftChild!=null){
                deletecase3(nodeToDelete);
            }else if(nodeToDelete.leftChild!= null){
                deletecase2(nodeToDelete);

            }else if(nodeToDelete.rightChild!=null){
                deletecase2(nodeToDelete);
            }



        }


        return false;
    }

    private void deletecase3(Node nodeToDelete) {
        Node minNode = leftMinTraversal(nodeToDelete.rightChild);
        deletecase2(minNode);
        minNode.parent = nodeToDelete.parent;
        minNode.leftChild = nodeToDelete.leftChild;
        minNode.rightChild = nodeToDelete.rightChild;

        if(nodeToDelete.parent.leftChild == nodeToDelete){



            nodeToDelete.parent.leftChild = minNode;
        }else if(nodeToDelete.parent.rightChild == nodeToDelete){



            nodeToDelete.parent.rightChild = minNode;
        }
    }

    private Node leftMinTraversal(Node node) {
        if(node.leftChild == null){
            return null;
        }
        return leftMinTraversal(node.leftChild);
    }

    private void deletecase2(Node nodeToDelete) {
        if(nodeToDelete.parent.leftChild == nodeToDelete){
            if(nodeToDelete.leftChild!= null){
                nodeToDelete.parent.leftChild = nodeToDelete.leftChild;
            }else if(nodeToDelete.rightChild!= null){
                nodeToDelete.parent.leftChild = nodeToDelete.rightChild;
            }

        }else if(nodeToDelete.parent.rightChild == nodeToDelete){
            if(nodeToDelete.leftChild!= null){
                nodeToDelete.parent.rightChild = nodeToDelete.leftChild;
            }else if(nodeToDelete.rightChild!= null){
                nodeToDelete.parent.rightChild = nodeToDelete.rightChild;
            }
        }
    }

    private void deletecase1(Node nodeToDelete) {
        if(nodeToDelete.parent.leftChild == nodeToDelete){
            nodeToDelete.parent.leftChild = null;


        }
        if(nodeToDelete.parent.rightChild == nodeToDelete){
            nodeToDelete.parent.rightChild = null;

        }

    }

    public Node findNode(int val){
        if(root != null ){
            return findNode(root, new Node(val));


        }
        return null;
    }

    private Node findNode(Node search, Node node ){
        if(search == null){
            return null;
        }
        if(search.data == node.data){
            return search;
        }else{
            Node returnNode = findNode(search.leftChild,node);
            if(returnNode == null){
                returnNode = findNode(search.rightChild,node);
            }
            return returnNode;
        }
    }


}
