/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber.pkg27_05_2019;

import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author andre
 */
public class Deber27_05_2019 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException//Cambia el main para poder realizar un enter y que siga la función sin necesidad de mostrar el caracter  
    {
        int option;//Declaro variable para utilizar el menu en el switch
        float base,altura,lado;
        Scanner sc=new Scanner(System.in);//Declaro el escaner
        do
        {

        menu();
        option=sc.nextInt();
        switch(option)//Inicio el switch como función para leer que despliegue el menú a interactuar
        {


            case 1:
            System.out.println();//Función para limpiar la pantalla de la opción anterior
            {
            Presentacion();//Llamo a la función presentación para que la muestre
            System.out.printf("\nIngrese la longitud de lado de su cuadrado -> ");
            lado=sc.nextFloat();
            square(lado);//Llamo a la función del cuadrado 
            System.in.read();//Función para pulsar el enter y que no muestre en la ejecución
            }
            break;

            case 2:
            System.out.println();
            {
            Presentacion();
            System.out.printf("\nIngrese la base y altura de su rectanculo:\n");
            base=sc.nextFloat();
            altura=sc.nextFloat();//Leo dato base y altura a la vez con un enter
            rectangle(base,altura);
            System.in.read();
            }
            break;

            case 3:
            System.out.println();
            {
            Presentacion();
            System.out.printf("\nIngrese la base y altura de su rectanculo:\n");
            lado=sc.nextFloat();
            altura=sc.nextFloat();
            triangle(lado,altura);
            System.in.read();
            }

            break;

          
            case 4:
            System.out.printf("\nGracias por usar el programa");
            System.out.printf("\n\nAndrewHacks.INC - Desarrollado por Carlos Andres Estrada Vasquez 2019\n");
            break;

            default:
            System.out.printf("\nElija opciones entre 1 y 4\n");
        }
        }while(option!=4);//Termino mi do-while en base al menú
    }
    
    private static void Presentacion()//Función presentación
    {
        System.out.printf("\n\n\tUNIVERSIDAD DE LAS FUERZAS ARMADAS - ESPE\n");
        System.out.printf("\n\n\tCLUB DE DESARROLLO DE SOFTWARE\n");
        System.out.printf("\nCARLOS ANDRES ESTRADA VASQUEZ\n");
        System.out.printf("\nNRC: 5717\n");
    }
    private static char menu()//Función menu;
    {
        System.out.println();
        Presentacion();
        System.out.printf("\n\tAREAS Y PERIMETROS\n");
        System.out.printf("\n1. AREA Y PERIMETRO CUADRADO\n");
        System.out.printf("\n2. AREA Y PERIMETRO RECTANGULO\n");
        System.out.printf("\n3. AREA Y PERIMETRO TRIANGULO EQUILATERO\n");
        System.out.printf("\n4. Salir\n");
        System.out.printf("\nElija su opcion -> ");
        return 0;
    }
    private static float square(float lado)//Función para calcular perimetro y area de cuadrado, con un dato de entrada
    {
        float area, perimeter;
        area=lado*lado;
        perimeter=4*lado;
        System.out.printf("\nEl area de un cuadrado de lado %f es %f\n",lado,area);
        System.out.printf("\nEl perimetro de un cuadrado de lado %f es %f\n",lado,perimeter);
        return 0;
        
    }
    private static float rectangle(float base,float altura)//Funcion para calcular el perimetro y area del rectangulo, con dos datos de entrada
    {
        float area, perimeter;
        area=base*altura;
        perimeter=2*base+2*altura;
        System.out.printf("\nEl area de un rectangulo de base %f y altura %f es %f\n",base,altura,area);
        System.out.printf("\nEl perimetro de un rectangulo de base %f y altura %f es %f\n",base,altura,perimeter);
        return 0;
        
    }
    private static float triangle(float lado,float altura)//Función para calcular el area del triangulo con dos datos de entrada
    {
        float area, perimeter;
        area=(lado*altura)/2;
        perimeter=3*lado;
        System.out.printf("\nEl area de un triangulo equilatero de lado %f y altura %f es %f\n",lado,altura,area);
        System.out.printf("\nEl perimetro de un triangulo equilatero de lado %f y altura %f es %f\n",lado,altura,perimeter);
        return 0;
        
    }


    
}
