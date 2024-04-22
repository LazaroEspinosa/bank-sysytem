public class CuentaGold extends Cuenta{

    private String clave;

    //CONSTRUCTOR
    public CuentaGold(String cuentaId, String clienteId) {
        super(cuentaId, clienteId);
    }

    //METODOS
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
        if(claveRequest.equals(this.clave)){
            System.out.println("Login exitoso");
            return true;
        }else{
            return false;
        }
    }
}
