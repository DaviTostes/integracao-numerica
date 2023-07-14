package integracaonumerica;

import java.util.ArrayList;

public class Simpson {
    private ArrayList<Double> xn;
    private ArrayList<Double> yn;
   
    public Simpson(ArrayList xn, ArrayList yn){
        this.xn = xn;
        this.yn = yn;
    }
    
    public double calculoSimpson() {
        double soma = 0;
        double h = xn.get(1) - xn.get(0);
        double resultado = 0;

        if (yn.size() % 2 == 0) {
            for (int i = 0; i < yn.size(); i++) {
                if (i == 0 || i == yn.size() - 1) {
                    soma += yn.get(i);
                } else if (i % 2 == 0) {
                    soma += yn.get(i) * 2;
                } else if (i % 2 != 0) {
                    soma += yn.get(i) * 4;
                }
            }
            resultado = soma * (h / 3);
        } else if (yn.size() % 2 != 0 && yn.size() % 3 == 0) {
            for (int i = 0; i < yn.size(); i++) {
                if (i == 0 || i == yn.size() - 1) {
                    soma += yn.get(i);
                } else if (i % 3 != 0) {
                    soma += yn.get(i) * 3;
                } else if (i % 3 == 0) {
                    soma += yn.get(i) * 2;
                }
            }
            resultado = soma * (h *  0.375);
        } else {
            return -1; // Retornar um valor inválido se o tamanho da lista de valores de f(x) não atender às condições
        }
        return resultado;
    }

    //public double ErroSimpson() {}
}