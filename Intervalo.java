/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academy.pkg3;

import java.util.function.BinaryOperator;

/**
 *
 * @author Mateo
 */
public class Intervalo {

    private int _min;
    private int _max;

    public Intervalo(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Valor min " + min + "no deberia ser mayor al valor max " + max);
        }
        _min = min;
        _max = max;
    }

    public int reduce(int totalInicial, BinaryOperator<Integer> op) {
        if (_min == _max) {
            totalInicial = _min + _max;
        }
        int aux = totalInicial;
        for (int x = _min; x <= _max; x++) {
            aux = op.apply(aux, x);
        }
        return aux;
    }
    public int sumatoria(){
        return reduce(0, (x, y) -> x + y);
    }

    public int producto(){
        return reduce(1, (x, y) -> x * y);
    }
    public static void main(String[] args) {
        Intervalo oso = new Intervalo(5, 5);    
        System.out.println(oso.sumatoria());
        System.out.println(oso.producto());
    }
    //
}
