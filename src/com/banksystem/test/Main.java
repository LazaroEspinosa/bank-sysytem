package com.banksystem.test;

import com.banksystem.modelo.Agente;
import com.banksystem.modelo.Contabilidad;
import com.banksystem.modelo.Cuenta;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Contabilidad contabilidad = new Contabilidad();
        Cuenta cuentaTest;
        Agente agenteTest=new Agente("24680");
        boolean systemOn=true;
        int userIntOption;

        while(systemOn){
            System.out.println("Sistema principal, Elige tu tipo de usuario:");
            System.out.println("1. com.banksystem.modelo.Cliente.");
            System.out.println("2. com.banksystem.modelo.Empleado.");
            System.out.println("3. Administrador.");
            System.out.println("0. Cerrar sistema.");
            userIntOption= userDoubleInput();
            switch (userIntOption){
                case 1:
                    System.out.println("Ingrese su numero de cuenta: ");
                    cuentaTest=contabilidad.consultaDeCuenta(userStringInput());
                    if (cuentaTest!=null){
                        System.out.println("Ingrese su password: ");
                        if (cuentaTest.logIn(userStringInput())){
                            sistemaCliente(cuentaTest);
                        }
                    }
                    break;
                case 2:
                    sistemaEmpleado(agenteTest);
                    break;
                case 0:
                    systemOn=false;
                    break;
                default:
                    System.out.println("Opcion no reconocida.");
            }
        }
    }

    public static int userDoubleInput(){
        Scanner localScanner=new Scanner(System.in);
        int userOption=localScanner.nextInt();
        return userOption;
    }

    public static String userStringInput(){
        Scanner localScanner=new Scanner(System.in);
        String userOption=localScanner.nextLine();
        return userOption;
    }

    public static void sistemaCliente(Cuenta cuenta){
        boolean systemOn=true;
        int userOption;

        while(systemOn){
        System.out.println("******BIENVENIDO CLIENTE******");
        System.out.println("Seleccione su operacion");
        System.out.println("1. Deposito.");
        System.out.println("2. Transferencia.");
        System.out.println("3. Compra");
        System.out.println("4. Retiro.");
        System.out.println("5. Consultar saldo.");
        System.out.println("0. Salir.");
        userOption= userDoubleInput();

            switch (userOption){
                case 1:
                    System.out.println("Ingrese la cantidad de su deposito: ");
                    cuenta.depositar(userDoubleInput());
                    break;
                case 2:
                    System.out.println("Ingrese el numero de cuenta destinatario: ");
                    String cuentaDestinatario=userStringInput();
                    System.out.println("Ingrese el monto a transferir: ");
                    double montoATransferir=userDoubleInput();
                    cuenta.transferir(cuentaDestinatario,montoATransferir);
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de su compra: ");
                    cuenta.comprar(userDoubleInput());
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de su retiro: ");
                    cuenta.retirar(userDoubleInput());
                    break;
                case 5:
                    System.out.println("Su saldo es: "+cuenta.getSaldo());
                    break;
                case 0:
                    System.out.println("Cerrando sistema");
                    systemOn=false;
                    break;
                default:
                    System.out.println("Opcion no reconocida.");
            }
        }
    }
    public static void sistemaEmpleado(Agente agente){
        boolean systemOn=true;
        int userOption;

        while(systemOn){
            String clienteId;
            String cuentaId;
            System.out.println("******BIENVENIDO com.banksystem.modelo.Empleado******");
            System.out.println("Seleccione su operacion");
            System.out.println("1. Crear cuenta.");
            System.out.println("2. Bloquear cuenta");
            System.out.println("0. Salir.");
            userOption= userDoubleInput();

            switch (userOption){
                case 1:
                    System.out.println("Ingrese el Id de su cliente: ");
                    clienteId=userStringInput();
                    System.out.println("Ingrese el numero de cuenta: ");
                    cuentaId=userStringInput();
                    agente.crearCuenta(cuentaId, clienteId);
                    break;
                case 2:
                    System.out.println("Ingrese el numero de cuenta: ");
                    cuentaId=userStringInput();
                    agente.bloquearCuentaSiNo(cuentaId);
                    break;
                case 0:
                    System.out.println("Cerrando sistema");
                    systemOn=false;
                    break;
                default:
                    System.out.println("Opcion no reconocida.");
            }
        }
    }
    public void sistemaAdministrador(){}
}