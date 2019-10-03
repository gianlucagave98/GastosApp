package com.ggave.gastosapp.models;

public class Operation {
    private String fecha;
    private double monto;
    private String cuenta;
    private String operacion;

    public Operation() {
    }

    public Operation(String fecha, double monto, String cuenta, String operacion) {
        this.fecha = fecha;
        this.monto = monto;
        this.cuenta = cuenta;
        this.operacion = operacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "fecha='" + fecha + '\'' +
                ", monto=" + monto +
                ", cuenta='" + cuenta + '\'' +
                ", operacion='" + operacion + '\'' +
                '}';
    }
}
