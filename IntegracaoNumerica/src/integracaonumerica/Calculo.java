package integracaonumerica;

import java.util.ArrayList;
import org.mariuszgromada.math.mxparser.*;

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
        xn.add(y);
    }    
    
    
    /*public static double CalculoSimpson() {
        
        
    }*/
    
    public void CalculoTrapezio() {
        double soma = 0;
        double h = xn.get(0) - xn.get(1);
        
        for(int i = 0; i < yn.size(); i++){
            if(i == 0 || i == yn.size()) {
                soma = yn.get(i);
            } else {
                soma = yn.get(i) * 2;
            }
            
        double resultado = soma * h / 2;
        
        Argument b = new Argument("b", xn.get(xn.size()));
        Argument a = new Argument("a", xn.get(0));
        Argument n = new Argument("n", xn.size());
        Argument x = new Argument("x", xn.get(xn.size()));
        
        Expression error_p1 = new Expression("(-(-b-a) ^5) / (180 * n 5)", b, a, n);
        Expression error_p2 = new Expression("F(x) = der2(" + funcao + ")", x);
        
        double erro = error_p1.calculate() * error_p2.calculate();
        
        System.out.println("Trapezio : " + resultado);
        System.out.println("Erro : " + erro);
        }
    }
    
    
    /*public double CalculoRichardson(double limInferior, double limSuperior, double subintervalos, double k) {     
    }*/
}

