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
        
        Scanner s1 = new Scanner(System.in);
        
        System.out.printf("Path arquivo : ");
        String caminhoArquivo = s1.nextLine();
        
        System.out.printf("F(x) = ");
        String funcao = s1.nextLine();
        
        System.out.printf("k = ");
        double k = s1.nextDouble();
   
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
                
                Calculo main_calculo = new Calculo(funcao);
                System.out.println("Simpson : "+ main_calculo.CalculoSimpson(a, b, numSubintervalos));
                System.out.println("Trapezio : " + main_calculo.CalculoTrapezio(a, b, numSubintervalos));
                System.out.println("Richardson : " + main_calculo.CalculoRichardson(a, b, numSubintervalos, k));
            }            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}