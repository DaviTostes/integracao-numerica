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
        
        /*System.out.printf("k = ");
        double k = s1.nextDouble();*/
   
        Path path = Paths.get(caminhoArquivo);
        
        double xn = 0.0;
        double yn = 0.0;
        
        try {
            String dados = new String(Files.readAllBytes(path));
            Calculo main_calculo = new Calculo(funcao);

            String[] valores = dados.split("\n");
            
            for(int i = 0; i < valores.length; i+=3){
                xn = Double.parseDouble(valores[i]);
                main_calculo.AddXn(xn);
                
                yn = Double.parseDouble(valores[i + 1]);
                main_calculo.AddYn(yn);
            } 
            main_calculo.CalculoTrapezio();
            main_calculo.CalculoSimpson();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    } 
}