// Esta es su clase principal.
// Debe implementar todos los metodos aqui listados.
// No cambie la firma del constructor ni de los metodos ya creados.
// Puede crear cualquier metodo extra que desee
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class AFD {

    private String[] alfabeto;
    private int cantidadEstados;
    private int[] estadosFinales;
    private int[][] matrizTransicion;

    private static final String stringFormat = "Alphabet: %s, Final States: %s, Error States: %s, Minimum: %b";
    
    public AFD(String path) {
        // Lea el archivo y genere su estructura de AFD
        try{
            File archivo = new File(path);
            Scanner leer = new Scanner(archivo);

            if (leer.hasNextLine()) {
                this.alfabeto = leer.nextLine().split(",");
            }

            if (leer.hasNextLine()) {
                this.cantidadEstados = Integer.parseInt(leer.nextLine().trim());
            }

            this.matrizTransicion = new int[this.cantidadEstados][this.alfabeto.length];

            if (leer.hasNextLine()) {
                String[] textoFinal = leer.nextLine().split(",");
                this.estadosFinales = new int[textoFinal.length];
                for (int i=0; i < textoFinal.length; i++){
                    this.estadosFinales[i] = Integer.parseInt(textoFinal[i].trim());

                }
            }

            for (int i=0; i< this.cantidadEstados; i++){

                if (leer.hasNextLine()) {
                    String[] fila = leer.nextLine().split(",");
                    for (int j=0; j < this.alfabeto.length; j++){
                        this.matrizTransicion[i][j] = Integer.parseInt(fila[j].trim());
                    }
                    
                }
            }
            leer.close();

        }catch (Exception e){

        }

    } 

    public boolean accept(String str) {
        // Revisa si la cuerda str es aceptada o no por el AFD
        int estadoActual = 0;

        for (int i = 0; i < str.length(); i++) {
                char caracter = str.charAt(i);
                String letra = String.valueOf(caracter);
                
                int columna = -1;
                for (int j = 0; j < alfabeto.length; j++) {

                    if (alfabeto[j].equals(letra)) {
                        columna = j;
                        break;

                    }
                }
        
        estadoActual = matrizTransicion[estadoActual][columna];
    }

    for (int f : estadosFinales) {
        if (estadoActual == f){
            return true;
        }
    }
    return false;
    }


    public boolean isMin() {
        // Devuelve true si este AFD esta en su forma minima. Falso de lo contrario
        return false;
    }

    public String toString() {
        String alphabet = Arrays.toString(this.getAlphabet());
        String finalStates = Arrays.toString(this.getFinalStates());
        String errorStates = Arrays.toString(this.getErrorStates());
        return String.format(stringFormat, alphabet, finalStates, errorStates, this.isMin());
    }

    private String[] getAlphabet() {
        return this.alfabeto;
    }

    private int[] getFinalStates() {
        return this.estadosFinales;
    }

    private int[] getErrorStates() {
        return new int[]{};
    }

    // Implemente los metodos que desee a partir de aqui

    
}