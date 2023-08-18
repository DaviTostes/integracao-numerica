package integracaonumerica;

import java.util.ArrayList;

public class UmTercoSimpson {  
    ArrayList<Double> xn = new ArrayList<>();
    ArrayList<Double> yn = new ArrayList<>();
    double h;

    public UmTercoSimpson(ArrayList<Double> xn, ArrayList<Double> yn) {
        this.xn = xn;
        this.yn = yn;
        this.h = (xn.get(xn.size()-1) - xn.get(0)) / (xn.size()-1);
    }
    
    public double calculoUmTercoSimpson() {
        double soma = 0;
        double h = xn.get(1) - xn.get(0);

        for (int i = 0; i < yn.size(); i++) {
            System.out.println(yn.get(i));
            if (i == 0 || i == yn.size()-1) {
                soma += yn.get(i);
            } else if (i % 2 == 0) {
                soma += yn.get(i) * 2;
            } else if (i % 2 != 0) {
                soma += yn.get(i) * 4;   
            }
        }
        return soma * (h / 3);
    }
    
    public double erro(double dif_quarta) {
       double b = xn.get(xn.size()-1) - xn.get(0);
       double n = xn.size() - 1;

       double x = (Math.pow(b , 5)) / (180 * (Math.pow(n, 4)));
       return x * dif_quarta;
    }

    public double getN() {
        return (xn.get(xn.size()-1) - xn.get(0)) / h; 
    }
}