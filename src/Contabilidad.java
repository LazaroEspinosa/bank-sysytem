import java.util.ArrayList;
import java.util.List;

public class Contabilidad{

    //ATRIBUTOS
    private static List<Cuenta> listaDeCuentasCreadas = new ArrayList<>();

    //METODOS
    public void registroDeCuenta(Cuenta cuenta){
        listaDeCuentasCreadas.add(cuenta);
        System.out.println("Cuenta registrada");
    }

    public Cuenta consultaDeCuenta(String cuentaId){
        for(Cuenta cuenta:listaDeCuentasCreadas){
            if(cuenta.getCuentaId().equals(cuentaId)){
                System.out.println("Cuenta Encontrada");
                return cuenta;
            }
        }
        System.out.println("Cuenta no encontrada");
        return null;
    }
}
