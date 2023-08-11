package integracaonumerica;

import java.util.ArrayList;

class Derivada {
    ArrayList<Double> xn;
    ArrayList<Double> yn;

    public Derivada(int subintervalos, ArrayList<Double> xn, ArrayList<Double> yn) {
        this.xn = xn;
        this.yn = yn;
    }
    
    public double DerivadaSegunda() {
        double h = (xn.get(1) - xn.get(0));
        return (yn.get(0) - 2 * yn.get(1) + yn.get(2)) / Math.pow(h, 2);
    }
    
    public double DerivadaQuarta() {
        double h = (xn.get(1) - xn.get(0));
        return (yn.get(0) - 4 * yn.get(1) + 6 * yn.get(2) - 4 * yn.get(3) + yn.get(4)) / Math.pow(h, 4);
    }
}
