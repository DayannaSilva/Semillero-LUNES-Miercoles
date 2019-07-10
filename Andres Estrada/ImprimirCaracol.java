/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imprimircaracol;

import java.util.Scanner;

/**
 *
 * @author andrewhacks
 */
public class ImprimirCaracol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int intSize;
        int [][] intMatrizCaracol;
        System.out.print("Ingrese el tamanio para el caracol -> ");
        intSize=sc.nextInt();
        intMatrizCaracol=generarMatrizCaracol(intSize);
        voidPrintSquare(intMatrizCaracol,intSize);

        // TODO code application logic here
    }
    
    public static void voidPrintSquare(int [][] intMatrizCaracol, int size)
    {
        for(int i=1;i<=size;i++)
        {
                for(int j=1;j<=size;j++)
                {
                        System.out.print(intMatrizCaracol[i][j]);
                        if (j!=size) System.out.print("\t");
                }
                System.out.print("\n");
        }
        
    }
   public static int[][] generarMatrizCaracol(int size) 
    {
    int intPrintNumbers=1;
    int[][] intMatriz = new int[size + 1][size + 1];
    for (int i = 1; i <= size/2; i++) 
    {
      for (int j = i; j <= size - i; j++) 
      {
         intMatriz[i][j] = intPrintNumbers;
         intPrintNumbers++;
      }
      for (int j = i; j <= size - i; j++) 
      {
         intMatriz[j][size - i + 1] = intPrintNumbers;
         intPrintNumbers++;
      }
      for (int j = size-i+1; j>= i + 1; j--) 
      {
         intMatriz[size-i+1][j] = intPrintNumbers;
         intPrintNumbers++;
      }
      for (int j = size-i+1;j>=i+1;j--) 
      {
         intMatriz[j][i] = intPrintNumbers;
         intPrintNumbers++;
      }
   }
   if (size % 2 ==1) 
   {
      intMatriz[size/2+1][size/2+1]= intPrintNumbers;
   }
   return intMatriz;
 }
    
}
