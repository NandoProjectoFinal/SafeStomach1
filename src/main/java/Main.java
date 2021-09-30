import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Iniciador();

    }

    public static void Iniciador() {
        do {
            String b;
            do {
                menu1();
                b = eleccion();
            } while (!validacion(b));
            if (b=="1"){
                seleccionAlimentos();
            }
            if (b=="2"){
                seleccionAlimentos();
            }
        } while (Salir() == false);
    }

    private static String eleccion() {
        System.out.println("Ingrese una respuesta");
        String b = ingresarRespuesta();
        return b;
    }

    public static void seleccionAlimentos() {
        boolean a = false;
        do {
            menu2();
            System.out.println("Ingrese una respuesta");
            String b = ingresarRespuesta();
            String ruta = "D:\\Proyecto2021\\SafeStomach\\";
            switch (b) {
                case "1":
                    System.out.println("Categoria: Leche y derivados");
                    mostrarlista(arrLista(ruta + "Leche"));
                    a = true;
                    break;
                case "2":
                    System.out.println("Categoria: Carnes Vegetales");
                    mostrarlista(arrLista(ruta + "Carnes"));
                    a = true;
                    break;
                case "3":
                    System.out.println("Categoria: Aceites y grasas");
                    mostrarlista(arrLista(ruta + "Aceites"));
                    a = true;
                    break;
                case "4":
                    System.out.println("Categoria: Snacks");
                    mostrarlista(arrLista(ruta + "Snacks"));
                    a = true;
                    break;
                case "5":
                    System.out.println("Categoria: Bebestibles");
                    mostrarlista(arrLista(ruta + "Bebestibles"));
                    a = true;
                    break;
                case "6":
                    System.out.println("Categoria: Pan");
                    mostrarlista(arrLista(ruta + "Pan"));
                    a = true;
                    break;
                case "7":
                    System.out.println("Categoria: Cereales y pastas");
                    mostrarlista(arrLista(ruta + "Cereales"));
                    a = true;
                    break;
                default:
                    System.out.println("Categoria: Entrada no Valida");
                    a = false;
                    break;
            }
        } while (a == false);
    }

    private static void mostrarlista(String[] d) {
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }

    public static String[] arrLista(String ruta) {
        String[] arr = leerArchivo(ruta).split("\n");
        return arr;
    }


    public static String leerArchivo(String ruta) {
        File f = new File(ruta);
        Path archivo = Paths.get(ruta);
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return contenido;
    }

    public static boolean Salir() {
        boolean a;
        boolean b = false;
        String opcion;
        do {
            System.out.println("Desea Salir?");
            System.out.println("[1] Si");
            System.out.println("[2] no");
            opcion = ingresarRespuesta();
            switch (opcion) {
                case "1":
                    a = true;
                    b = true;
                    break;
                case "2":
                    a = true;
                    b = false;
                    break;
                default:
                    a = false;
                    System.out.println("caracter no valido");
                    break;
            }
        } while (a == false);
        return b;
    }

    public static boolean validacion(String b) {
        boolean a = false;
        do {
            switch (b) {
                case "1":
                    a = true;
                    break;
                case "2":
                    a = true;
                    break;
                default:
                    System.out.println("Entrada no Valida");
                    a = false;
                    break;
            }
        } while (a == false);
        return a;
    }

    public static String ingresarRespuesta() {
        Scanner teclado = new Scanner(System.in);
        return teclado.next();
    }

    public static void menu2() {
        System.out.println("Que tipo de comida esta buscando?");
        System.out.println("[1] Leche y derivados");
        System.out.println("[2] Carnes Vegetales");
        System.out.println("[3] Aceites y grasas");
        System.out.println("[4] Snacks");
        System.out.println("[5] Bebestibles");
        System.out.println("[6] Pan");
        System.out.println("[7] cereales y pastas");
    }

    /*
     Nombre del producto, Tipo de Producto , Valor , Supermecado
     Powerade,  Bebida Energetica, 1100, Acuenta,Lider,Unimarc,
     toString()
     */

    public static void menu1() {
        System.out.println("**********************************************************");
        System.out.println("*                     SafeStomach                        *");
        System.out.println("**********************************************************");
        System.out.println("Por favor, seleccione una de las opcíones");
        System.out.println("[1] Ver comida Vegana");
        System.out.println("[2] Ver comida Vegetariana");

    }

}
