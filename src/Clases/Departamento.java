package Clases;

public class Departamento {
    private String nomdepartamento,descripcion;
    private int codigo;
    private static int contador=0;

    public Departamento(String nomdepartamento, String descripcion) {
        this.nomdepartamento = nomdepartamento;
        this.descripcion = descripcion;
        this.codigo = contador;
        contador++;
    }

    public String getNomdepartamento() {
        return nomdepartamento;
    }
}
