/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

/**
 *
 * @author Ryan Vickramasinghe
 */
public class Node {
    private BirdRecord data;
    private Node left, right;
    
    //default constructor
    public Node(){};
    
    public Node(BirdRecord data) {
        this.data = data;
        left = null;
        right = null;
    }
    
    public void setData(BirdRecord data) { this.data = data; }
    
    public void setLeft(Node left) { this.left = left; }
    
    public void setRight(Node right) { this.right = right; }
    
    public BirdRecord getData() { return data; }
    
    public Node getLeft() { return left; }
    
    public Node getRight() { return right; }
}
