package integracaonumerica;

import java.util.ArrayList;

public class UmTercoSimpson extends Metodo { 
    
    public UmTercoSimpson(ArrayList<Double> xn, ArrayList<Double> yn) {
        super(xn, yn);
    }

    public double calculo() {
        double soma = 0;
        double h = xn.get(1) - xn.get(0);

        for (int i = 0; i < yn.size(); i++) {
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
       double b_a = xn.get(xn.size()-1) - xn.get(0);
       double n = xn.size() - 1;

       double x = (Math.pow(b_a, 5)) / (180 * (Math.pow(n, 4)));
       return x * dif_quarta;
    }
}