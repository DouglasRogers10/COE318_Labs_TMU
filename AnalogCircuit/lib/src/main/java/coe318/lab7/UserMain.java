/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

import java.util.Scanner;
/**
 *
 * @author roger
 */

/*
TO FIX
- fix else if's after "SPICE"
- dont normalize voltage, but still check for duplicate
*/


/*
User Main
-  Reads user input
-  Interprets the r, v, spice, and end commands
*/

public class UserMain {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Circuit circuit = new Circuit();
        
        System.out.println("Welcome!\n");
        
        while (true)
        {
            String line = scanner.nextLine().trim();
            
            if(line.equalsIgnoreCase("end"))
            {
                System.out.println("All Done");
                break;
            }
            
            else if(line.equalsIgnoreCase("spice"))
            {
                if (!circuit.isValidNodeSet())
                {
                    System.out.println("ERROR: Circuit nodes must be numbered from 0 to n-1");
                    continue;
                }
                System.out.print(circuit.toSpice());
            }
            
            else
            {
                String[] parts = line.split("\\s+");
                
                if(parts.length != 4)
                {
                    System.out.println("Invalid component format.");
                    continue;
                }
                
                String type = parts[0];
                
                try
                {
                    int node1 = Integer.parseInt(parts[1]);
                    int node2 = Integer.parseInt(parts[2]);
                    double value = Double.parseDouble(parts[3]);
                    
                    if(node1 < 0 || node2 < 0)
                    {
                        System.out.println("Node numbers must be non-negative");
                        continue;
                    }
                    
                    if (node1 == node2)
                    {
                        System.out.println("Components cannot connect to the same node.");
                        continue;
                    }
                    
                  if (type.equalsIgnoreCase("r")) 
                  {
                        if (value <= 0) {
                            System.out.println("Resistance must be greater than 0.");
                            continue;
                        }
                        try {
                            circuit.addResistor(new Resistor(node1, node2, value));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                  } 
                  else if (type.equalsIgnoreCase("v")) 
                  {
                       if (value == 0) {
                            System.out.println("Voltage cannot be 0V.");
                            continue;
                        }  
                      
                      try {
                            circuit.addVoltageSource(new VoltageSource(node1, node2, value));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
}
                    
                    else
                    {
                        System.out.println("Unknown component type. Use r or v.");
                    }
                    
                }
                
        
                
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number format");
                }
                
            }
           
        }
        
        scanner.close();
    }
}
