package com.banksystem.modelo;

public class CuentaGold extends Cuenta{

    //ATRIBUTOS
    
    private String clave;

    //CONSTRUCTOR
    /*
    El constructor de la clase hija es obligatorio porque:
    La clase padre tiene un constructor que no es vacio.
    El constructor requiere parametros.
    Ahora, como vamos a acceder a los atributos de la clase padre desde la clase hija?
    Con el metodo super(), En conjunto con el constructor, esto puede llamar al metodo padre y proceder con su requerimiento.
    */

    public CuentaGold(String cuentaId, String clienteId) {
        super(cuentaId, clienteId);
    }

    //METODOS
    /*
    El metodo comprar es sobreescrito porque es un metodo abstracto en la clase padre.
    Los metodos setClave y logIn son sobreescritos porque son metodos de la interface com.banksystem.modelo.Autenticate.
    La interface com.banksystem.modelo.Autenticate se implementa en la clase cuenta padre, que al ser abstracta no necesita sobreescribir los metodos de la interface;
    Pero sus clases hijas si.
    */
    @Override
    public void comprar(double valor) {
        if(retirar(valor)){
            depositar(valor*0.05);
            System.out.println("Compra realizada");
        }else{
            System.out.println("Compra interrumpida.");
        }
    }

    @Override
    public void setClave(String clave){
        this.clave=clave;
    }

    @Override
    /*
    Se agrega un if que verifica si la cuenta del usuario esta bloqueada o no.
    Si la condicion es correcta, se lanza una exception del tipo previamente creado (com.banksystem.modelo.CuentaBloqueadaException).
    Se puede delegar la exception a los metodos posteriores o tratarla ahi mismo.
    Se elige la segunda opcion y se encierra el if dentro de un try-catch.
    Si la cuenta efectivamente esta bloqueada(O cualquier otro criterio que sabemos que lanzara una exception), el metodo retorna false desde el catch.
    De lo contrario, el codigo sigue y verifica si el password ingresado es el mismo al guardado en la cuenta.
    */
    public boolean logIn(String claveRequest){
        try{
            if(getCuentaBloqueada()){
                throw new CuentaBloqueadaException("com.banksystem.modelo.Cuenta bloqueada");
            }
        }catch (CuentaBloqueadaException cbe){
            System.out.println(cbe.getMessage());
            return false;
        }
        if(claveRequest.equals(this.clave)){
            System.out.println("Login Exitoso");
            return true;
        }else{
            System.out.println("Password Incorrecta");
            return false;
        }
    }
}
