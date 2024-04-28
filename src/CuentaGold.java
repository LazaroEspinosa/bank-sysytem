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
    Los metodos setClave y logIn son sobreescritos porque son metodos de la interface Autenticate.
    La interface Autenticate se implementa en la clase cuenta padre, que al ser abstracta no necesita sobreescribir los metodos de la interface;
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
    public boolean logIn(String claveRequest){
        try{
            if(getCuentaBloqueada()){
                throw new CuentaBloqueadaException("Cuenta bloqueada");
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
