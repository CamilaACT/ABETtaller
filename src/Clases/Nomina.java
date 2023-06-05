package Clases;

import java.util.ArrayList;
import java.util.List;

public class Nomina {
    private List<Empleado> empleados;
    public Nomina() {
        this.empleados =new ArrayList<Empleado>();
    }

    public boolean addEmpleado(Empleado ep){
        if(busquedaEmpleado(ep.getCedula())==null){
            empleados.add(ep);
            return true;
        }else{
            return false;
        }
    }
    public Empleado busquedaEmpleado(String cedula){
        for (Empleado empleado1 : empleados) {
            if(empleado1.getCedula().equals(cedula)){
                return empleado1;
            }
        }
        return null;
    }

    public boolean modificarDatos(String cedula, String nombre,String apellido,String correo,String numCuenta,double sueldo,int departamento){
        Empleado ep=busquedaEmpleado(cedula);
        if(ep!=null){
            ep.setApellido(apellido);
            ep.setNombre(nombre);
            ep.setCorreo(correo);
            ep.setNumCuenta(numCuenta);
            ep.setSueldo(sueldo);
            ep.setDepartamento(departamento);
            return true;
        }
        return false;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Empleado> busquedaEmpleadosPorDepartamento(int departamento){
        List<Empleado> empleadoslocal =new ArrayList<Empleado>();
        for (Empleado empleado1 : empleados) {
            if(empleado1.getDepartamento()==departamento){
                empleadoslocal.add(empleado1);
            }
        }
        return empleadoslocal;
    }

    public String imprimirNominaporMes(int mes) {
        String texto="";
        for (Empleado empleado1 : empleados) {
            texto=texto+empleado1.ImprimirNominaPorMes(mes);
        }
        return texto;
    }
    @Override
    public String toString() {
        return "Nomina{" +
                "empleados=" + empleados +
                '}';
    }
}
