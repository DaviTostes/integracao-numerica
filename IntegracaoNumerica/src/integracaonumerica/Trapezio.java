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
        return soma * (h / 2);
    }
    
    public double erro(double dif_segunda) {
        return (Math.pow(h*(-1), 3) / 12) * dif_segunda;
    }
    
    public double getN() {
        return xn.size();
    }
}
