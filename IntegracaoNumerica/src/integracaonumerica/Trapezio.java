package integracaonumerica;

import java.util.ArrayList;

class Trapezio {
    ArrayList<Double> xn = new ArrayList<>();
    ArrayList<Double> yn = new ArrayList<>();
    double h;

    public Trapezio(ArrayList<Double> xn, ArrayList<Double> yn) {
        this.xn = xn;
        this.yn = yn;
        this.h = xn.get(1) - xn.get(0);
    }
    
    public double calculoTrapezio() {
        double soma = 0;
        
        for(int i = 0; i < yn.size(); i++){
            if(i == 0 || i == yn.size()-1) {
                soma += yn.get(i);
            } else {
                soma += yn.get(i) * 2;
            }
        }
        double resultado = soma * (h / 2);
        return resultado;
    }
    
    public double erro(double dif_segunda) {
        double b = xn.get(xn.size()-1) - xn.get(0);
        double x = (Math.pow(b * -1, 3) ) / (12 * Math.pow(getN(), 2));
        return  x * dif_segunda;
    }
    
    public double getN() {
        double a = xn.get(0);
        double b = xn.get(xn.size()-1);
        double n = (b - a) / h;
        return n;
    }
}