/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

/**
 *
 * @author roger
 */
public class Resistor implements Component{
    private static int count = 1;
    private int id;
    private final int node1, node2;
    private final double resistance;
    
    public void setId (int id)
    {
        this.id = id;
    }
    
    public Resistor(int node1, int node2, double resistance)
    {
        if(resistance <= 0)
        {
            throw new IllegalArgumentException ("Resistance must be greater than 0");
        }
        this.node1 = node1;
        this.node2 = node2;
        this.resistance = resistance;
    }
    
    public int getNode1()
    {
        return node1;
    }
    
    public int getNode2()
    {
        return node2;
    }
    
    public boolean isDuplicateOf (Resistor other)
    {
        return (this.node1 == other.node1 && this.node2 == other.node2) ||
                (this.node1 == other.node2 && this.node2 == other.node1);
    }
    
    public String toSpice()
    {
        return "R" + id + " " + node1 + " " + node2 + " " + resistance + "\n";
    }
    
}
