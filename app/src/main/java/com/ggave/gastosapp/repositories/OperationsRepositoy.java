package com.ggave.gastosapp.repositories;

import com.ggave.gastosapp.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationsRepositoy {
    private static List<Operation> operations;

    static{
        operations = new ArrayList<>();
        operations.add(new Operation("10/04/2018", 1500, "Ahorro", "Ingreso"));
        operations.add(new Operation("10/04/2019", 2500, "Tarjeta de credito", "Ingreso"));
        operations.add(new Operation("10/04/2017", 4500, "Efectivo", "Ingreso"));
        operations.add(new Operation("10/04/2018", 1500, "Ahorro", "Ingreso"));

    }

    public static List<Operation> getOperation(String saldo) {
        List<Operation> t = new ArrayList<>();
        for(int m = 0; m < operations.size(); m++){
            if(operations.get(m).getCuenta().equals(saldo)){
                t.add(operations.get(m));
            }
        }
        return t;
    }

    public static double egresados(){
        double egresos = 0;
        for (int i = 0; i<operations.size();i++) {
            if(operations.get(i).getOperacion().equals("Egreso")) {
                double numero1 = operations.get(i).getMonto();
                egresos = egresos + numero1;
            }
        }
        return egresos;
    }

    public static void agregar(String fech, double mon, String tip_cuenta, String tip_operacion){
        operations.add( new Operation( fech, mon, tip_cuenta, tip_operacion));

    }

    public static double total(String saldo){
        double total = 0;
        double ingresos = 0;
        double egresos = 0;
        for (int i = 0; i<operations.size();i++){
            if(operations.get(i).getCuenta().equals(saldo)){
                if(operations.get(i).getOperacion().equals("Ingreso")){
                    double numero1 = operations.get(i).getMonto();
                    ingresos = ingresos + numero1;
                }else{
                    double numero2 = operations.get(i).getMonto();
                    egresos = egresos + numero2;
                }

            }
        }
        total = ingresos - egresos;
        return total;
    }

    public static double total_global(){
        double sumatoria_egresos = 0;
        double sumatoria_ingresos = 0;
        double sumatoria = 0;
        for(int m = 0; m < operations.size(); m++){
            if(operations.get(m).getOperacion().equals("Ingresos")){
                double numero1 = operations.get(m).getMonto();
                sumatoria_ingresos = sumatoria_ingresos + numero1;
            }else{
                double numero2 = operations.get(m).getMonto();
                sumatoria_egresos = sumatoria_egresos + numero2;
            }
        }
        sumatoria = (sumatoria_ingresos/(sumatoria_egresos+sumatoria_ingresos))*100;
        return sumatoria;
    }
}
