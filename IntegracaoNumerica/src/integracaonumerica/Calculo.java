package integracaonumerica;

import java.util.ArrayList;
import org.mariuszgromada.math.mxparser.*;

public class Calculo {
    boolean isCallSuccessful = License.iConfirmNonCommercialUse("Elias");
    
    private ArrayList<Double> xn;
    private ArrayList<Double> yn;
    private String funcao;
    private double k;
   
    public Calculo(String funcao, double k){
        this.xn = new ArrayList<>();
        this.yn = new ArrayList<>();
        this.funcao = funcao;
        this.k = k;
    }
    
    public void AddXn(double x) {
        xn.add(x);
    } 
    
    public void AddYn(double y) {
        yn.add(y);
    }

    public double CalculoSimpson() {
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
    
    public double CalculoTrapezio() {
        double soma = 0;
        double h = xn.get(1) - xn.get(0);
        
        for(int i = 0; i < yn.size(); i++){
            if(i == 0 || i == yn.size()-1) {
                soma += yn.get(i);
            } else {
                soma += yn.get(i) * 2;
            }
        }
        return soma * (h / 2);
    }
    
    //public double ErroTrapezio() {}
    
    
    public double CalculoRichardson() {
        ArrayList<Double> I2_yn = new ArrayList<>();
        ArrayList<Double> I2_xn = new ArrayList<>();
        double h = (xn.get(xn.size()-1) - xn.get(0)) / k;
        double soma = 0;
        
        I2_xn.add(xn.get(0));
        for(int i = 0; i <= k; i++) {
            I2_xn.add(I2_xn.get(i) + h);
            Argument x = new Argument("x", I2_xn.get(i));
            Expression yn_getter = new Expression(funcao, x);
            I2_yn.add(yn_getter.calculate());
        }
        
        for(int i = 0; i < I2_yn.size(); i++){
            if(i == 0 || i == I2_yn.size()-1) {
                soma += I2_yn.get(i);
            } else {
                soma += I2_yn.get(i) * 2;
            }
        }
        double I1 = CalculoTrapezio();
        double I2 = soma * (h / 2);
        
        double aux_soma = Math.pow(yn.size(),2) / (Math.pow(k,2) - Math.pow(yn.size(),2));
        return I2 + aux_soma * (I2-I1);
    }
    
    
    //public double ErroRichardson() {}
}