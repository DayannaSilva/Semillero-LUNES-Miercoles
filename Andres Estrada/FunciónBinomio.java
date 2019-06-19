/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package función.binomio;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class FunciónBinomio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int potencia;
        System.out.printf("\nIngrese la potencia a la cual esta elevado el binomio -> ");
        potencia=sc.nextInt();
        int coeficiente;
        int potencia_a;
        if(potencia==1)
        {
            System.out.printf(" a + b ");
        }
        else
            if(potencia==0)
        {
            System.out.printf(" 1 ");
        }
       else 
         if(potencia==2)
        {
         for(int i=0;i<=potencia;i++)
        {  
         coeficiente=(calculo_factorial(potencia))/((calculo_factorial(i))*(calculo_factorial(potencia-i)));
         potencia_a=potencia-i;
            if(i==0)
             {
               System.out.printf(" a^%d ",potencia_a);
             }
           
           else 
             if(i==potencia)
             {
                 System.out.printf(" + b^%d ",i);
             }
            else
                System.out.printf(" + %da b ",coeficiente);
        }
         
        }
        else
        for(int i=0;i<=potencia;i++)
        {  
         coeficiente=(calculo_factorial(potencia))/((calculo_factorial(i))*(calculo_factorial(potencia-i)));
         potencia_a=potencia-i;
         if(i==0)
         {
           System.out.printf(" a^%d ",potencia_a);
         }
         else 
             if(i==potencia)
             {
                 System.out.printf(" + b^%d ",i);
             }
         else
             if(potencia_a==1)
             {
               System.out.printf(" + %da b^%d ",coeficiente,i);  
             }
         else
            if(i==1)
             {
               System.out.printf(" + %da^%d b ",coeficiente,potencia_a);  
             }
                 
         else
              System.out.printf(" + %da^%d b^%d ",coeficiente,potencia_a,i);
        
            
        }
        System.out.println("");
        // TODO code application logic here
    }
    public static int calculo_factorial(int potencia)
    {
        int factorial=1;
          while (potencia!=0) 
          {
          factorial=factorial*potencia;
          potencia--;
          }
         
         return factorial;
    }  
    

    
    
    
}
