package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class  Main {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left=null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static class BinaryTree{

        static int index=-1;
        public Node bst(int[] input){
            index++;
            if(input[index] == -1) return null;
            Node output = new Node(input[index]);
            output.left = bst(input);
            output.right = bst(input);
            return  output;
        }

        public void preOrderTraversal(Node node){

            if(node == null) return ;
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);

        }

        public void inOrderTraversal(Node node){
            if(node == null) return;

            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }

        public void postOrderTraversal(Node node){
            if(node == null) return;

            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }

        public void bfs(Node node){
            if(node == null){
                return;
            }
            Queue<Node> dataQueue = new LinkedList<>();
            dataQueue.add(node);
            dataQueue.add(null);

            while (!dataQueue.isEmpty()){
                Node current = dataQueue.remove();

                if(current == null){
                    System.out.println();
                    if(!dataQueue.isEmpty()){
                        dataQueue.add(null);
                    }else break;
                }else{
                    System.out.print(current.data);
                    if(current.left != null)
                    dataQueue.add(current.left);
                    if(current.right != null)
                    dataQueue.add(current.right);
                }
            }

        }

        public void reverse(Node node){
            if(node == null){
                return ;
            }

            Queue<Node> dataQueue = new LinkedList<>();
            dataQueue.add(node);
            dataQueue.add(null);

            while (!dataQueue.isEmpty()){
                Node current = dataQueue.remove();
                if(current == null){
                    System.out.println();
                    if(!dataQueue.isEmpty()){
                        dataQueue.add(null);
                    }else break;
                }else{
                    System.out.print(current.data);
                    if(current.right != null)
                        dataQueue.add(current.right);
                    if(current.left != null)
                        dataQueue.add(current.left);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] input ={1, 2,4,-1,-1,5,-1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.bst(input);

        System.out.println("bfs");
        bt.bfs(root);
        bt.reverse(root);
    }
}