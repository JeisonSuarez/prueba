/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.examenjeison.pojo;

/**
 *
 * @author JADPA18
 */
public class Nomina {
    private Empleado empleado;
    private String nombre;
    private float inss;
    private float ir;
    private int antiguedad;
    private float salarioneto;

    public Nomina(String nombre, float inss, float ir, int antiguedad, float salarioneto) {
        this.nombre=nombre;
        this.inss = inss;
        this.ir = ir;
        this.antiguedad = antiguedad;
        this.salarioneto = salarioneto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public float getIr() {
        return ir;
    }

    public void setIr(float ir) {
        this.ir = ir;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public float getSalarioneto() {
        return salarioneto;
    }

    public void setSalarioneto(float salarioneto) {
        this.salarioneto = salarioneto;
    }
    
}
