/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw09_enes_kilicaslan;

/**
 *
 * @author Enes Kilicaslan
 *         
 */
public class PolynomialTest
{
    public static void main(String[] args) 
    {       
        double[] array1 = {-1.0, 2.0, 5.6, 445, 23, 0};
        double[] array2 = {7, 9.9, 5.9, -2.2 };
        double[] array3 = {1.0, 2.0, 5.6, 445, 23, 0};
        
        
        Polynomial myPol1 = new Polynomial(array1);       
        Polynomial myPol2 = new Polynomial(array2);
        Polynomial myPol3 = new Polynomial(array3);
        Polynomial myPol4 = new Polynomial(array1);//same as myPol1
        
        
        
        System.out.printf("myPol1: %s\n", myPol1.toString());
        System.out.printf("myPol2: %s\n", myPol2.toString());
        System.out.printf("myPol3: %s\n", myPol3.toString());
        
        
        System.out.printf("**********************************************************"
                + "**************************************************************\n\n");
                
        //substraction test
        System.out.printf("myPol1 - myPol2:  %s\n\n", myPol1.substracts(myPol2).toString());
        
        //addition test
        System.out.printf("myPol1 - myPol2:  %s\n\n", myPol1.adds(myPol2).toString());
        
        //muliplication test
        System.out.printf("myPol3 * myPol2:  %s\n\n", myPol3.multiplies(myPol2).toString());
       
        System.out.printf("**********************************************************"
                + "**************************************************************\n");
        
        //equals method test
        if(myPol3.equals(myPol2))
            System.out.printf("myPol3 and myPol2 are Equal \n\n");
        
        else
            System.out.printf("myPol3 and myPol2 are Not equal \n\n");
        
        if(myPol1.equals(myPol4))
            System.out.printf("myPol1 and myPol4 are Equal \n\n");
        
        else
            System.out.printf("myPol3 and myPol2 are Not equal \n\n");
           
    }
    
    
}
