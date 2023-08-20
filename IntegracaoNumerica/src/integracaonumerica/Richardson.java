package integracaonumerica;

class Richardson{
    private Metodo I1;
    private Metodo I2;
    private String metodo_selecionado;
    
    public Richardson(Metodo I1, Metodo I2, String metodo_selecionado) {
        this.I1 = I1;
        this.I2 = I2;
        this.metodo_selecionado = metodo_selecionado;
    }
    
    public double calculoRichardson() {
        double resultado_I1 = I1.calculo();
        double resultado_I2 = I2.calculo();
        
        double n1_p, n2_p;
        
        if(metodo_selecionado.equals("Trapezio")) {
            n1_p = Math.pow(I1.getN(), 2);
            n2_p = Math.pow(I2.getN(), 2);
        } else {
            n1_p = Math.pow(I1.getN(), 4);
            n2_p = Math.pow(I2.getN(), 4);
        }
        return resultado_I2 + ((n1_p / (n2_p - n1_p)) * (resultado_I2 - resultado_I1));
    }
}
