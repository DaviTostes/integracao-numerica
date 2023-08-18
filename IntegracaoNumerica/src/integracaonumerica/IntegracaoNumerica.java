package integracaonumerica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegracaoNumerica {
    public IntegracaoNumerica(){
        Scanner s1 = new Scanner(System.in);
        
        System.out.printf("Path arquivo : ");
        String caminhoArquivo = s1.nextLine();
        
        ArrayList<Double> xn = new ArrayList<>();
        ArrayList<Double> yn = new ArrayList<>();

        ArrayList<Double> xn2 = new ArrayList<>();
        ArrayList<Double> yn2 = new ArrayList<>();

        int subIntervalos = 0;
        
        while(subIntervalos <= 1) {
            System.out.print("Digite a quantidade de subintervalos (2 ou mais): ");
            subIntervalos = s1.nextInt()+1;
        } 
        
        try(BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = "";

            while((linha = br.readLine()) != null && xn.size() < subIntervalos) {
                String x = linha.split("\\s+")[0];
                String y = linha.split("\\s+")[1];

                xn.add(Double.valueOf(x));
                yn.add(Double.valueOf(y));
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

         Scanner s2 = new Scanner(System.in);

        System.out.printf("Path arquivo : ");
        String caminhoArquivo2 = s2.nextLine();

        subIntervalos = 0;
        
        while(subIntervalos <= 1) {
            System.out.print("Digite a quantidade de subintervalos (2 ou mais): ");
            subIntervalos = s2.nextInt()+1;
        } 

        try(BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo2))) {
            String linha = "";

            while((linha = br.readLine()) != null && xn.size() < subIntervalos) {
                String x = linha.split("\\s+")[0];
                String y = linha.split("\\s+")[1];

                xn2.add(Double.valueOf(x));
                yn2.add(Double.valueOf(y));
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        Trapezio t1 = new Trapezio(xn, yn);

        Trapezio t2 = new Trapezio(xn2, yn2);
            
        UmTercoSimpson uts1 = new UmTercoSimpson(xn, yn);
            
        TresOitavosSimpson tos1 = new TresOitavosSimpson(xn, yn);
            
        Richardson er1 = new Richardson(t1, t2);
            
        System.out.println("Trapézio: "+t1.calculoTrapezio());
        System.out.println("Trapézio2: "+t2.calculoTrapezio());
            
        System.out.println("Um terço de Simpson: "+uts1.calculoUmTercoSimpson());
            
        System.out.println("três oitavos de Simpson: "+tos1.calculoTresOitavosSimpson());

        System.out.println("Richardson: "+er1.calculoRichardson());

        s1.close();
    }
}