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
        // TODO code application logic here
    }
    
/*public static boolean comprobar_capicua(String cadena)
{
    String [] stringCadena=cadena.split("");
    for(int i=0;i<=cadena.length;i++)
    {
        
    }
}*/
    
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

}

