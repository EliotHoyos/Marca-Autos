package com.dto.marca.marca_autos;

public class CalculoFlete {

    public double calcularFlete(double precio){
        double flete;
        if(precio >= 20000){
            flete = 0.0;
        }else{
            flete = 300.00;
        }
        return flete;
    }

    public double calcularIgv(double monto){
        if(monto > 20000){
            return monto * 0.18;
        }else{
            return 0.0;
        }
    }

}
