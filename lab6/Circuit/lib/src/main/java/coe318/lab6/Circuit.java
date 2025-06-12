/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab6;

import java.util.ArrayList;

/**
 *
 * @author roger
 */
public class Circuit {
    private static Circuit instance = null;
    
    public static Circuit getInstance()
    {
        if (instance == null)
        {
            instance = new Circuit();
        }
        return instance;
    }
    
    private Circuit(){};//PRIVATE CONSTRUCTOR
    
    private ArrayList<Resistor> resistors = new ArrayList<>();
    
    public void add(Resistor r)
    {
        if (r == null)
        {
            throw new IllegalArgumentException("Cannot add null resistor to circuit.");
        }
        resistors.add(r);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Resistor r : resistors)
        {
            sb.append(r.toString()).append("\n");
        }
        return sb.toString();
    }
}
