/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cajeroautomatico;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author XMX7578
 */
public class Movimientos {
    private int no_cuenta;
    private String fecha_registro;
    private int cantidad_registro;
    private int saldo_anterior;

    public Movimientos() {
    }

    public Movimientos(int no_cuenta, String fecha_registro, int cantidad_registro, int saldo_anterior) {
        this.no_cuenta = no_cuenta;
        this.fecha_registro = fecha_registro;
        this.cantidad_registro = cantidad_registro;
        this.saldo_anterior = saldo_anterior;
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getCantidad_registro() {
        return cantidad_registro;
    }

    public void setCantidad_registro(int cantidad_registro) {
        this.cantidad_registro = cantidad_registro;
    }

    public int getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setSaldo_anterior(int saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    @Override
    public String toString() {
        return "Movimientos{" + "no_cuenta=" + no_cuenta + ", fecha_registro=" + fecha_registro + ", cantidad_registro=" + cantidad_registro + ", saldo_anterior=" + saldo_anterior + '}';
    }
    
    
}
