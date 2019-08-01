
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package proyecto.simulador.de.creditos;
import java.util.*;

import java.util.Scanner;

import java.io.IOException;

/**
 *
 * @author andrew(Sugar Daddy), Sahian(27years), Monica(enana)
 */
public class ProyectoSimulador {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    voidPresentacion();
    float floatSalaryValidated;
    float floatMoneyDebts;
    String stringID;
    String stringName;
    int intOption;
    do {
      voidJobMenu();
      intOption = sc.nextInt();
      switch (intOption) {
      case 1: {
        System.out.println("Usted es un trabajador publico");
        stringID = stringID();
        stringName = stringName();
        floatSalaryValidated = floatSalario();
        floatMoneyDebts = floatDeudas();
        voidSelectionCreditPP(stringID, stringName, floatSalaryValidated, floatMoneyDebts);
      }

        break;

      case 2:

        System.out.println("Usted es un trabajador privado");
        stringID = stringID();
        stringName = stringName();
        floatSalaryValidated = floatSalario();
        floatMoneyDebts = floatDeudas();
        voidSelectionCreditPP(stringID, stringName, floatSalaryValidated, floatMoneyDebts);
        break;

      case 3:
        System.out.println("Usted es un emprendor");
        stringID = stringID();
        stringName = stringName();
        floatSalaryValidated = floatSalario();
        floatMoneyDebts = floatDeudas();
        voidSelectionCreditE(stringID, stringName, floatSalaryValidated, floatMoneyDebts);
        break;

      default:
        System.out.printf("\nElija opciones entre 1 y 4\n");
      }
    } while (intOption != 4);

  }

  public static void voidPresentacion() {
    System.out.println();
    System.out.println("UNIVERSIDAD DE LAS FUERZAS ARMADAS");
    System.out.println("              ESPE           ");
    System.out.println("    PROYECTO CLUB DE SOFTWARE");
    System.out.println("");
    System.out.println("");
    System.out.println("     SIMULADOR DE CREDITOS");
    System.out.println("");
    System.out.println("INTEGRANTES:    ");
    System.out.println("* ANDRES ESTRADA");
    System.out.println("* MONICA JANA");
    System.out.println("* SAHIAN ABADIANO");
    System.out.println(" ");
    System.out.println("INSTRUCTORES DEL CURSO:");
    System.out.println("* ALEX CHICAIZA");
    System.out.println("* DAYANNA SILVA");
    System.out.println("* MIQUELY CALVOPINA");
    System.out.println("Fecha: /07/2019");
  }

  public static boolean validarCI(String cedula) {
    boolean bandera = true;
    int suma = 0;
    if (!(cedula.length() == 9)) {
      int posicionesImpares[] = new int[cedula.length() / 2];
      int posicionesPares[] = new int[(cedula.length() / 2)];
      int posicionInicialImpar = 0;
      int posicionInicialPar = 1;
      // Se agrupan las posiciones Impares
      for (int i = 0; i < cedula.length() / 2; i++) {
        posicionesImpares[i] = Integer.parseInt(String.valueOf(cedula.charAt(posicionInicialImpar)));
        posicionInicialImpar = posicionInicialImpar + 2;
        // Se agrupan las posiciones pares
        if (i < (cedula.length() / 2) - 1) {
          posicionesPares[i] = Integer.parseInt(String.valueOf(cedula.charAt(posicionInicialPar)));
          posicionInicialPar = posicionInicialPar + 2;
        }
      }
      // Se multiplica a las posiciones impares por 2
      for (int i = 0; i < posicionesImpares.length; i++) {
        posicionesImpares[i] = posicionesImpares[i] * 2;
        // en caso de que un numero sea mayor que 9 se resta 9 al numero
        if (posicionesImpares[i] > 9) {
          posicionesImpares[i] = posicionesImpares[i] - 9;
        }
        // Se suman los dígitos en posiciones pares, más los resultados de las
        // operaciones en las posiciones impares
        suma = suma + posicionesImpares[i] + posicionesPares[i];
      }
      int aux = suma / 10;
      int dec = (aux + 1) * 10;
      // Se obtiene el módulo 10 de la suma total anterio
      if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length() - 1)))) {
        bandera = true;
        // Condicion para el digito verificador
      } else if (suma % 10 == 0 && cedula.charAt(cedula.length() - 1) == '0') {
        bandera = true;
      } else {
        bandera = false;
      }
    }
    return bandera;
  }

  // Funcion para validar el ingreso del nombre que sea solo String
  public static boolean validarStringName(String palabra) {
    boolean bandera = true;
    String[] arrCadena = palabra.split(" ");
    String auxPalabra = palabra.toUpperCase();
    for (int i = 0; i < arrCadena.length; i++) {
      if (!(auxPalabra.charAt(i) >= 'A' && auxPalabra.charAt(i) <= 'Z')) {

        bandera = false;
        break;
      }
    }
    return bandera;
  }

  // Funcion para el Ingreso de la Cedula
  public static String stringID() {
    Scanner sc = new Scanner(System.in);
    String stringID;
    do {
      System.out.print("\nIngrese ID del cliente -> ");
      stringID = sc.nextLine();
      System.out.println();
      if (validarCI(stringID)) {
        System.out.println("Su cedula de identidad es " + stringID);
      } else {
        System.out.println("Verifique que la cedula haya sido ingresado correctamente");
      }
    } while (!validarCI(stringID));
    return stringID;
  }

  // Funcion para validar el ingreso del nombre del cliente
  public static String stringName() {
    Scanner sc = new Scanner(System.in);
    String stringName;

    do {
      System.out.print("\nIngrese el nombre del cliente ->");
      stringName = sc.nextLine();
      if (validarStringName(stringName)) {
        System.out.println("Su nombre es " + stringName);
      } else {
        System.out.println("Verifique que el nombre haya sido ingresado correctamente");
      }

    } while (!validarStringName(stringName));
    return stringName;
  }

  // Funcion para el ingreso del salario del usuario
  public static float floatSalario() {
    Scanner sc = new Scanner(System.in);
    float floatSalaryValidated;
    do {
      System.out.print("Ingrese el salario bruto del cliente ->");
      floatSalaryValidated = sc.nextFloat();
      if (booleanPositiveValidation(floatSalaryValidated) == true) {
        System.out.println("El salario bruto ingresado es " + floatSalaryValidated);
      } else {
        System.out.println("Ingrese un salario adecuado");
      }

    } while (booleanPositiveValidation(floatSalaryValidated) == false);
    return floatSalaryValidated;
  }

  // Funcion para ingresar el valor de la deuda del cliente
  public static float floatDeudas() {
    Scanner sc = new Scanner(System.in);

    float floatMoneyDebts;
    System.out.println();
    do {
      System.out.print("Ingrese deudas del cliente ->");
      floatMoneyDebts = sc.nextFloat();
      if (booleanPositiveValidation(floatMoneyDebts) == true) {
        System.out.println("La deuda del cliente es: " + floatMoneyDebts);
      } else {
        System.out.println("Ingrese nuevamente la deuda: ");
      }
    } while (booleanPositiveValidation(floatMoneyDebts) == false);
    return floatMoneyDebts;
  }

  // Funcion de menu para selleccionar el tipo de trabajador
  public static void voidJobMenu() {
    System.out.printf("\n\tTIPO DE TRABAJO\n");
    System.out.printf("\n1. Publico\n");
    System.out.printf("\n2. Privado\n");
    System.out.printf("\n3. Emprendedor\n");
    System.out.printf("\n4. Salir\n");
    System.out.printf("\nElija su opcion -> ");
  }

  // Funcion para validar un numero positivo
  public static boolean booleanPositiveValidation(float floatNumeroIngresado) {
    if (floatNumeroIngresado < 0) {
      return false;
    } else {
      return true;
    }

  }

  // Funcion de menu para seleccionar el tipo de credito requerido
  public static void voidMenuCredito() {

    System.out.printf("\n\tTIPO DE CREDITO\n");
    System.out.printf("\n1. Credito De Consumo\n");
    System.out.printf("\n2. Credito Hipotecario\n");
    System.out.printf("\n3. Microcredito\n");
    System.out.printf("\n4. Salir\n");
    System.out.printf("\nElija su opcion -> ");

  }

  public static void voidSelectionCreditPP(String stringID, String stringName, float floatSalaryValidated,
      float floatMoneyDebts) // Funcion para sellecionar el tipo de credito
  {
    Scanner sc = new Scanner(System.in);
    int intOptionMenuCredito;
    int intMesIngresado;
    float floatMonto;
    float floatCuotaMax;
    double doubleCuotaPagoAprox;
    do {
      voidMenuCredito();
      intOptionMenuCredito = sc.nextInt();
      switch (intOptionMenuCredito) {
      case 1:
        System.out.println("Ha escogido credito de Consumo");
        floatMonto = floatMontoCC();
        intMesIngresado = intMesIngresadoCC();
        floatCuotaMax = floatCuotaMaximaPP(floatSalaryValidated, floatMoneyDebts);
        doubleCuotaPagoAprox = doubleCuotaPagoCC(intMesIngresado, floatMonto);
        if (doubleCuotaPagoAprox > floatCuotaMax) {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual no puede obtenere un credito");
        } else {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual si puede obtener un credito");
        }
        break;
      case 2:
        System.out.println("Ha escogido credito Hipotecario");
        floatMonto = floatCreditoHipotecarioMonto();
        intMesIngresado = creditoHipotecarioMesIngresado();
        floatCuotaMax = floatCuotaMaximaPP(floatSalaryValidated, floatMoneyDebts);
        doubleCuotaPagoAprox = doubleCuotaPagoCH(intMesIngresado, floatMonto);
        if (doubleCuotaPagoAprox > floatCuotaMax) {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual no puede obtener un credito");
        } else {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual si puede obtener un credito");
        }
        break;
      case 3:
        System.out.println("Ha escogido Micro - Credito");
        floatMonto = floatmicroCreditoMonto();
        intMesIngresado = microCreditoMes();
        floatCuotaMax = floatCuotaMaximaPP(floatSalaryValidated, floatMoneyDebts);
        doubleCuotaPagoAprox = doubleCuotaPagoMC(intMesIngresado, floatMonto);
        if (doubleCuotaPagoAprox > floatCuotaMax) {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual no puede obtenere un credito");
        } else {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual si puede obtener un credito");
        }
        break;
      default:
        System.out.printf("\nElija opciones entre 1 y 3\n");
      }

    } while (intOptionMenuCredito != 4);

  }

  // Funcion para el tipo de credito e informacion respecto a generar un credito
  public static void voidSelectionCreditE(String stringID, String stringName, float floatSalaryValidated,
      float floatMoneyDebts) {

    Scanner sc = new Scanner(System.in);
    int intOptionMenuCredito;
    int intMesIngresado;
    float floatMonto;
    float floatCuotaMax;
    double doubleCuotaPagoAprox;
    do {
      voidMenuCredito();
      intOptionMenuCredito = sc.nextInt();
      switch (intOptionMenuCredito) {
      case 1:
        floatMonto = floatMontoCC();
        intMesIngresado = intMesIngresadoCC();
        floatCuotaMax = floatCuotaMaximaE(floatSalaryValidated, floatMoneyDebts);
        doubleCuotaPagoAprox = doubleCuotaPagoCC(intMesIngresado, floatMonto);
        if (doubleCuotaPagoAprox > floatCuotaMax) {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual no puede obtenere un credito");
        } else {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual si puede obtener un credito");
        }
        break;
      case 2:
        floatMonto = floatCreditoHipotecarioMonto();
        intMesIngresado = creditoHipotecarioMesIngresado();
        floatCuotaMax = floatCuotaMaximaE(floatSalaryValidated, floatMoneyDebts);
        doubleCuotaPagoAprox = doubleCuotaPagoCH(intMesIngresado, floatMonto);
        if (doubleCuotaPagoAprox > floatCuotaMax) {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual no puede obtenere un credito");
        } else {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual si puede obtener un credito");
        }
        break;
      case 3:
        floatMonto = floatmicroCreditoMonto();
        intMesIngresado = microCreditoMes();
        floatCuotaMax = floatCuotaMaximaE(floatSalaryValidated, floatMoneyDebts);
        doubleCuotaPagoAprox = doubleCuotaPagoMC(intMesIngresado, floatMonto);
        if (doubleCuotaPagoAprox > floatCuotaMax) {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual no puede obtenere un credito");
        } else {
          System.out.println("El cliente " + stringName + " con cedula de identidad " + stringID);
          System.out.println("Con un salario de " + floatSalaryValidated + " Que solicita un monto de " + floatMonto);
          System.out.println("A un numero de meses " + intMesIngresado);
          System.out.println("Posee una cuota de pago aproximado de " + doubleCuotaPagoAprox
              + " con una cuota maxima de " + floatCuotaMax);
          System.out.println("Por lo cual si puede obtener un credito");
        }
        break;
      default:
        System.out.printf("\nElija opciones entre 1 y 3\n");
      }

    } while (intOptionMenuCredito != 4);
  }

  // Funcion para ingresar el plazo de tiempo que requiere para su crédito de
  // consumo
  public static int intMesIngresadoCC() {
    Scanner sc = new Scanner(System.in);
    int intMesIngresado;
    do {
      System.out
          .print("\nIngrese el numero de meses al cual necesita su credito, considerando que es de 3 a 36 meses -> ");
      intMesIngresado = sc.nextInt();
      if (intMesIngresado >= 3 && intMesIngresado <= 36) {
        System.out.print("El plazo al cual necesita su credito es: " + intMesIngresado);
      } else {
        System.out.print("\nIngrese el numero de meses entre un rango de 3 a 36");
      }
    } while (intMesIngresado < 3 || intMesIngresado > 36);
    return intMesIngresado;
  }

  // Funcion para ingresar el monto que necesita para su credito de consumo
  public static float floatMontoCC() {

    Scanner sc = new Scanner(System.in);
    float floatMonto;
    do {
      System.out.print("\nIngrese el monto que sea entre 500 a 10000 -> ");
      floatMonto = sc.nextFloat();
      if (floatMonto >= 500 && floatMonto <= 10000) {
        System.out.print("El credito que usted necesita es: " + floatMonto);
      } else {
        System.out.print("\nIngrese un monto entre 500 y 10000");
      }
    } while (floatMonto < 500 || floatMonto > 10000);
    return floatMonto;
  }

  // Funcion para ingresar el plazo de timpo que requiere para su microcredito
  public static int microCreditoMes() {
    Scanner sc = new Scanner(System.in);
    int plazoCredito;
    do {
      System.out.println(" Ingrese el plazo de su credito en meses: ");
      plazoCredito = sc.nextInt();
      if (plazoCredito >= 3 && plazoCredito <= 36) {
        System.out.println("El plazo al cual necesita su credito es: " + plazoCredito);
      } else {
        System.out.println("Ingrese el numero de meses entre un rango de 3 a 36");
      }
    } while (plazoCredito < 3 || plazoCredito > 36);
    return plazoCredito;
  }

  // Funcion para ingresar el monto del Micro -credito
  public static float floatmicroCreditoMonto() {
    Scanner sc = new Scanner(System.in);
    float montoCredito;
    do {
      System.out.println(" Ingrese el monto de su credito:  ");
      montoCredito = sc.nextFloat();
      if (montoCredito >= 500 && montoCredito <= 5000) {
        System.out.println("El plazo al cual necesita su credito es: " + montoCredito);
      } else {
        System.out.println("Ingrese el numero de meses entre un rango de 3 a 36");
      }
    } while (montoCredito < 500 || montoCredito > 5000);
    return montoCredito;
  }

  // Funcion para ingresar el plazo de tiempo que requiere para su credito
  // hipotecario
  public static int creditoHipotecarioMesIngresado() {
    Scanner sc = new Scanner(System.in);
    int mesIngresado;
    do {
      System.out.println("Ingrese el plazo de su credito en meses");
      mesIngresado = sc.nextInt();
      if (mesIngresado >= 120 && mesIngresado <= 240) {
        System.out.print("El plazo al cual necesita su credito es: " + mesIngresado);
      } else {
        System.out.println("Ingrese el numero de meses entre 120 y 240");
      }
    } while (mesIngresado < 120 || mesIngresado > 240);
    return mesIngresado;
  }

  // Funcion para Ingresar el monto del credito Hipotecario
  public static float floatCreditoHipotecarioMonto() {
    Scanner sc = new Scanner(System.in);
    float floatMonto;
    do {
      System.out.print("Ingrese el monto entre 20000 y 90000");
      floatMonto = sc.nextFloat();
      if (floatMonto >= 20000 && floatMonto <= 90000) {
        System.out.println("El Monto el cual desea es: " + floatMonto);
      }
    } while (floatMonto < 20000 || floatMonto > 90000);
    return floatMonto;
  }

  public static float floatCuotaMaximaPP(float floatSalaryValidated, float floatDebts)// Funcion de cuota maxima para
                                                                                      // trabajadores publicos y
                                                                                      // privados
  {
    float floatIngresoNeto;
    float floatCuota;
    floatIngresoNeto = ((floatSalaryValidated) - ((99 * floatSalaryValidated) / 1000));
    floatCuota = (((40 * floatIngresoNeto) / 100) - (floatDebts));
    return floatCuota;
  }

  public static float floatCuotaMaximaE(float floatSalaryValidated, float floatDebts)// Funcion de cuota maxima para
                                                                                     // emprendedores
  {
    float floatIngresoNeto;
    float floatCuota;
    floatIngresoNeto = ((floatSalaryValidated) - ((15 * floatSalaryValidated) / 100));
    floatCuota = (((40 * floatIngresoNeto) / 100) - (floatDebts));
    return floatCuota;
  }

  public static double doubleCuotaPagoCC(int intMesIngresado, float floatMonto) {// Funcion para Calcular el Credito de
    // Consumo
    double montoFinal;
    double interesCredito = (16 / 100);
    montoFinal = floatMonto * (Math.pow((1 + interesCredito), intMesIngresado));
    return montoFinal;
  }

  // Funcion para calcular el capital final de un micro credito
  public static double doubleCuotaPagoMC(int plazoCredito, float montoCredito) {
    double capitalFinal;
    double tasaInteresCredito = (25 / 100);
    capitalFinal = montoCredito * (Math.pow((1 + tasaInteresCredito), plazoCredito));
    return capitalFinal;
  }

  // Funcion para calcular el capital final de un credito hipotecario
  public static double doubleCuotaPagoCH(int mesIngresado, float montoCredito) {
    double montoFinal;
    float interesCredito = (9 / 100);
    montoFinal = montoCredito * (Math.pow((1 + interesCredito), mesIngresado));
    return montoFinal;
  }

}