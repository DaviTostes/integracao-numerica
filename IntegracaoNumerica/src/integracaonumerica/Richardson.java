package integracaonumerica;

class Richardson{
    private UmTercoSimpson I1;
    private UmTercoSimpson I2;
    
    public Richardson(UmTercoSimpson I1, UmTercoSimpson I2) {
        this.I1 = I1;
        this.I2 = I2;
    }
    
    public double calculoRichardson() {
        double resultado_I1 = I1.calculoUmTercoSimpson();
        double resultado_I2 = I2.calculoUmTercoSimpson();

        double n1_p = Math.pow(I1.getN(), 2);
        double n2_p = Math.pow(I2.getN(), 2);
        
        return resultado_I2 + ((n1_p / (n2_p - n1_p)) * (resultado_I2 - resultado_I1));
    }
}
