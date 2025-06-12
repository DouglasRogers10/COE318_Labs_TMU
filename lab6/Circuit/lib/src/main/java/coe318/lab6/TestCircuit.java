package coe318.lab6;

public class TestCircuit {
    public static void main(String[] args) {
        System.out.println("Valid Circuit Test 1");

        //Create valid nodes
        Node n0 = new Node();
        Node n1 = new Node();
        Node n2 = new Node();

        //Create valid resistors
        Resistor r1 = new Resistor(100.0, n0, n1);
        Resistor r2 = new Resistor(220.0, n1, n2);

        //Print the circuit
        System.out.println("Circuit contents after first test:");
        System.out.println(Circuit.getInstance());

        System.out.println("\nInvalid Input Tests");

        //Invalid: Zero resistance
        try 
        {
            Resistor rInvalid1 = new Resistor(0, n0, n2);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Caught exception (zero resistance): " + e.getMessage());
        }

        // Invalid: Negative resistance
        try 
        {
            Resistor rInvalid2 = new Resistor(-50, n0, n2);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Caught exception (negative resistance): " + e.getMessage());
        }

        // Invalid: Null node
        try 
        {
            Resistor rInvalid3 = new Resistor(75, null, n1);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Caught exception (null node): " + e.getMessage());
        }

        //Invalid: Same node both ends
        try 
        {
            Resistor rInvalid4 = new Resistor(120, n1, n1);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Caught exception (same node): " + e.getMessage());
        }

        //Invalid: Add null resistor to circuit directly
        try 
        {
            Resistor rInvalid5 = null;
            Circuit.getInstance().add(rInvalid5);
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Caught exception (null resistor add): " + e.getMessage());
        }

        System.out.println("\nValid Circuit Test 2");

        //Additional valid nodes and resistors
        Node n3 = new Node();
        Node n4 = new Node();

        Resistor r3 = new Resistor(330.0, n2, n3);
        Resistor r4 = new Resistor(470.0, n3, n4);
        Resistor r5 = new Resistor(560.0, n4, n0);

        //Print final circuit
        System.out.println("Circuit contents after second test:");
        System.out.println(Circuit.getInstance());
    }
}
