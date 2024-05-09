package com.banksystem.modelo;

public abstract class Empleado {

    //ATRIBUTOS

    private String name;
    private String empleadoId;
    private String nationalId;
    private double salario;

    //CONSTRUCTORES
    public Empleado(String nationalId){
        this.nationalId = nationalId;
    }

    //GETTERS Y SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //METODOS
    public abstract void bonus();
}
