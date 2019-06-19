/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numero_del_ministro;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Numero_del_Ministro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String Rango_inicial; 
       Scanner Rango = new Scanner(System.in);
       System.out.printf("\nIngrese el rango -> ");
       Rango_inicial=Rango.nextLine();
       System.out.println("");
       System.out.println("Los numeros en el rango "+Rango_inicial+" son:");
       String [ ] Rango_Entero = Rango_inicial.split("%");
       int inicio=Integer.parseInt(Rango_Entero[0]);
       int fin=Integer.parseInt(Rango_Entero[1]);
       
       boolean esPrimo;
       boolean flag = true;
        
       for(int i=inicio; i<=fin;i++)
       {
           System.out.printf(" %d ", i);
           
       }
       System.out.printf("\n");
       System.out.printf("\nLos numeros primos de %d a %d es:\n",inicio,fin);
       for(int i = inicio;i <= fin;i++)
        {
              esPrimo=true;
            for(int j = 2;j < i;j++)
         {
              if(i % j == 0)
              {
                 esPrimo = false;
              }
         }
              if(esPrimo)
              {
               System.out.printf(" %d ",i);
              }
         }
        System.out.println("");
        System.out.println("");
        System.out.println("Los primos de los numeros primos son:");
       for(int i = inicio;i <= fin;i++)
        {
            esPrimo=true;
            for(int j = 2;j < i;j++)
         {
              if(i % j == 0)
              {
                 esPrimo = false;
              }
                 
         }
           if(esPrimo)
              {
               String enteroString = Integer.toString(i);
               String [ ] numero_unico = enteroString.split("");
               int numero_1=Integer.parseInt(numero_unico[0]);
               int numero_2=Integer.parseInt(numero_unico[1]);
               int suma;
               suma=numero_1+numero_2;
               if(Funcion_Primo(suma))
               {
                   System.out.printf(" %d ", i);
               }
             
              }
                
                
         }
       
      
    }
 public static boolean Funcion_Primo(int numero)
 {
  int contador = 2;
  boolean primo=true;
  while ((primo) && (contador!=numero)){
    if (numero % contador == 0)
      primo = false;
    contador++;
  }
  return primo;
  }
}
