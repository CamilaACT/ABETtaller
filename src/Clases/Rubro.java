package Clases;

public class Rubro {
    private int tipo;//1=ingreso,2=egreso
    private int mes;//1=Enero...12=Diciembre
    private double monto;
    private String observacion;

    public Rubro(int tipo,int mes, double monto, String observacion) {
        this.tipo = tipo;
        this.mes=mes;
        this.monto = monto;
        this.observacion = observacion;
    }

    public int getMes() {
        return mes;
    }

    public int getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Rubro" +
                "\nTipo=" + tipo +"\n"+
                "Mes=" + mes +"\n"+
                "Monto=" + monto +"\n"+
                "Observacion='" + observacion + "\n";
    }
}
