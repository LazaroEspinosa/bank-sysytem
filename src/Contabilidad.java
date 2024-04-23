import java.util.ArrayList;
import java.util.List;

public class Contabilidad{

    //ATRIBUTOS
    /*
    Un atributo de tipo collection:
    Un atributo tipo Lista que almacena objetos Cuenta llamada listaDeCuentasCreadas crea un nuevo Arraylist.
    El atributo es static, lo que quiere decir que sin importar el numero de objetos creados,
    la listaDeCuentasCreadas tendra siempre los mismos valores a menos que se agreguen o eliminen en algun metodo.
    */
    private static List<Cuenta> listaDeCuentasCreadas = new ArrayList<>();

    //METODOS
    /*
    Cuando se crea un objeto de tipo contabilidad, se crea una listaDeCuentasCreadas
    Cuando se invoca el metodo de registroDeCuenta y este recibe un objeto de tipo cuenta, este es almacenado dentro del arraylist.
    */
    public void registroDeCuenta(Cuenta cuenta){
        listaDeCuentasCreadas.add(cuenta);
        System.out.println("Cuenta registrada");
    }

    /*
    Viene la magia:
    Necesitamos un metodo que pueda recibir un String y buscar coincidencias de ese string dentro del arraylist.
    En caso de que sea verdadero, devolver el objeto (Cuenta) que coincide con el String.

    Para eso, el metodo debe ser public.
    Debe devolver un objeto tipo Cuenta.
    Lo llamaremos consulta de cuenta.
    Y el String se llamara cuentaId, ya que es un atributo que se asigna a cada cuenta creada obligatoriamente.

    Como buscar el String:
    Creamos un objeto temporal tipo Cuenta y recorremos los elementos dentro del array:
    for(Cuenta cuenta:listaDeCuentasCreadas){//Hacer algo si es True} ->> Por cada cuenta dentro de listaDeCuentasCreadas
    "cuenta" tomara la "forma" de cada objeto dentro del arraylist.

    Ahora metemos esa "cuenta" en un if para evaluarla:
    if(cuenta.getCuentaId().equals(cuentaId)){return cuenta} ->> si el cuentaId de cuenta es igual al cuentaId del String establecido, devolver el objeto cuenta.

    Que pasa si el objeto no es encontrado? Return null.
    */
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
