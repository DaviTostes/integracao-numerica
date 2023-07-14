/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integracaonumerica;

import java.util.ArrayList;

/**
 *
 * @author ellia
 */
class Trapezio {
    private ArrayList<Double> xn;
    private ArrayList<Double> yn;
   
    public Trapezio(ArrayList xn, ArrayList yn){
        this.xn = xn;
        this.yn = yn;
    }
    
    public double calculoTrapezio() {
        double soma = 0;
        double h = xn.get(1) - xn.get(0);
        
        for(int i = 0; i < yn.size(); i++){
            if(i == 0 || i == yn.size()-1) {
                soma += yn.get(i);
            } else {
                soma += yn.get(i) * 2;
            }
        }
        return soma * (h / 2);
    }
    
    //public double erroTrapezio() {}
    
    public double getN() {
        return xn.size();
    }
}
