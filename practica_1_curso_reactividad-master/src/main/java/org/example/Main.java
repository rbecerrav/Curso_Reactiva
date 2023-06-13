package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Primer punto
        List<Integer> lista = List.of(2,1,3,4,5,6,7,8,10,9);
        System.out.println("Lista de numeros: "+lista.toString());
        System.out.println("buscando el mayor y menor de la lista");
        mayorMenor(lista);
        //2. segundo punto
        System.out.println("Compra de $100.000 y el descuento es 25%");
        System.out.println("El valor a pagar es $"+descuento(100000,25));

        // 3. punto tres
        System.out.println("Compra de $100.000 y el iva es 19%");
        System.out.println("Valor a pagar de iva es $"+iva(100000,19));
        System.out.println("Compra de $100.000 sin iva especificado");
        System.out.println("Valor a pagar de iva es $"+iva(100000));


    }
    /// Volver el punto 1 y 2 en una funcion
    public static void mayorMenor(List<Integer> lista){
        System.out.println("El numero mayor es: "+mayor(lista).toString());
        System.out.println("El numero menor es: "+menor(lista).toString());
    }
    public static Integer mayor(List<Integer> lista){
        return lista.stream().max(Integer::compareTo).get();
    }
    public static Integer menor(List<Integer> lista){
        return lista.stream().min(Integer::compareTo).get();
    }
    public static double descuento(double valor, double porcentaje){
        return valor - (valor * (porcentaje/100));
    }
    public static double iva(double valor, double... porcentaje){
        double porcentajeIVA;
        if (porcentaje.length > 0){
            porcentajeIVA = porcentaje[0];
        }else {
            porcentajeIVA= 21;
        }
        return valor*(porcentajeIVA/100);
    }
    /**
     * Haciendo uso de lo aprendido(Expresiones lambda, referencias a métodos y funciones puras) resuelva:
     * */

    /**
     * 1. Con la intención de encontrar el número mayor en una lista y a su vez el número menor, cree un método que le permita
     * estas dos funciones, siguiendo los principios de las funciones puras.
     * */
    /**
     * 2. En una tienda de ropa necesitamos aplicar un descuento a las ventas que se hacen, este descuento
     * es variable por lo que necesitamos que usted cree un método que reciba el total de la venta y el porcentaje a descontar
     * y devuelva el nuevo precio total.
     * */

    /**
     * 3. Necesitamos calcular el iva de una venta, para esto es necesario que usted cree un método
     * Tendremos dos escenarios posibles, en el primero se le pasará únicamente el valor al cual se le debe
     * aplicar el iva, sin especificar el porcentaje, en este caso se debe aplicar un 21% siempre.
     * En el segundo escenario se le pasará tanto el precio de la venta como el porcentaje de iva.
     * Cree una sola función que pueda lograr estos dos propósitos
     * */



}