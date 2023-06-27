package integracaonumerica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.mariuszgromada.math.mxparser.*;

public class IntegracaoNumerica {
    public static void main(String[] args) {
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Elias");
        
        /*leitura de arquivos, comentado apenas para testes

        String caminhoArquivo = "C:/Users/biels/Desktop/dados.dat";
        Path path = Paths.get(caminhoArquivo);
        
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
            }            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        */
           
        Calculo main_calculo = new Calculo("x*e^x");
        System.out.println(main_calculo.CalculoSimpson(1, 3, 6));
        System.out.println(main_calculo.CalculoTrapezio(1, 3, 6));
        double x1 = main_calculo.CalculoRichardson(1, 3, 6, 10);
        System.out.println(x1);
    }
}