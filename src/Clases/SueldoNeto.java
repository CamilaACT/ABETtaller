package Clases;

import java.util.ArrayList;
import java.util.List;

public class SueldoNeto {

    private List<Rubro> rubros;


    public SueldoNeto() {
        this.rubros =new ArrayList<Rubro>();
    }
    public boolean addRubro(Rubro rb){
        rubros.add(rb);
        return true;
    }
    public double rubroPorMes(int mes){
        double monto=0;
        double operacion=0;
        for (Rubro rubro1 : rubros) {
            operacion=rubro1.getMonto();
            if(rubro1.getMes()==mes){
                if(rubro1.getTipo()==1){
                    monto=monto+operacion;
                }else{
                    monto=monto-operacion;
                }
            }
        }
        return monto;
    }

    public double sueldoPorMes(double sueldo,int mes){
        double monto=rubroPorMes(mes);
        return sueldo+(monto);
    }

    @Override
    public String toString() {
        return "SueldoNeto{" +
                "rubros=" + rubros +
                '}';
    }
}
