package com.banksystem.modelo;

import java.util.Scanner;

public class Agente extends Empleado{

    //CONSTRUCTOR
    public Agente(String nationalId){
        super(nationalId);
    }

    //METODOS
    @Override
    public void bonus() {
        //Desarrollo de bonificacion pendiente
    }

    /*
    El empleado puede crear una cuenta, asigna el cuentaid y el clienteid
    creamos un objeto temporal tipo contabilidad.
    Creamos una cuenta con los parametros de entrada para su constructor.
    Solicitamos una password para setearla.
    registramos la cuenta convocando al metodo registroDeCuenta del objeto temporal contabilidad.
    */
    public void crearCuenta(String cuentaId, String clienteId){
        Contabilidad contabilidad = new Contabilidad();
        CuentaGold cuentaNueva = new CuentaGold(cuentaId, clienteId);
        System.out.println("Crear password: ");
        cuentaNueva.setClave(userStringInput());
        contabilidad.registroDeCuenta(cuentaNueva);
    }

    /*
    Despues de crear una excepcion en caso de que alguien haga el login de una cuenta bloqueada.
    Se crea el metodo bloquear cuenta. No es necesario cada vez que se crea un exception.
    En este caso particular si, para lograr que un agente pueda bloquear y desbloquear las cuentas de los usuarios.
    */
    public void bloquearCuentaSiNo(String cuentaId){
        Contabilidad contabilidadTemporal=new Contabilidad();
        Cuenta cuenta=contabilidadTemporal.consultaDeCuenta(cuentaId);
        if (cuenta.getCuentaBloqueada()){
            cuenta.setCuentaBloqueada(false);
            System.out.println("com.banksystem.modelo.Cuenta desbloqueada");
        }else{
            cuenta.setCuentaBloqueada(true);
            System.out.println("cuenta bloqueada");
        }
    }

    public String userStringInput(){
        Scanner localScanner=new Scanner(System.in);
        String userOption=localScanner.nextLine();
        return userOption;
    }
}
