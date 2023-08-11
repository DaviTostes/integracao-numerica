package integracaonumerica;

import java.util.ArrayList;

class Richardson{
    private Trapezio I1;
    private Trapezio I2;
    
    public Richardson(Trapezio I1, Trapezio I2) {
        this.I1 = I1;
        this.I2 = I2;
    }
    
    public double calculoRichardson() {
        double resultado_I1 = I1.calculoTrapezio();
        double resultado_I2 = I2.calculoTrapezio();

        double n1 = I1.getN();
        double n2 = I2.getN();
        
        return (resultado_I2 + (Math.pow(n1-1, 2) / ((Math.pow(n2-1, 2) - Math.pow(n1-1, 2)))) * (resultado_I2 - resultado_I1));
    }
}
