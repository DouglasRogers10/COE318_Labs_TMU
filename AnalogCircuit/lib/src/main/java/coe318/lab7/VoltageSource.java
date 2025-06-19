/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

/**
 *
 * @author roger
 */
public class VoltageSource implements Component {
    
    private static int count = 1;
    private  int id;
    private final int posNode, negNode;
    private final double voltage;
    
     public void setId (int id)
    {
        this.id = id;
    }
    
    public VoltageSource(int posNode, int negNode, double voltage)
    {
        //SHOULDNT WE ALSO CHECK FOR NEGATIVE NODES
        this.posNode = posNode;
        this.negNode = negNode;
        this.voltage = voltage;
    }
    
    public int getPosNode()
    {
        return posNode;
    }
    
    public int getNegNode()
    {
        return negNode;
    }
    
    public boolean isDuplicateOf (VoltageSource other)
    {
        return (this.posNode == other.posNode && this.negNode == other.negNode && this.voltage == other.voltage) ||
                (this.posNode == other.negNode && this.negNode == other.posNode && this.voltage == - other.voltage);
    }
    
    public String toSpice()
    {
        return "V" + id + " " + posNode + " " + negNode + " DC " + voltage + "\n";
    }
    
}
