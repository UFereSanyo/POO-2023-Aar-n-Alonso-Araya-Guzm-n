import javax.security.auth.login.AccountExpiredException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//NOTA PARA EL PROFESOR: El programa muestra toda la informacion en consola (de manera seguida) y en interfaz (según acción en esta).

public class Main {

    private static ArrayList<Articulo> inventario = new ArrayList();
    private static ArrayList<Item> reparaciones = new ArrayList();
    //Cada nueva factura se crea aquí, como se muestra en las siquientes dos lineas
    private static FacturaVenta bill1 = new FacturaVenta(new ArrayList<Articulo>(),5);
    private static FacturaReparacion bill2 = new FacturaReparacion(new ArrayList<Item>());

    private static ArrayList<String> histFact = new ArrayList<String>();
    private static int cantFacturas = 0;
    private static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    private static Date date = new Date(System.currentTimeMillis());
    private static ArrayList<String> planilla = new ArrayList<String>();
    private static ArrayList<String>vendedores = new ArrayList<String>();
    private static ArrayList<String>tecnicos = new ArrayList<String>();
    private static ArrayList<String>gerentes = new ArrayList<String>();

    public static ArrayList<Articulo> getInventario() {
        return inventario;
    }

    public static void setInventario(ArrayList<Articulo> inventario) {
        Main.inventario = inventario;
    }

    public static ArrayList<Item> getReparaciones() {
        return reparaciones;
    }

    public static void setReparaciones(ArrayList<Item> reparaciones) {
        Main.reparaciones = reparaciones;
    }

    public static FacturaVenta getBill1() {
        return bill1;
    }

    public static void setBill1(FacturaVenta bill1) {
        Main.bill1 = bill1;
    }

    public static FacturaReparacion getBill2() {
        return bill2;
    }

    public static void setBill2(FacturaReparacion bill2) {
        Main.bill2 = bill2;
    }



    public static ArrayList<String> getHistFact() {
        return histFact;
    }

    public static void setHistFact(ArrayList<String> histFact) {
        Main.histFact = histFact;
    }

    public static int getCantFacturas() {
        return cantFacturas;
    }

    public static void setCantFacturas(int cantFacturas) {
        Main.cantFacturas = cantFacturas;
    }

    public static SimpleDateFormat getFormatter() {
        return formatter;
    }

