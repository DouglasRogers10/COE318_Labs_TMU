/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package coe318.lab7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author roger
 */
public class ResistorTest {
    

    /**
     * Test of isDuplicateOf method, of class Resistor.
     */
    @Test
    public void testIsDuplicateOfTrue() {
        Resistor r1 = new Resistor(1, 2, 100.0);
        Resistor r2 = new Resistor(2, 1, 100.0);
        assertTrue(r1.isDuplicateOf(r2));
    }
    
    @Test
    public void testIsDuplicateOfFalse() {
        Resistor r1 = new Resistor(1, 2, 100.0);
        Resistor r2 = new Resistor(1, 3, 100.0);
        assertFalse(r1.isDuplicateOf(r2));
    }

    /**
     * Test of toSpice method, of class Resistor.
     */
    @Test
    public void testToSpice() {
        Resistor r = new Resistor(1, 2, 50.0);
        r.setId(1); // simulate circuit assigning ID
        String output = r.toSpice();
        assertTrue(output.startsWith("R1"));
        assertTrue(output.contains("1"));
        assertTrue(output.contains("2"));
        assertTrue(output.contains("50.0"));
    }
    
}
