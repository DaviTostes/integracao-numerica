package integracaonumerica;

import java.util.ArrayList;

public class TresOitavosSimpson extends Metodo {

    
    public TresOitavosSimpson(ArrayList<Double> xn, ArrayList<Double> yn) {
        super(xn, yn);
    }

    public double calculo() {
        ArrayList<Double> calcs = new ArrayList<>();
        double h = xn.get(1) - xn.get(0);
      
        for (int i = 0; i < yn.size(); i++) {
            if (i == 0 || i == yn.size() - 1) {
                calcs.add(yn.get(i));
            } else if (i % 3 != 0) {
                calcs.add(yn.get(i) * 3);
            } else if (i % 3 == 0) {
                calcs.add(yn.get(i) * 2);
            }
        }
        double soma = 0;
        for(double n : calcs) {
            soma+= n;
        }
        return  ((h *  3)/8)*soma;
    }
    
    public double erro(double dif_quarta) {
        double b_a = xn.get(xn.size()-1) - xn.get(0);
        double x =  Math.pow(b_a * -1, 5) / (80 * Math.pow(getN(), 4));
        return x * dif_quarta;
    }
}
