// Esta es su clase principal.
// Debe implementar todos los metodos aqui listados.
// No cambie la firma del constructor ni de los metodos ya creados.
// Puede crear cualquier metodo extra que desee
import java.util.Arrays;

public class AFD {
    private static final String stringFormat = "Alphabet: %s, Final States: %s, Error States: %s, Minimum: %b";

    public AFD(String path) {
        // Lea el archivo y genere su estructura de AFD
    }

    public boolean accept(String str) {
        // Revisa si la cuerda str es aceptada o no por el AFD
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
        return new String[0];
    }

    private int[] getFinalStates() {
        return new int[0];
    }

    private int[] getErrorStates() {
        return new int[0];
    }

    // Implemente los metodos que desee a partir de aqui
}
