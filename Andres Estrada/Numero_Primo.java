/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numero_primo;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Numero_Primo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.printf("\nIngrese un numero -> ");
        num = sc.nextInt();
        boolean flag = true;
        for (int i = num - 1; i >= 2; i--) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Es primo");
            return;
        }

        int num_up = num + 1;
        int num_dowm = num - 1;

        while (num_dowm >= 2) {
            //Comprobar que el numero de arriba es primo o no
            boolean flag_up = true;
            for (int i = num_up - 1; i >= 2; i--) {
                if (num_up % i == 0) {
                    flag_up = false;
                    break;
                }
            }

            //Comprobar que el numero de arriba es primo o no
            boolean flag_down = true;
            for (int i = num_dowm - 1; i >= 2; i--) {
                if (num_dowm % i == 0) {
                    flag_down = false;
                    break;
                }
            }
            
            if(flag_up){
                System.out.println("el numero "+num_up+" es primo");
            }
            if(flag_down){
                System.out.println("el numero "+num_dowm+" es primo");
            }
            if(flag_up || flag_down){
                break;
            }
            num_up++;
            num_dowm--;

        }

       
    }

}
