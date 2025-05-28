/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;

/**
 *
 * @author roger
 */
public class Account {
    
    private String name;
    private int number;
    private double balance;
    
    public Account(String name, int number, double initialBalance)
    {
        this.name = name;
        this.number = number;
        this.balance = initialBalance;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public boolean deposit(double amount)
    {
        if (amount <= 0)
        {
            return false;
        }
        balance += amount;
        return true;
    }
    
    public boolean withdraw(double amount)
    {
        if (amount <= 0 || amount > balance)
        {
            return false;
        }
        balance -= amount;
        return true;
    }
 
    @Override
    public String toString() {//DO NOT MODIFY
    return "(" + getName() + ", " + getNumber() + ", " +
    String.format("$%.2f", getBalance()) + ")";
    }
    
}
