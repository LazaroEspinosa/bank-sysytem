/*
ABSTRACCION: Una clase abstracta se declara despues del modificador de acceso.
Sirve para declarar una clase padre como plantilla, por ejemplo: un vendedor y un gerente son empleados;
por lo tanto, empleado seria la clase abstracta, mientras que gerente y vendedor serian clases que heredan (extienden) de ella.
Las clases abstractas no pueden ser instanciadas, pero las clases hijas si.
Las clases abstractas deben tener al menos un metodo abstracto y este debe ser sobreescrito (@override) en las clases hijas.
Esto es para que valga la pena la intencion de crear una clase abstracta. Cada metodo abstracto sera sobreescrito.
 */
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
