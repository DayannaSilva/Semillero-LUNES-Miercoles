/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.game;

import java.util.Scanner;

/**
 *
 * @author andrewhacks
 */
public class GAME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String stringData; 
       int [] intCards= new int [3];
       int [] intCards_2=new int [3];
       int [] intCards_3=new int [3];
       int [] intSumaCards = new int [3];

       
       Scanner Deck = new Scanner(System.in);
       do
       {
       System.out.print("\nIngrese 3 cartas separadas por el simbolo % por ejemplo a%b%c -> ");
       stringData=Deck.nextLine(); 
       if(stringValidation(stringData)==true)
       {
           System.out.println("Las cartas ingresadas son: "+stringData);
           
       }
       else
           System.out.println("Ingrese en el formato correcto a%b%c ");

       }while(!(stringValidation(stringData)) || !(validationCard(stringData)));
       intCards=TransformarVector(stringData, intCards);
       intCards_3=arrayOrdenado(intCards);
       intCards_2=TransformJQK(intCards_3);
       int [] intSumaCards_2= new int [3];
       intSumaCards_2 = arraySumaCard(intCards_3);
       intSumaCards=TransformJQK(intSumaCards_2);
       voidGameFinished(intCards_2,intSumaCards);
        
        
    
                    
        // TODO code application logic here
    }

 public static boolean stringValidation(String stringData)
 {
     int size=stringData.length();
     if((size>=0&&size<=5)&&(stringData.charAt(1)=='%'&&stringData.charAt(3)=='%'))
     {
         return true;
     }
     else
         return false;
 }
 public static int [] TransformJQK(int [] arrayCards)
 {
  
     for(int i=0; i<3;i++)
     {
         if(arrayCards[i]==8)
         {
             arrayCards[i]='j';
         }
             if(arrayCards[i]==9)
         {
             arrayCards[i]='q';
         }
             if(arrayCards[i]==10)
         {
             arrayCards[i]='k';
         }
     }
     return arrayCards;
     
 }
 public static boolean validationCard(String stringCard)
 {
     boolean flag=true;
     stringCard=stringCard.toUpperCase();
     String [] arrCards=stringCard.split("%");
     for(int i=0;i<arrCards.length;i++)
     {
         if(!(((arrCards[i].charAt(0)>='2'&&arrCards[i].charAt(0)<='7') || arrCards[i].charAt(0)=='A' || arrCards[i].charAt(0)=='J') || arrCards[i].charAt(0)=='Q' || arrCards[i].charAt(0)=='K'))
         {
             flag=false;
             break;
         }
             
     }
     return flag;
 }
 public static int [] TransformarVector(String stringCard,  int arrayCards[])
 {
    stringCard=stringCard.toUpperCase();
    String [ ] stringCards = stringCard.split("%");

    for(int i=0; i<=stringCards.length-1;i++)
    {
        if(stringCards[i].charAt(0)=='A')
        {
            arrayCards[i]=1;
        }
        else
            if(stringCards[i].charAt(0)=='J')
            {
                arrayCards[i]=8;
            }            
            else
                if(stringCards[i].charAt(0)=='Q')
                {
                    arrayCards[i]=9;
                }
                else
                    if(stringCards[i].charAt(0)=='K')
                    {
                        arrayCards[i]=10;    
                    }
                    else
                        arrayCards[i]=Integer.parseInt(stringCards[i]);      
    }
    return arrayCards; 
    

    
 }
 
 public static void printCards( int arrayCards[])
 {
    System.out.println("Las cartas en valor numerico");
    for(int i=0; i<=arrayCards.length-1;i++)
    {
        System.out.println(arrayCards[i]);
    }
     System.out.println("");
 }
 
 public static int [] arrayOrdenado( int arrayCards[])
 {
     int aux=0;
     for(int i=0; i<arrayCards.length-1;i++)
     {
         for(int j=0; j<arrayCards.length-i-1; j++)
         {
             if(arrayCards[j+1]<arrayCards[j])
             {
                 aux=arrayCards[j+1];
                 arrayCards[j+1]=arrayCards[j];
                 arrayCards[j]=aux;
             }
         }
             
     }
     return arrayCards;
     
 }
 
 public static int [] arraySumaCard(int [] arrayCards_2 )
 {
     int [] intSuma=new int[3];
    intSuma[0]=arrayCards_2[0]+arrayCards_2[1];
    intSuma[1]=arrayCards_2[1]+arrayCards_2[2];
    intSuma[2]=arrayCards_2[0]+arrayCards_2[2];

    return intSuma;


 }
 public static void voidGameFinished(int [] intCards_2,int [] intSumaCards)
 {
     if(intCards_2[0]==intCards_2[1] && intCards_2[1]==intCards_2[2])
        {
            System.out.println("Ronda");
        }
        else
            if(intCards_2[0]==intCards_2[1])
            {
                                
                if((intCards_2[0]== 7 && intCards_2[2]=='j') || (intCards_2[0]== 'j' && intCards_2[2]=='q') || (intCards_2[0]== 'q' && intCards_2[2]=='k'))
                {
                    System.out.println("Limpia");
                }
                else
                    
                if(intCards_2[0]+1 == intCards_2[2])
                {
                    System.out.println("Limpia");
                }
                else
                {
                    System.out.println("Queda una carta en la mesa");
                }                    

            }
            else
                if(intCards_2[1]==intCards_2[2])
                {
                if((intCards_2[1]== 7 && intCards_2[0]=='j') || (intCards_2[1]== 'j' && intCards_2[0]=='q') || (intCards_2[1]== 'q' && intCards_2[0]=='k'))
                {
                    System.out.println("Limpia");
                }
                else                    
                    if(intCards_2[1]+1 == intCards_2[0])
                    {
                        System.out.println("Limpia");
                    }
                    else
                    {
                    System.out.println("Queda una carta en la mesa");
                    }  
                }
                else
                if(intCards_2[0]==intCards_2[2])
                {
                if((intCards_2[0]== 7 && intCards_2[1]=='j') || (intCards_2[0]== 'j' && intCards_2[1]=='q') || (intCards_2[0]== 'q' && intCards_2[1]=='k'))
                {
                    System.out.println("Limpia");
                }
                else                    
                    if(intCards_2[0]+1 == intCards_2[1])
                    {
                        System.out.println("Limpia");
                    }
                    else
                    {
                    System.out.println("Queda una carta en la mesa");
                    }  
                }
                else
                    if(intCards_2[2]==intSumaCards[0])
                    {
                        System.out.println("Limpia");
                    }
                    else
                         if(intCards_2[0]==intSumaCards[1])
                         {
                             System.out.println("Limpia");
                         }
                         else
                             if(intCards_2[1]==intSumaCards[2])
                             {
                                 System.out.println("Limpia");
                             }
                             else
                                 System.out.println("No hay juego");
 }

    
}

