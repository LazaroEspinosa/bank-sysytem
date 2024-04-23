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

    public String userStringInput(){
        Scanner localScanner=new Scanner(System.in);
        String userOption=localScanner.nextLine();
        return userOption;
    }
}
