/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author andre
 */
public class Prueba 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
               int n=0;
        int m=1;
        int k=1;
        /*System.out.println("Ingrese un numero entero -> ");
        System.out.println();*/// TODO code application logic here
        Scanner sc=new Scanner(System.in);//Importar la librería pd:Luci Te Amo
        System.out.printf("\nIngrese un numero para imprimir la serie -> ");
        n=sc.nextInt();
        
        for(int i=1; i<=n;i++)
        {
            System.out.printf(" %d^3 = ",i);
            for(int j=1;j<=m;j++)
            { 
                
                System.out.printf(" +%d ",k);
                
                 k+=2;
            }
            System.out.println();
            m++;

           
        }
        
    }
    
}
