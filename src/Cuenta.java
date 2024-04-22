public abstract class Cuenta implements Autenticate{

    //ATRIBUTOS
    private String cuentaId;
    private double saldo;
    private Cliente cliente;
    private Contabilidad contabilidad=new Contabilidad();

    //Constructor
    public Cuenta(String cuentaId, String clienteId){
        setCuentaId(cuentaId);
        this.cliente=new Cliente(clienteId);
    }

    //Getters y Setters

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    //METODOS

    public abstract void comprar(double valor);
    public void depositar(double valor){
        this.saldo+=valor;
    }

    public boolean retirar(double valor){
        if(valor>this.saldo){
            System.out.println("Retiro no completado");
            return false;
        }else{
            this.saldo-=valor;
            System.out.println("Retiro completado");
            return true;
        }
    }

    public void transferir(String cuentaId, double valor){
        Cuenta cuentaDestino=this.contabilidad.consultaDeCuenta(cuentaId);
        if(retirar(valor)){
            cuentaDestino.depositar(valor);
        }
    }
}
