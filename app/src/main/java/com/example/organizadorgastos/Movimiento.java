package com.example.organizadorgastos;

public class Movimiento {
    private final String concepto;
    private final String tipo;
    private final double monto;
    private final boolean esIngreso;
    private final int icono;

    public Movimiento(String concepto, String tipo, double monto, boolean esIngreso, int icono) {
        this.concepto = concepto;
        this.tipo = tipo;
        this.monto = monto;
        this.esIngreso = esIngreso;
        this.icono = icono;
    }

    public String getConcepto() {
        return concepto;
    }
    public String getTipo() {
        return tipo;
    }
    public double getMonto() {
        return monto;
    }
    public boolean esIngreso() {
        return esIngreso;
    }
    public int getIcono() {
        return icono;
    }
}