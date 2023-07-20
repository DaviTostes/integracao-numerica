/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integracaonumerica;

import java.util.ArrayList;

/**
 *
 * @author ellia
 */
class ExtrapolacaoRichardson{
    private Trapezio I1;
    private Trapezio I2;
    
    public ExtrapolacaoRichardson(Trapezio I1, Trapezio I2) {
        this.I1 = I1;
        this.I2 = I2;
    }
    
    public double calculoRichardson(ArrayList<Double> xn, ArrayList<Double> yn) {
        
        double resultado_I1 = I1.calculoTrapezio(xn, yn);
        double resultado_I2 = I2.calculoTrapezio(xn, yn);

        int n1 = xn.size();
        int n2 = yn.size();
        
        return resultado_I2 + (Math.pow(n1, 2) / (Math.pow(n2, 2) - Math.pow(n1, 2))) * (resultado_I2 - resultado_I1);
    }
    
    //public double ErroRichardson() {}
}
