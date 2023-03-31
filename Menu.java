import java.util.Scanner;

/**
 * Clase que representa un menú de selección de columna y dirección de
 * ordenamiento.
 */
public class Menu {

    /**
     * Muestra el menú de selección de columna y espera a que el usuario seleccione
     * una opción válida.
     * 
     * @return La cadena de texto que representa la columna seleccionada.
     */
    public String pickColumn() {
        String col = "";
        boolean shouldContinue = true;
        while (shouldContinue) {
            showMenu();
            col = readColumnSelected();
            shouldContinue = col.equals("invalid") ? true : false;
        }
        return col;
    }

    /**
     * Muestra el menú de selección de columna.
     */
    public void showMenu() {
        System.out.println("¿Qué columna desea ordenar?");
        System.out.println("1. fixedAcidity");
        System.out.println("2. volatileAcidity");
        System.out.println("3. citricAcid");
        System.out.println("4. residualSugar");
        System.out.println("5. chlorides");
        System.out.println("6. freeSulfurDioxide");
        System.out.println("7. totalSulfurDioxide");
        System.out.println("8. density");
        System.out.println("9. pH");
        System.out.println("10. sulphates");
        System.out.println("11. alcohol");
        System.out.println("12. quality");
        System.out.println("13. color");
    }

    /**
     * Lee la opción de columna seleccionada por el usuario y devuelve la cadena
     * correspondiente.
     * 
     * @return La cadena de texto que representa la columna seleccionada.
     */
    public String readColumnSelected() {
        Scanner sc = new Scanner(System.in);
        int columnSelected = sc.nextInt();
        switch (columnSelected) {
            case 1:
                System.out.println("Ha seleccionado fixedAcidity");
                return "fixedAcidity";
            case 2:
                System.out.println("Ha seleccionado volatileAcidity");
                return "volatileAcidity";
            case 3:
                System.out.println("Ha seleccionado citricAcid");
                return "citricAcid";
            case 4:
                System.out.println("Ha seleccionado residualSugar");
                return "residualSugar";
            case 5:
                System.out.println("Ha seleccionado chlorides");
                return "chlorides";
            case 6:
                System.out.println("Ha seleccionado freeSulfurDioxide");
                return "freeSulfurDioxide";
            case 7:
                System.out.println("Ha seleccionado totalSulfurDioxide");
                return "totalSulfurDioxide";
            case 8:
                System.out.println("Ha seleccionado density");
                return "density";
            case 9:
                System.out.println("Ha seleccionado pH");
                return "pH";
            case 10:
                System.out.println("Ha seleccionado sulphates");
                return "sulphates";
            case 11:
                System.out.println("Ha seleccionado alcohol");
                return "alcohol";
            case 12:
                System.out.println("Ha seleccionado quality");
                return "quality";
            case 13:
                System.out.println("Ha seleccionado color");
                return "color";
            default:
                System.out.println("Opción no válida");
                return "invalid";
        }
    }

    /**
     * 
     * Muestra el menú de selección de dirección de ordenamiento.
     * Las opciones son: Ascendente y Descendente.
     */
    public void showDirectionsMenu() {
        System.out.println("Qué tipo de orden desea?");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
    }

    /**
     * 
     * Permite al usuario seleccionar la dirección de ordenamiento deseada.
     * Si el usuario ingresa una opción inválida, se le pedirá que lo intente de
     * nuevo.
     * 
     * @return un entero que representa la dirección de ordenamiento: 1 para
     *         Ascendente, 2 para Descendente.
     */
    public int pickDirection() {
        int dir = 0;
        boolean shouldContinue = true;
        while (shouldContinue) {
            showDirectionsMenu();
            dir = readDirectionSelected();
            shouldContinue = dir == 0 ? true : false;
        }
        return dir;
    }

    /**
     * 
     * Lee la dirección de ordenamiento seleccionada por el usuario.
     * Si el usuario ingresa una opción inválida, se le informará y se le pedirá que
     * lo intente de nuevo.
     * 
     * @return un entero que representa la dirección de ordenamiento: 1 para
     *         Ascendente, 2 para Descendente.
     */
    public int readDirectionSelected() {
        Scanner sc = new Scanner(System.in);
        int directionSelected = sc.nextInt();
        switch (directionSelected) {
            case 1:
                System.out.println("ha seleccionado ascendente");
                return 1;
            case 2:
                System.out.println("ha seleccionado descendente");
                return 2;
            default:
                System.out.println("Opción no válida");
                return 0;
        }
    }

}
