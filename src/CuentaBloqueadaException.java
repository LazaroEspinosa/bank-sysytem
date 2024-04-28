/*
EXCEPTIONS
El control de exceptions es importante para identificar y corregir interrupciones en el flujo del codigo
Se crea una clase que extiende de Exception, siendo una checked exception.
La idea es lanzarla cuando alguien intente hacer su login e indicar su motivo.
*/

public class CuentaBloqueadaException extends Exception{
    public CuentaBloqueadaException(String message){
        super(message);
    }
}
