/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab6;

/**
 *
 * @author roger
 */
public class Node {
    private static int nextId = 0; //STATIC shared across all instances
    private int id;
    
    
    public Node()
    {
        if(nextId < 0)
        {
            throw new IllegalArgumentException("Node ID cannot be negative");
        }
        this.id = nextId++;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(this.id);
    }
}
