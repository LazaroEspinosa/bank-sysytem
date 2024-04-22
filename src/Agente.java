import java.util.Scanner;

public class Agente extends Empleado{

    //CONSTRUCTOR
    public Agente(String nationalId){
        super(nationalId);
    }

    //METODOS
    @Override
    public void bonus() {

    }

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
