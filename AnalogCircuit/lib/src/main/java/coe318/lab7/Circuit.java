/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;
import java.util.ArrayList;
/**
 *
 * @author roger
 */
public class Circuit {
    private final ArrayList<Component> components = new ArrayList<>();
    private final ArrayList<Integer> seenNodes = new ArrayList<>();
    private int resistorCount = 1;
    private int voltageCount = 1;
    private int maxNode = -1;
    
    public void addResistor(Resistor r)
    {
        if (r == null)
        {
            throw new IllegalArgumentException("Resistor cannot be null");
        }
        
        for (Component c: components)
        {
            if (c instanceof Resistor && ((Resistor)c).isDuplicateOf(r))
            {
                throw new IllegalArgumentException("Duplicate resistor detected. Please try again.");
            }
        }
        r.setId(resistorCount++);
        components.add(r);
        
    }
    
    public void addVoltageSource(VoltageSource v)
    {
        if (v == null)
        {
           throw new IllegalArgumentException("Resistor cannot be null");
        }
        
        for (Component c: components)
        {
            if (c instanceof VoltageSource && ((VoltageSource)c).isDuplicateOf(v))
            {
                throw new IllegalArgumentException("Duplicate voltage source detected. Please try again.");
            }
        }
        
        v.setId(voltageCount++);
        components.add(v);
    }
    
    
    public boolean isValidNodeSet()
    {
        for (Component c: components)
        {
            if (c instanceof Resistor)
            {
                Resistor r = (Resistor) c;
                int n1 = r.getNode1();
                int n2 = r.getNode2();
                maxNode = Math.max(maxNode, Math.max(n1, n2));
                if(!seenNodes.contains(n1))
                {
                    seenNodes.add(n1);
                }
                if(!seenNodes.contains(n2))
                {
                    seenNodes.add(n2);
                }
            }
            else if (c instanceof VoltageSource)
            {
                VoltageSource v = (VoltageSource) c;
                int n1 = v.getPosNode();
                int n2 = v.getNegNode();
                maxNode = Math.max(maxNode, Math.max(n1, n2));
                if(!seenNodes.contains(n1))
                {
                    seenNodes.add(n1);
                }
                if(!seenNodes.contains(n2))
                {
                    seenNodes.add(n2);
                }
            }
        }
        for (int i = 0; i <= maxNode; i++)
        {
            if (!seenNodes.contains(i))
            {
                return false;
            }
        }
        return true;
    }
    
    
    public String toSpice()
    {
        StringBuilder sb = new StringBuilder();
        
        for(Component c : components)
        {
            sb.append(c.toSpice());
        }
        
        return sb.toString();
    }
    
}
