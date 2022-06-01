package com.mucho;

public class Node {

    private String data; // using String so that we can handle numbers that are more than one digit
    private Node left;
    private Node right;

    public Node(String data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(String data, Node leftNode, Node rightNode){
        this.data = data;
        this.left = leftNode;
        this.right = rightNode;
    }

    public Node(String data, Node leftNode){
        this.data = data;
        this.left = leftNode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
