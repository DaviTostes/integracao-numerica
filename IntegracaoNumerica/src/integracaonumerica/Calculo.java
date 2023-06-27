package integracaonumerica;

import org.mariuszgromada.math.mxparser.*;

public class Calculo {
    boolean isCallSuccessful = License.iConfirmNonCommercialUse("Elias");
    
    /*private double limInferior;
    private double limSuperior;
    private int subintervalos;*/
    private String funcao;
   
    public Calculo(String funcao){
        /*this.limInferior = limInferior;
        this.limSuperior = limSuperior;
        this.subintervalos = (int)subintervalos;*/
        this.funcao = funcao;
    }
    
    //Function function_parser = new Function("f(x) = " + funcao);
    
    
    public double CalculoSimpson(double limInferior, double limSuperior, double subintervalos) {
        double h = (limSuperior - limInferior) / subintervalos;
        
        Argument a_argument = new Argument("x", limInferior);
        Argument b_argument = new Argument("x", limSuperior);
        
        Expression e_a = new Expression(funcao, a_argument);
        Expression e_b = new Expression(funcao, b_argument);
        
        double soma = e_b.calculate() + e_a.calculate();

        for (int i = 1; i < subintervalos; i++) {
            double x = limInferior + i * h;
            
            Argument x_argument = new Argument("x", x);
            Expression e1 = new Expression(funcao, x_argument);

            if (i % 2 == 0) {
                soma += 2 * e1.calculate();
            } else {
                soma += 4 * e1.calculate();
            }
        }

        return h * soma / 3;
    }
    
    public double CalculoTrapezio(double limInferior, double limSuperior, double subintervalos) {
        double h = (limSuperior - limInferior) / subintervalos;
        double soma = 0;
        
        Argument a_argument = new Argument("x", limInferior);
        Argument b_argument = new Argument("x", limSuperior);
        
        Expression e_a = new Expression(funcao, a_argument);
        Expression e_b = new Expression(funcao, b_argument);

        for (int i = 0; i <= subintervalos; i++) {
            double x = limInferior + i * h;
            
            Argument x_argument = new Argument("x", x);
            Expression e1 = new Expression(funcao, x_argument);
            
            soma += e1.calculate();
        }

        return h * (soma - (e_a.calculate() + e_b.calculate()) / 2);
    }
    
    
    public double CalculoRichardson(double limInferior, double limSuperior, double subintervalos, double k) {
        //double h1 = (limSuperior - limInferior) / subintervalos;

        double I1 = CalculoTrapezio(limInferior, limSuperior, subintervalos);

        double I2 = CalculoTrapezio(limInferior, limSuperior, (subintervalos * k));

        return (Math.pow(k, 2) * I2 - I1) / (Math.pow(k, 2) - 1);
    }
}

