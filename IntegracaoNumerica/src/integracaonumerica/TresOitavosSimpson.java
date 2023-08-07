package integracaonumerica;

import java.util.ArrayList;

public class TresOitavosSimpson {
    ArrayList<Double> xn = new ArrayList<>();
    ArrayList<Double> yn = new ArrayList<>();
    double h;

    public TresOitavosSimpson(ArrayList<Double> xn, ArrayList<Double> yn) {
        this.xn = xn;
        this.yn = yn;
        this.h = xn.get(1) - xn.get(0);
    }
    
    public double calculoTresOitavosSimpson() {
        double soma = 0;
        double h = xn.get(1) - xn.get(0);
      
        for (int i = 0; i < yn.size(); i++) {
            if (i == 0 || i == yn.size() - 1) {
                soma += yn.get(i);
            } else if (i % 3 != 0) {
                soma += yn.get(i) * 3;
            } else if (i % 3 == 0) {
                soma += yn.get(i) * 2;
            }
        }
        return soma * (h *  3/8);
    }
    
    public double Erro(double dif_quarta) {
        return (Math.pow(h*(-1), 5) / (80 * (Math.pow(xn.size(), 4)))) * dif_quarta;
    }
}
