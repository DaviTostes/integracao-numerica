/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integracaonumerica;

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
    
    public double calculoRichardson() {
        double n1 = I1.getN();
        double n2 = I2.getN();
        
        double resultado_I1 = I1.calculoTrapezio();
        double resultado_I2 = I2.calculoTrapezio();
        
        return resultado_I2 + (Math.pow(n1, 2) / (Math.pow(n2, 2) - Math.pow(n1, 2))) * (resultado_I2 - resultado_I1);
    }
    
    //public double ErroRichardson() {}
}
