/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deberstring;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class DeberString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Leer_String=new Scanner(System.in);
        String frase;
        String frase_2;
        System.out.printf("\nIngrese una frase -> ");
        frase=Leer_String.nextLine();
        System.out.printf("\nSu frase es> %s",frase);
        int count=0;
        frase_2=frase.toLowerCase();
        for(int i=0;i<frase.length();i++)    
        {
            
            if(frase_2.charAt(i) != 'a'&&frase_2.charAt(i) != 'e'&&frase_2.charAt(i) != 'i'&&frase_2.charAt(i) != 'o'&&frase_2.charAt(i) != 'u')
            {
            } else {
                count++;
            }  
        
        }
        
        System.out.printf("\nLa frase: %s cuenta con %d de vocales", frase,count);
        // TODO code application logic here
    }
    
}
