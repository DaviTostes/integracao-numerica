package integracaonumerica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IntegracaoNumerica {
    public static void main(String[] args) {
        String caminhoArquivo = "Caminho Arquivo";
        Path path = Paths.get(caminhoArquivo);
        
        double a = 0.0;
        double b = 0.0;
        int numSubintervalos = 0;
        
        try {
            String dados = new String(Files.readAllBytes(path));

            String[] valores = dados.split("\n");

            a = Double.parseDouble(valores[0]);
            b = Double.parseDouble(valores[1]);
            numSubintervalos = Integer.parseInt(valores[2]);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        System.out.println("Valor de a: " + a);
        System.out.println("Valor de b: " + b);
        System.out.println("Numero de subintervalos: " + numSubintervalos); 
    }
}