/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas.y.perimetros;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class AreasYPerimetros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
   
        int option;//Declaro variable para utilizar el menu en el switch
        float lado_1,lado_2,lado_3;
        Scanner sc=new Scanner(System.in);
        System.out.printf("\nIngrese los lados de su triangulo:\n");
        lado_1=sc.nextFloat();
        lado_2=sc.nextFloat();
        lado_3=sc.nextFloat();
        Analisis_Triangle(lado_1,lado_2,lado_3);
        
     }
     
    private static float Analisis_Triangle(float lado_1, float lado_2, float lado_3)
    {
        if(((lado_3>0)&&(lado_1>0)&&(lado_2>0))&&(lado_1+lado_2>lado_3))
        {
         if(lado_1==lado_2&&lado_2==lado_3)
        {
             System.out.printf("\nEl triangulo de lados %f %f  %f es equilatero\n",lado_1,lado_2,lado_3);
             Area_Perimetro(lado_1,lado_2,lado_3);
             
        }
        else
            if(lado_1==lado_2||lado_2==lado_3||lado_1==lado_3)
            {
                 System.out.printf("\nEl triangulo de lados %f %f  %f es isosceles\n",lado_1,lado_2,lado_3);
                 Area_Perimetro(lado_1,lado_2,lado_3);
            }
         else
            if(lado_1!=lado_2&&lado_2!=lado_3)
           {
                System.out.printf("\nEl triangulo de lados %f %f  %f es escaleno\n",lado_1,lado_2,lado_3);
                Area_Perimetro(lado_1,lado_2,lado_3);
           }
        }
        else
            
        {
            System.out.printf("\nNo es un triangulo\n");
        }
        
        
        return 0;
    }
    
        
         private static float Area_Perimetro(float lado_1,float lado_2,float lado_3)//Función para calcular el area del triangulo con dos datos de entrada
    {
        float area, perimeter,s;
        perimeter=lado_1+lado_2+lado_3;
        s=perimeter/2;
        area=(float) Math.sqrt(s*(s-lado_1)*(s-lado_2)*(s-lado_3));
        System.out.printf("\nEl perimetro del de lados %f %f %f es %f\n",lado_1,lado_2,lado_3,perimeter);
        System.out.printf("\nEl area del triangulode lados %f %f %f es %f\n",lado_1,lado_2,lado_3,area);
        return 0;
    }
    
            

}
