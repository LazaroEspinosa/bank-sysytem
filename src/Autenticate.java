public interface Autenticate {
    /*
    Las clases que implementen interfaces, estan obligadas a sobreescribir sus metodos.
    */
    public void setClave(String clave);
    public boolean logIn(String claveRequest);
}