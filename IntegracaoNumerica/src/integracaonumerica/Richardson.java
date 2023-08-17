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

        double n1_p = Math.pow(I1.getN(), 2);
        double n2_p = Math.pow(I2.getN(), 2);
        
        return resultado_I2 + ((n1_p / (n2_p - n1_p)) * (resultado_I2 - resultado_I1));
    }
}
