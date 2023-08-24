package integracaonumerica;

import java.util.ArrayList;

class Trapezio extends Metodo{
    
    public Trapezio(ArrayList<Double> xn, ArrayList<Double> yn) {
        super(xn, yn);
    }

    public double calculo() {
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
        double b_a = xn.get(xn.size()-1) - xn.get(0);
        double x = (Math.pow(b_a * -1, 3) ) / (12 * Math.pow(getN(), 2));
        return  x * dif_segunda;
    }
}