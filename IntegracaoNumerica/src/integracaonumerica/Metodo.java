package integracaonumerica;

import java.util.ArrayList;

public class Metodo {
    ArrayList<Double> xn = new ArrayList<>();
    ArrayList<Double> yn = new ArrayList<>();
    double h;

    public Metodo(ArrayList<Double> xn, ArrayList<Double> yn) {
        this.xn = xn;
        this.yn = yn;
        this.h = (xn.get(xn.size()-1) - xn.get(0)) / (xn.size()-1);
    }

    public double calculo() {
        return 0;
    }

    public double erro() {
        return 0;
    }

    public double getN() {
        double a = xn.get(0);
        double b = xn.get(xn.size()-1);
        double n = (b - a) / h;
        return n;
    }
}
