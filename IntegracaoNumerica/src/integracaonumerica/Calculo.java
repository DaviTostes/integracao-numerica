package integracaonumerica;

public class Calculo {
    private double limInferior;
    private double limSuperior;
    private int subintervalos;
    double resultado;
   
    public double calcularIntegracao(double limInferior, double limSuperior, double subintervalos){
        this.limInferior = limInferior;
        this.limSuperior = limSuperior;
        this.subintervalos = (int)subintervalos;
        
        System.out.println("Valor de a: " + this.limInferior);
        System.out.println("Valor de b: " + this.limSuperior);
        System.out.println("Numero de subintervalos: " + this.subintervalos); 
        
        return resultado;
    }
}
