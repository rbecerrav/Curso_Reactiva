package com.sales.functional;


import com.sales.functional.database.Database;
import com.sales.functional.entities.Sale;

import java.time.ZoneId;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


import java.util.stream.Collectors;





public class SuppliesFunctional {
    static ArrayList<Sale> sales = Database.loadDatabase();
    public static void main(String[] args) {
        loadMenu();

    }


    /** 1. Obtenga todas las ventas(Sale) que tengan como método de compra(Purchase method) 'Online'

        2. Obtenga todas las ventas(Sale) que tengan como ubicación New York y filtre también validando si las ventas fueron con cupón o sin cupón

        3. Obtenga la cantidad de ventas en las que los clientes usaron cupón

        4. Obtenga todas las ventas que fueron realizadas un año específico 'YYYY'

        5. Obtenga el número de ventas en donde el indicador de satisfacción es menor a 4.

        6. Calcule el monto total que pagó el cliente en cada venta.

        7. Obtenga todas las ventas en las que el comprador es una mujer y fue comprado en la tienda ('in store')

        8. Obtenga el número de productos comprados por todos los clientes segmentándolos por etiquetas(tags)

        9. Obtenga cuantos hombres usaron cupón y cuantas mujeres usaron cupón;

        10. Obtenga la venta con la compra más costosa y la venta con la compra más barata
     */

    public static void menu(){
        System.out.println("Supplies sales");
        System.out.println("1. Compras en linea");
        System.out.println("2. Compras realizadas en New York con o sin cupón");
        System.out.println("3. el numero de ventas en donde se usaron cupones y en el numero en las que no");
        System.out.println("4. Ventas realizadas en el año YYYY");
        System.out.println("5. Ventas en donde el indicador de satisfacción es menor a N");
        //TO DO:
        System.out.println("6. Monto total pagado en cada venta");
        System.out.println("7. Ventas en donde compró una mujer en la tienda(in store)");
        System.out.println("8. Agrupación de productos por etiquetas(tags)");
        System.out.println("9. Cuantos hombres y mujeres usaron cupón");
        System.out.println("10. Venta con mayor costo y menor costo");

    }

    public static void loadMenu(){
        Scanner sc = new Scanner(System.in);
        menu();
        System.out.print("Type option: ");
        String op=sc.nextLine();
        switch(op){
            case "1":
                getOnlinePurchases();
                break;
            case "2":
                System.out.print("¿quiere filtrar las ventas que usaron cupón? Y/N: ");
                getNySales(sc.nextLine());
                break;
            case "3":
                couponUsage();
                break;
            case "4":
                System.out.print("Cual es el año por el que quiere filtrar: ");
                salesByYear(sc.nextLine());
                break;
            case "5":
                System.out.print("Cual es el numero de satisfacción por que quiere filtrar (1-5): ");
                salesBySatisfaction(sc.nextLine());
                break;
            case "6":
                System.out.println("Monto total pagado en la venta");
                totalSale();
                break;
            case "7":
                System.out.println("Ventas en donde compró una mujer en la tienda(in store)");
                womanSalesInStore();
                break;

            case "9":
                System.out.println("hombres y mujeres que usaron cupón");
                menAndWomenCoupon();
                break;
            case "10":
                System.out.println("Venta con mayor costo y menor costo");
                maxAndMinSale();
                break;
            default:
                System.out.println("ERROR en el input, este metodo no ha sido creado. Intente de nuevo");
        }

    }


    public static void getOnlinePurchases(){
        Predicate<Sale> onlinePurchased = sale -> sale.getPurchasedMethod().equals("Online");
        ArrayList<Sale> result = sales.stream().filter(onlinePurchased).collect(Collectors.toCollection(ArrayList::new));
        result.forEach(System.out::println);

    }

    public static void getNySales(String inCoupon){
        Predicate<Sale> couponUsage = sale -> sale.getCouponUsed().equals(inCoupon.equalsIgnoreCase("Y")) && sale.getLocation().equals("New York");
        ArrayList<Sale> result = sales.stream().filter(couponUsage).collect(Collectors.toCollection(ArrayList::new));
        result.forEach(System.out::println);

    }

    public static void couponUsage(){
        Predicate<Sale> couponUsage = Sale::getCouponUsed;
        Predicate<Sale> couponNoUsage = sale -> !sale.getCouponUsed();
        Map<String,Long> usage  = new HashMap<>(){{
            put("Usage",sales.stream().filter(couponUsage).count());
            put("Not usage",sales.stream().filter(couponNoUsage).count());
        }};

        usage.forEach((key,value)-> System.out.println(key+": "+value));

    }

    public static void salesByYear(String inYear){
        Function<Sale,String> getYear = sale -> String.valueOf(sale.getSaleDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear());
        ArrayList<Sale> salesByYYYY = sales.stream().filter(sale -> getYear.apply(sale).equals(inYear)).collect(Collectors.toCollection(ArrayList::new));
        salesByYYYY.forEach(System.out::println);
    }

    public static void salesBySatisfaction(String inSatis){
        Consumer<String> satisfaction = satis -> sales.stream().filter(sale -> sale.getCustomer().getSatisfaction().toString().equals(satis)).collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);
        satisfaction.accept(inSatis);
    }

    private static void totalSale() {
        sales.forEach(sale -> System.out.println("para el cliente: "+sale.getCustomer() + "\n Total sale: "+sale.getTotal()));
    }
    private static void womanSalesInStore(){
        Function<Sale,String> getGender = sale -> sale.getCustomer().getGender();

        ArrayList<Sale> salesByWoman = sales.stream().filter(sale -> getGender.apply(sale).equals("F"))
                .filter(sale -> sale.getPurchasedMethod().equals("in store"))
                .collect(Collectors.toCollection(ArrayList::new));
        salesByWoman.forEach(System.out::println);
    }
    private static void menAndWomenCoupon(){
        Predicate<Sale> couponUsageByMan = sale -> sale.getCustomer().getGender().equals("M") && sale.getCouponUsed().equals(true);
        Predicate<Sale> couponUsageByWoman = sale -> sale.getCustomer().getGender().equals("F") && sale.getCouponUsed().equals(true);
        System.out.println("Hombres que usaron cupón: "+sales.stream().filter(couponUsageByMan).count());
        System.out.println("Mujeres que usaron cupón: "+sales.stream().filter(couponUsageByWoman).count());
    }
    private static void maxAndMinSale(){
        Function<Sale,Double> getTotal = sale -> sale.getTotal();
        System.out.println("Venta con mayor costo: "+sales.stream().max(Comparator.comparing(getTotal)).get());
        System.out.println("Venta con menor costo: "+sales.stream().min(Comparator.comparing(getTotal)).get());
    }
}
