/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integracaonumerica;

import java.util.ArrayList;
//import org.mariuszgromada.math.mxparser.*;

public class Parser {
    private String funcao;
    private double intervalo_inf; 
    private double intervalo_sup;
    private double nmr_subintervalos;;
    
    public Parser(String funcao, double intervalo_inf, double intervalo_sup, double nmr_subintervalos) {
        this.funcao = funcao;
        this.intervalo_inf = intervalo_inf;
        this.intervalo_sup = intervalo_sup;
        this.nmr_subintervalos = nmr_subintervalos;
    }
    
    public ArrayList getXn() {
        ArrayList<Double> xn = new ArrayList<>();
        double h = (intervalo_sup - intervalo_inf) / nmr_subintervalos;
        
        for(double i = intervalo_inf; i <= intervalo_sup; i += h) {
            xn.add(i);
        }
        return xn;
    }
    
    public ArrayList getYn() {
        ArrayList<Double> xn = getXn();
        ArrayList<Double> yn = new ArrayList<>();

        for(int i = 0; i < xn.size(); i++) {
            //Argument x = new Argument("x", xn.get(i));
            //Expression expressao = new Expression(funcao, x);
            
            //double resultado = expressao.calculate();
            
            //yn.add(resultado);
        }
        return yn;
    }
}
