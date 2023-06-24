package integracaonumerica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IntegracaoNumerica {
    public static void main(String[] args) {
        String caminhoArquivo = "C:/Users/biels/Desktop/dados.dat";
        Path path = Paths.get(caminhoArquivo);
        Calculo integracao = new Calculo();
        
        double a = 0.0;
        double b = 0.0;
        double numSubintervalos = 0;
        
        try {
            String dados = new String(Files.readAllBytes(path));

            String[] valores = dados.split("\n");
            
            for(int i = 0; i < valores.length; i+=3){
                a = Double.parseDouble(valores[i]);
                b = Double.parseDouble(valores[i + 1]);
                numSubintervalos = Double.parseDouble(valores[i + 2]);
                integracao.calcularIntegracao(a, b, numSubintervalos);
            }            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}