/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays.of.arrays;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class ArraysOfArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    String [][]nombre=new String[2][2];//Declaro la matriz nombre
    String [][]apellido=new String[2][2];//Declaro la matriz apellido
    String [][]completo=new String[2][2];//Declaro la matriz para unir el nombre completo
    Scanner sc=new Scanner(System.in);//Declaro la funcion escaner para leer los datos
    
    for(int i=0;i<2;i++)//Ingreso y leo datos desde el teclado para el nombre
    {
       for(int j=0;j<2;j++)
       {
         System.out.printf("\nIngrese el nombre  -> ");
         nombre[i][j]=sc.nextLine();
       }
    }
    System.out.printf("\n\n");
     for(int i=0;i<2;i++)//Imprimo matriz nombre
    {
       for(int j=0;j<2;j++)
       {
           System.out.printf(" %s",nombre[i][j]);
       }
       System.out.printf("\n");
    }
   for(int i=0;i<2;i++)//Ingreso y leo datos desde el teclado para el apellido
    {
       for(int j=0;j<2;j++)
       {
         System.out.printf("\nIngrese el apellido  -> ");
         apellido[i][j]=sc.nextLine();
       }
    }
    System.out.printf("\n\n");//Imprimo la matriz de apellidos
     for(int i=0;i<2;i++)
    {
       for(int j=0;j<2;j++)
       {
           System.out.printf(" %s",apellido[i][j]);
       }
       System.out.printf("\n");
    }

    System.out.printf("\n\n");//Uno las dos matrices para tener el nombre completo
     for(int i=0;i<2;i++)
    {
       
       for(int j=0;j<2;j++)
       {
           
           System.out.printf(" %s %s  ",nombre[i][j],apellido[i][j]);
           System.out.printf("\n");
       }
 
    }
     
    
    }
    
}
