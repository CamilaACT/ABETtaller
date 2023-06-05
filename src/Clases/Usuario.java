package Clases;

public class Usuario {

    private String nombre,apellido,usuario,contrasenia,cedula;
    private static int contador=0;

    public Usuario(String cedula,String nombre, String apellido){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario=cedula;
        this.contrasenia = "contrasenia123"+contador;
        contador++;
    }




}
