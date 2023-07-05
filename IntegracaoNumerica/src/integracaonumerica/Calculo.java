package integracaonumerica;


import java.util.ArrayList;
import org.mariuszgromada.math.mxparser.*;
//rolas grossas rolas deliciosas

public class Calculo {
    
    private ArrayList<Double> xn;
    private ArrayList<Double> yn;
    private String funcao;
   
    public Calculo(String funcao){
        this.xn = new ArrayList<>();
        this.yn = new ArrayList<>();
        this.funcao = funcao;
    }
    
    public void AddXn(double x) {
        xn.add(x);
    } 
    
    public void AddYn(double y) {
        yn.add(y);
    }    
    
    
    public double CalculoSimpson() {
        double soma = 0;
        double h = xn.get(0) - xn.get(1);
        
        for(int i = 0; i < yn.size(); i++){
            if(i == 0 || i == yn.size()) {
                soma = yn.get(i);
            } else if(i % 2 == 0) {
                soma = yn.get(i) * 4;
            } else if(i % 2 != 0) {
                soma = yn.get(i) * 2;
            }
        }
        return soma * h / 2;
    }
    
    //public double ErroSimpson() {}
    
    public double CalculoTrapezio() {
        double soma = 0;
        double h = xn.get(0) - xn.get(1);
        
        for(int i = 0; i < yn.size(); i++){
            if(i == 0 || i == yn.size()) {
                soma = yn.get(i);
            } else {
                soma = yn.get(i) * 2;
            }
        }
        return soma * h / 2;
    }
    
    //public double ErroTrapezio() {}
    
    
    public double CalculoRichardson(double k) {
        double I1 = CalculoTrapezio();  
        double I2 = CalculoTrapezio() * Math.pow(k,2);

        return (Math.pow(k, 2) * I2 - I1) / (Math.pow(k, 2) - 1);
    }
    
    //public double ErroRichardson() {}
}

