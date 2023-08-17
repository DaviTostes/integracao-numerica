package integracaonumerica;

import java.util.ArrayList;

class Derivada {
    private ArrayList<Double> xn;
    private ArrayList<Double> yn;
    private double h;

    public Derivada(int subintervalos, ArrayList<Double> xn, ArrayList<Double> yn) {
        this.xn = xn;
        this.yn = yn;
        this.h = xn.get(1) - xn.get(0);
    }
    
    public double DerivadaSegunda() {
        double derivada = (yn.get(0) - (2 * yn.get(1)) + yn.get(2)) * (1 / Math.pow(h, 2));
        return derivada ;
    }
    
    public double DerivadaQuarta() {
        return (yn.get(0) - 4 * yn.get(1) + 6 * yn.get(2) - 4 * yn.get(3) + yn.get(4)) / Math.pow(h, 4);
    }
}
