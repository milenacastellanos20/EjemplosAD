import java.io.*;
import java.util.Scanner;

public class Ejemplos{
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime la ruta y el nombre del archivo: ");
        String directorio = sc.nextLine(); //recuersa borrar las comillas de la rutaa
        System.out.println("Dime la cadena1: ");
        String cadena = sc.nextLine();
        System.out.println("Dime la cadena2: ");
        String cadena2 = sc.nextLine();
        System.out.println("Dime la cadena3: ");
        String cadena3 = sc.nextLine();
        ejemplo5(directorio,  cadena, cadena2, cadena3);
    }
    public static void ejemplo1(String ruta) {
        File f = new File(ruta);
        f.isDirectory();
        String[] lista = f.list();
        System.out.println("Lista de archivos:");
        for (String nombre : lista) {
            System.out.println(nombre);
        }

    }
    public static void ejemplo3(String ruta) {
        try {
            FileReader f = new FileReader(ruta);
            int caracter = f.read();
            while (caracter != -1) {
                System.out.print((char) caracter);
                caracter = f.read();
            }
        }catch(FileNotFoundException e) {
            System.err.println("El fichero : " + e.getMessage() + "no existe");
        } catch (IOException e) {
            System.err.println("Error en la comunicacion con el fichero");
        }
    }
    public static void ejemplo4(String ruta) {
        try{
            FileReader fileReader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = bufferedReader.readLine(); //recorre el archivo hasta que no haya texto
            while (linea != null) {
                System.out.println(linea);
                linea = bufferedReader.readLine();
            }
        }catch(FileNotFoundException e) {
            System.err.println("El fichero : " + e.getMessage() + "no existe");
        } catch (IOException e) {
            System.err.println("Error en la comunicacion con el fichero");
        }
    }
    public static void ejemplo5(String ruta, String cadena1, String cadena2, String cadena3) {
        try{
            File f = new File(ruta);
            f.createNewFile(); //para que se cree si no existe
         FileWriter fileWriter = new FileWriter(ruta);
         fileWriter.write(cadena1 + "\n" + cadena2 + "\n" + cadena3);
         fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ejemplo6(String ruta, String cadena1, String cadena2,  String cadena3) {
        File f = new File(ruta);
        boolean exists = f.exists();
        try{
            FileWriter fw = new FileWriter(f, exists);
            fw.write(cadena1 + "\n" + cadena2 + "\n" + cadena3);
            fw.close();

            if (exists){
                System.out.println("El fichero ya existe: se han añadido las lineas");
            } else{
                System.out.println("El fichero no existe: se ha creado ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ejemplo7(String ruta, String cadena1, String cadena2) {
        File f = new File(ruta);
        boolean exists = f.exists();
        try{
            FileWriter fw = new FileWriter(f, exists);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cadena1);
            bw.newLine();
            bw.write(cadena2);
            bw.newLine();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
