package integracaonumerica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegracaoNumerica {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        
        System.out.printf("Path arquivo : ");
        String caminhoArquivo = s1.nextLine();
   
        Path path = Paths.get(caminhoArquivo);
        
        ArrayList<Double> xn = new ArrayList<>();
        ArrayList<Double> yn = new ArrayList<>();

        int subIntervalos = 0;

        while(subIntervalos <= 1) {
            System.out.print("Digite a quantidade de subintervalos (2 ou mais): ");
            subIntervalos = s1.nextInt();
        } 
        
        try(BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = "";

            while((linha = br.readLine()) != null && xn.size() < subIntervalos) {
                String x = linha.split("\\s+")[0];
                String y = linha.split("\\s+")[1];

                xn.add(Double.parseDouble(x));
                yn.add(Double.parseDouble(y));
            }

            Trapezio trap = new Trapezio();

            Simpson sinpos = new Simpson();

            System.out.println(trap.calculoTrapezio(xn, yn));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    } 
}