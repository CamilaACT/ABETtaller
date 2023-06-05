package Clases;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre,apellido,cedula,correo,numCuenta,codigo;;
    private boolean status;
    private double sueldo,aporteSeguro,impuesto;
    private int departamento;

    private static int contador=0;
    private SueldoNeto sueldosEmpleado;


    public Empleado(String nombre, String apellido, String cedula, String correo, String numCuenta,double sueldo,int departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.numCuenta = numCuenta;
        this.sueldo=sueldo;
        this.aporteSeguro= sueldo*0.0935;
        this.impuesto=calcularImpuesto(sueldo);
        this.departamento=departamento;
        this.sueldosEmpleado=new SueldoNeto();
        codigo="E-00"+contador;
        contador++;
    }
    private double calcularImpuesto(double sueldo) {
        if (sueldo <= 5000) {
            return 0;
        } else if (sueldo <= 10000) {
            return (sueldo - 5000) * 0.10;
        } else if (sueldo <= 18000) {
            return (sueldo - 10000) * 0.20;
        } else {
            return (sueldo - 18000) * 0.30;
        }
    }



    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getDepartamento() {
        return departamento;
    }
    public double sueldoPorMes(int mes){
        return sueldo+(sueldosEmpleado.rubroPorMes(mes))-impuesto-aporteSeguro;
    }

    public SueldoNeto getSueldosEmpleado() {
        return sueldosEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }
    public String ImprimirNominaPorMes(int mes) {
        return "\n --EMPLEADO--" +
                "\nNombre=" + nombre + "\n" +
                "Apellido=" + apellido + "\n" +
                "Cedula=" + cedula + "\n" +
                "Correo=" + correo + "\n" +
                "Número de Cuenta=" + numCuenta + "\n" +
                "Sueldo=" + sueldo +"\n"+
                "Aporte Seguro=" + aporteSeguro +"\n"+
                "Impuesto=" + impuesto +"\n"+
                "Departamento=" + departamento +"\n"+
                "Sueldo por mes="+sueldoPorMes(mes)+"\n"+
                "Rubros por mes="+ sueldosEmpleado.toString();

    }

    @Override
    public String toString() {
        return "\n --EMPLEADO--" +
                "\nNombre=" + nombre + "\n" +
                "Apellido=" + apellido + "\n" +
                "Cedula=" + cedula + "\n" +
                "Correo=" + correo + "\n" +
                "Número de Cuenta=" + numCuenta + "\n" +
                "Sueldo=" + sueldo +"\n"+
                "Aporte Seguro=" + aporteSeguro +"\n"+
                "Impuesto=" + impuesto +"\n"+
                "Departamento=" + departamento +"\n";
    }
}