    public static void setFormatter(SimpleDateFormat formatter) {
        Main.formatter = formatter;
    }

    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        Main.date = date;
    }

    public static ArrayList<String> getPlanilla() {
        return planilla;
    }

    public static void setPlanilla(ArrayList<String> planilla) {
        Main.planilla = planilla;
    }

    public static ArrayList<String> getVendedores() {
        return vendedores;
    }

    public static void setVendedores(ArrayList<String> vendedores) {
        Main.vendedores = vendedores;
    }

    public static ArrayList<String> getTecnicos() {
        return tecnicos;
    }

    public static void setTecnicos(ArrayList<String> tecnicos) {
        Main.tecnicos = tecnicos;
    }

    public static ArrayList<String> getGerentes() {
        return gerentes;
    }

    public static void setGerentes(ArrayList<String> gerentes) {
        Main.gerentes = gerentes;
    }

    public static void main(String[] args) {

        // Crear algunos items electrónicos y listas
        Articulo tv = new Articulo(1, "Televisor", "LG", "LG 4K TV", 250000);
        Articulo phone = new Articulo(2, "Telefono", "Iphone", "12", 200000);
        Articulo laptop = new Articulo(3, "Laptop", "Dell", "Inspiron 15 5510",300000);
        Articulo computer = new Articulo(4, "Computer", "Corsair","Something" ,500000);

        Item celular = new Item("celular", "reparado","reemplazo pantalla exitoso", 20000);
        Item teclado = new Item("teclado", "no reparado","membrana no disponible",0);

        //Agregar items a sus arrays correspondientes
        inventario.add(tv);
        inventario.add(phone);
        inventario.add(laptop);
        inventario.add(computer);

        reparaciones.add(celular);
        reparaciones.add(teclado);


        System.out.println(formatter.format(date));

        System.out.println("\nInventario: " + inventario);

        for (Articulo articulo : inventario){
            System.out.println("\n"+articulo);}

        System.out.println("\nReparaciones: " + reparaciones);

        for (Item item : reparaciones){
            System.out.println("\n"+item);}


        // Crear una factura para algunos items comprados y reparados

        System.out.println("\nFacturas:");

        //agregar articulos a la factura

        bill1.getArticulos().add(tv);
        bill1.getArticulos().add(phone);

        System.out.println("\nCompras:");
        System.out.println(tv + "\n"+ phone);
        System.out.println(bill1.calcularTotal());
        //System.out.println(bill1);

        bill2.getItems().add(celular);
        bill2.getItems().add(teclado);
        System.out.println("\nReparaciones:");
        System.out.println(celular + "\n"+celular.getEstado() + "\n" + celular.getMotivo() + teclado + "\n" + teclado.getEstado() + "\n" + teclado.getMotivo());
        System.out.println(bill2.calcularTotal());
        //System.out.println(bill2);



        histFact.add("Factura No."+String.valueOf(cantFacturas+1));
        histFact.add(String.valueOf(date));
        histFact.add("\nCompras:");
        histFact.add(String.valueOf(bill1));
        histFact.add("\nReparaciones:");
        histFact.add(String.valueOf(bill2));
        histFact.add("Total: "+ String.valueOf(bill1.calcularTotal()+bill2.calcularTotal()));
        for (String h : histFact){
        System.out.println("\n"+h);}
        cantFacturas += 1;

        //Agregar y Calcular la planilla para algunos empleados de la tienda
        //Copiar y pegar lineas o bloques segun desee agregar

        Vendedor employee1 = new Vendedor("Soichi Terada", "49511322", "Peje Viejo","29/4/2007","64551225",300000, 15000);
        Tecnico employee2 = new Tecnico("Danny Elfman", "641225965","Guanacaste","17/09/2001","64558216",350000, "Televisores");
        Gerente employee3 = new Gerente("Mick Gordon","1644855","El Infiernillo","02/09/1995","95554666",500000,"Almacen");

        vendedores.add(String.valueOf(employee1));
        vendedores.add("Salario Mensual de " + String.valueOf(employee1.getNombre()) + ": " + String.valueOf(employee1.calcularSalario()));
        vendedores.add("Salario Quincenal de " + String.valueOf(employee1.getNombre()) + ": " + String.valueOf(employee1.calcularQuincena()));
        vendedores.add("Salario Semanal de " + String.valueOf(employee1.getNombre()) + ": " + String.valueOf(employee1.calcularSemana()));

        tecnicos.add(String.valueOf(employee2));
        tecnicos.add("Salario Mensual de " + String.valueOf(employee2.getNombre()) + ": " + String.valueOf(employee2.calcularSalario()));
        tecnicos.add("Salario Quincenal de " + String.valueOf(employee2.getNombre()) + ": " + String.valueOf(employee2.calcularQuincena()));
        tecnicos.add("Salario Semanal de " + String.valueOf(employee2.getNombre()) + ": " + String.valueOf(employee2.calcularSemana()));

        gerentes.add(String.valueOf(employee2));
        gerentes.add("Salario Mensual de " + String.valueOf(employee3.getNombre()) + ": " + String.valueOf(employee3.calcularSalario()));
        gerentes.add("Salario Quincenal de " + String.valueOf(employee3.getNombre()) + ": " + String.valueOf(employee3.calcularQuincena()));
        gerentes.add("Salario Semanal de " + String.valueOf(employee3.getNombre()) + ": " + String.valueOf(employee3.calcularSemana()));


        for (String vend : vendedores){
            System.out.println("\n"+ vend);
        }
        for (String tech : tecnicos){
            System.out.println("\n"+ tech);
        }
        for (String gere : gerentes){
            System.out.println("\n"+ gere);
        }


        planilla.add("\nEmpleados: ");

        planilla.add(String.valueOf(employee1));
        planilla.add("Salario Mensual de " + String.valueOf(employee1.getNombre()) + ": " + String.valueOf(employee1.calcularSalario()));
        planilla.add("Salario Quincenal de " + String.valueOf(employee1.getNombre()) + ": " + String.valueOf(employee1.calcularQuincena()));
        planilla.add("Salario Semanal de " + String.valueOf(employee1.getNombre()) + ": " + String.valueOf(employee1.calcularSemana()));

        planilla.add(String.valueOf(employee2));
        planilla.add("Salario Mensual de " + String.valueOf(employee2.getNombre()) + ": " + String.valueOf(employee2.calcularSalario()));
        planilla.add("Salario Quincenal de " + String.valueOf(employee2.getNombre()) + ": " + String.valueOf(employee2.calcularQuincena()));
        planilla.add("Salario Semanal de " + String.valueOf(employee2.getNombre()) + ": " + String.valueOf(employee2.calcularSemana()));

        planilla.add(String.valueOf(employee3));
        planilla.add("Salario Mensual de " + String.valueOf(employee3.getNombre()) + ": " + String.valueOf(employee3.calcularSalario()));
        planilla.add("Salario Quincenal de " + String.valueOf(employee3.getNombre()) + ": " + String.valueOf(employee3.calcularQuincena()));
        planilla.add("Salario Semanal de " + String.valueOf(employee3.getNombre()) + ": " + String.valueOf(employee3.calcularSemana()));

        for (String p : planilla){
            System.out.println("\n"+p);

        }

        //Creacion de la interfaz

        Ventana windoe = new Ventana();
        windoe.showFrame();
    }
}