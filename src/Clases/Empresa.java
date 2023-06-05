package Clases;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre,direccion,ruc;
    private List<Departamento> departamentos;

    public Empresa(String nombre, String direccion, String ruc) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ruc = ruc;
        this.departamentos=new ArrayList<Departamento>();
        QuemarDatosDepartamentos();
    }

    public boolean addDepartamento(Departamento dp){
        if(busquedaDepartamento(dp.getNomdepartamento())==null){
            departamentos.add(dp);
            return true;
        }else{
            return false;
        }
    }

        public Departamento busquedaDepartamento(String nombre){
        for (Departamento departamento1 : departamentos) {
            if(departamento1.getNomdepartamento().equals(nombre)){
                return departamento1;
            }
        }
        return null;
    }

    public List<String> nombresDepartamentos(){
        List<String> nombres=new ArrayList<String>();
        for (Departamento departamento1 : departamentos) {
            nombres.add(departamento1.getNomdepartamento());
        }
        return nombres;
    }

    private void QuemarDatosDepartamentos(){
        departamentos.add(new Departamento("Finanzas","Departamento 0"));
        departamentos.add(new Departamento("Marketing","Departamento 1"));
        departamentos.add(new Departamento("Desarrollo","Departamento 2"));
    }

}
