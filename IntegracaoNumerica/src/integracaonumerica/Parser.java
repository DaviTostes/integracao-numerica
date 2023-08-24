package integracaonumerica;

import java.util.ArrayList;
import org.mariuszgromada.math.mxparser.*;

public class Parser {
    boolean isCallSuccessful = License.iConfirmNonCommercialUse("Elias, Davi, Alan, Gabriel");
    
    private String funcao;
    private double intervalo_inf; 
    private double intervalo_sup;
    private double nmr_subintervalos;;
    
    public Parser(String funcao, double intervalo_inf, double intervalo_sup, double nmr_subintervalos) {
        this.funcao = funcao;
        this.intervalo_inf = intervalo_inf;
        this.intervalo_sup = intervalo_sup;
        this.nmr_subintervalos = nmr_subintervalos;
    }
    
    public ArrayList<Double> getXn() {
        ArrayList<Double> xn = new ArrayList<>();
        double h = (intervalo_sup - intervalo_inf) / nmr_subintervalos;
        double x = intervalo_inf;
        
        for(double i = 0; i <= nmr_subintervalos; i++) {
            xn.add(x);
            x+= h;
            System.out.println(x);
        }
        return xn;
    }
    
    public ArrayList<Double> getYn() {
        ArrayList<Double> xn = getXn();
        ArrayList<Double> yn = new ArrayList<>();

        for(int i = 0; i < xn.size(); i++) {
            Argument x = new Argument("x", xn.get(i));
            Expression expressao = new Expression(funcao, x);
            
            double resultado = expressao.calculate();
            
            yn.add(resultado);
        }
        return yn;
    }
}
