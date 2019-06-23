/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.Scanner;

/**
 *
 * @author andrewhacks
 */
public class Taller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        String ingresoDato_1;
        boolean flag=false;
        boolean flag_2=true;
        do
        {
        System.out.print("\nIngrese el dato -> ");
        ingresoDato_1=sc.nextLine();
        if(isNumeric(ingresoDato_1))
        {
        System.out.printf("\n%s es un numero entero",ingresoDato_1);
        }
        else
        if(isLetter(ingresoDato_1))
        {
        System.out.printf("\n%s es una cadena de letras",ingresoDato_1);
        }
        else
        System.out.printf("\nNo es un numero entero ni una cadena, ingrese otra cadena");
        
        }while((isNumeric(ingresoDato_1))==flag && (isLetter(ingresoDato_1))==flag);
        System.out.println("");
        if(isNumeric(ingresoDato_1)==flag_2)
        {
            if(isCapicua(ingresoDato_1)==flag_2)
            {
               System.out.println("Es capicua");
               String [] stringNumber=ingresoDato_1.split("");
               int suma=0;
               
               for(int i=0;i<stringNumber.length;i++)
               {
                 int arrayNumberCapicua[]=new int[stringNumber.length];
                 arrayNumberCapicua[i]=Integer.parseInt(stringNumber[i]);
                 suma=suma+arrayNumberCapicua[i];
                 
               }
                System.out.println("La suma del numero capicua "+ingresoDato_1+" es "+suma);
                System.out.println("");
                
               
            }
            else
            {
               int numberPlus;
               int iPosicion=0;

               String [] stringNumber=ingresoDato_1.split("");
               int saveData=Integer.parseInt(stringNumber[0]);
                System.out.println("");
                System.out.print("El arreglo mayor es:");
               for(int i=0;i<stringNumber.length;i++)
               {
                 int arrayNumberCapicua[]=new int[stringNumber.length];
                 arrayNumberCapicua[i]=Integer.parseInt(stringNumber[i]);
                 numberPlus=arrayNumberCapicua[0];

                 for(int j=1;j<stringNumber.length;j++)
                 {
                     if(arrayNumberCapicua[j]>numberPlus)
                     {
                         numberPlus=arrayNumberCapicua[j];
                         iPosicion=j;
                         System.out.printf("%d",numberPlus);
                         
                     }
                 }
                 
               }
               System.out.printf("%d",saveData);
               System.out.println("");


                
            }
            
                
            
        }

            
        
        
        // TODO code application logic here
    }
    
    
public static boolean isNumeric(String cadena)
{
        try {
                Integer.parseInt(cadena);
                return true;
        } catch (NumberFormatException nfe){
                return false;
        }
 }

public static boolean isLetter(String cadena)
{
    if(!cadena.matches(".*[^A-z].*"))
    {
        return true;
    }
    else 
        return false;
  
}
public static boolean isCapicua(String cadena)
{
    String cadenaInvertida= new String("");
    for (int i=cadena.length()-1;i>=0;i--)
    {
        cadenaInvertida = cadenaInvertida + cadena.charAt(i);
    }
    
    if(cadena.equals(cadenaInvertida))
    {
    return true;
    }
    else
    return false;
    
}
        

}

