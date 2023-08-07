package integracaonumerica;

import java.util.ArrayList;

class Derivada {    
    public double DerivadaQuarta(ArrayList<Double> xn, ArrayList<Double> yn) {
        // Verificar se existem pelo menos cinco pontos para calcular a derivada quarta
        if (xn.size() < 5 || yn.size() < 5) {
            throw new IllegalArgumentException("Pelo menos cinco pontos são necessários para calcular a derivada quarta usando o método de diferenciação centrada de três pontos.");
        }
        
        double h = xn.get(1) - xn.get(0); // Intervalo entre os pontos (assumindo que os pontos são equidistantes)
        
        // Calcular a derivada quarta usando a fórmula de diferenciação centrada de três pontos
        double derivadaQuarta = (yn.get(0) - 4 * yn.get(1) + 6 * yn.get(2) - 4 * yn.get(3) + yn.get(4)) / Math.pow(h, 4);
        return derivadaQuarta;
    }
    
    public double DerivadaSegunda(ArrayList<Double> xn, ArrayList<Double> yn) {
        // Verificar se existem pelo menos três pontos para calcular a derivada segunda
        if (xn.size() < 3 || yn.size() < 3) {
            throw new IllegalArgumentException("Pelo menos três pontos são necessários para calcular a derivada segunda usando o método de diferenciação centrada de três pontos.");
        }
        
        double h = xn.get(1) - xn.get(0); // Intervalo entre os pontos (assumindo que os pontos são equidistantes)
        double x0 = xn.get(1); // Ponto de interesse
        
        // Calcular a derivada segunda usando a fórmula de diferenciação centrada de três pontos
        return (yn.get(2) - 2 * yn.get(1) + yn.get(0)) / Math.pow(h, 2);
    }
}
