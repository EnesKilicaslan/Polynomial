/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw09_enes_kilicaslan;

/**
 *
 * @author Enes Kilicaslan
 *         141044088
 */
public class Polynomial 
{
    private double[]  coefficients;
    
    /**Creates a Polynomial with double array parameter
     * @param newCoefficients 
     */
    public Polynomial( double[] newCoefficients)
    {
        //creating new array because I dont want to be effected by outside changes
        coefficients = new double[newCoefficients.length];
        
        //assign the new array to same values with parameter
        for(int i = 0; i < newCoefficients.length; i++)
            coefficients[i] = newCoefficients[i];
    }  
    
    /**Creates a Polynomial with number of size elements 
     * and all of them are zero
     * @param size
     */
    public Polynomial( int size)
    {
        coefficients = new double[size]; 
        //assign all elements of the array to zero
        for(int i = 0; i < size; i++)
            coefficients[i] = 0.0;
    } 
    
    /**Creates a Polynomial from another polynomial
     * Same as the parameter Polynomial
     * @param other     
     */
    public Polynomial(Polynomial other)
    {
        if(other == null)
        {
            //we can not dereferance null values
            System.out.printf("Error NULL Value!!");
            System.exit(0);
        }
        
        else
        {
        //creating new array because I dont want to be effected by outside changes        
        coefficients = new double[other.getCoefficients().length];
        
        //assign the new array to same values with the array of paramater obj
        for(int i = 0; i < other.getCoefficients().length; i++)
            coefficients[i] = other.getOneCoefficient(i);  
        }
    }
    
    /**Sets all of the coefficients with double array parameter
     * @param newCoefficients
     */
    void setCoefficients(double[] newCoefficients)
    {
        coefficients = newCoefficients;
    }
    
    /**Gets all of the coefficients
     * @return coefficients
     */
    double[] getCoefficients()
    {
        return coefficients;
    }
    
    /**Set One coefficient at index i to newCoefficient
     * @param newCoefficient, i
     */
    void setOneCoefficient(double newCoefficient, int i)
    {
        coefficients[i] = newCoefficient;
    }
    
    /**Get One coefficient at index i 
     * @param i
     * @return coefficients[i]
     */
    double getOneCoefficient(int i)
    {
        return coefficients[i];
    }
    
    /**Represent Polynomial objects as a string
     * @return String for Polynomial Class
     */
    @Override
    public String toString()
    {
        String theString = "";
        for(int i= 0; i < this.getCoefficients().length; i++)
        {
            if(i != this.getCoefficients().length - 1)
            {    
            theString = theString + String.format("%.2fx^%d + ",this.getOneCoefficient(i),
                    this.getCoefficients().length - 1 - i);
            }
            
            else//this is last element don't add "x" and "+" 
            {
                theString = theString + String.format("%.2f\n", this.getOneCoefficient(i));
            }
        }
            
        return theString;
    }
    
    /**Checks two Polynomial Objects
     * If they are equal @return true
     * if they are NOT equal @return false
     * @param other
     * @return true|false 
     */
    @Override
    public boolean equals(Object other)
    {
        if(other == null)
            return false;
        
        else if(!(other instanceof Polynomial))
            return false;
        
        //if they don't have same lenght, they can not be equal
        else if(this.getCoefficients().length != this.getCoefficients().length)
            return false;
        
        //if they are pointing same object, they are already equal
        else if(other == this)
            return true;
        
        else
        {
            for(int i=0; i < this.getCoefficients().length; i++)
                if(this.getOneCoefficient(i) != ((Polynomial) other).getOneCoefficient(i) )
                    return false;
           
            return true; 
        }                                  
    }
    /**I did not implement this function because I don't need it
     * This Function will not be called
     * @return   1  
     */   
    @Override
    public int hashCode() 
    {
        //Attention!! This is not real implementation
        return 1;//Always returns 1
    }
       
    /**Adds two Polynomial object to each other and returns it
     * @param other
     * @return addition result
     */
    public Polynomial adds(Polynomial other)
    {
        Polynomial temp1 = new Polynomial(this);
        Polynomial temp2 = new Polynomial(other);
       
        int temp1Degree = temp1.getCoefficients().length;
        int temp2Degree = temp2.getCoefficients().length;
       
        if(temp1Degree > temp2Degree)
        {
            for(int i = 0; i < temp2Degree; i++ )
                temp1.setOneCoefficient(temp1.getOneCoefficient(temp1Degree - temp2Degree + i)
                       + temp2.getOneCoefficient(i), temp1Degree - temp2Degree + i);
            
            //lengt of temp1 is greater, We work on temp1 and returned temp1
            return new Polynomial(temp1);
        }
        
        else
        {
            for(int i = 0; i < temp1Degree; i++ )
                temp2.setOneCoefficient(temp2.getOneCoefficient(temp2Degree - temp1Degree + i)
                       + temp1.getOneCoefficient(i), temp2Degree - temp1Degree + i);
            
            //lengt of temp2 is greater, We work on temp2 and returned temp2
            return new Polynomial(temp2);
        }
                  
    }
    
    /**Subtracts one Polynomial object from other
     * And returns it
     * @param other
     * @return subtraction result
     */
    public Polynomial substracts(Polynomial other)
    {   
        Polynomial temp1 = new Polynomial(this);
        Polynomial temp2 = new Polynomial(other);
        
        int temp2Degree = temp2.getCoefficients().length;
        
        //change all of the elements of temp2 to minus
        for(int i = 0; i < temp2Degree; i++ )
            temp2.setOneCoefficient((-1) * temp2.getOneCoefficient(i), i);
        
        //and add it
        return temp1.adds(temp2);       
    } 
    
    /**Multiply two Polynomial objects and returs it
     * @param other
     * @return multiplication result
     */
    public Polynomial multiplies(Polynomial other)
    {
        Polynomial temp1 = new Polynomial(this);
        Polynomial temp2 = new Polynomial(other);
        
        int temp1Degree = temp1.getCoefficients().length;
        int temp2Degree = temp2.getCoefficients().length;
        
        //create another Polynomial object to store result of multiplication
        Polynomial temp = new Polynomial(temp1Degree + temp2Degree - 1);
        
        for (int i = 0; i < temp1Degree; i++)
            for (int j = 0; j < temp2Degree; j++)
            {               
                temp.setOneCoefficient( temp.getOneCoefficient(i+j) + 
                        (temp1.getOneCoefficient(i) * temp2.getOneCoefficient(j)), i + j);
            }
        
        return temp;
    }
}
