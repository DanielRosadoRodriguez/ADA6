import java.util.Scanner;

public class Menu {

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

    public void showMenu() {
        System.out.println("qué columna desea ordenar?");
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

    public String readColumnSelected() {
        Scanner sc = new Scanner(System.in);
        int columnSelected = sc.nextInt();
        switch (columnSelected) {
            case 1:
                System.out.println("ha seleccionado fixedAcidity");
                return "fixedAcidity";
            case 2:
                System.out.println("ha seleccionado volatileAcidity");
                return "volatileAcidity";
            case 3:
                System.out.println("ha seleccionado citricAcid");
                return "citricAcid";
            case 4:
                System.out.println("ha seleccionado residualSugar");
                return "residualSugar";
            case 5:
                System.out.println("ha seleccionado chlorides");
                return "chlorides";
            case 6:
                System.out.println("ha seleccionado freeSulfurDioxide");
                return "freeSulfurDioxide";
            case 7:
                System.out.println("ha seleccionado totalSulfurDioxide");
                return "totalSulfurDioxide";
            case 8:
                System.out.println("ha seleccionado density");
                return "density";
            case 9:
                System.out.println("ha seleccionado pH");
                return "pH";
            case 10:
                System.out.println("ha seleccionado sulphates");
                return "sulphates";
            case 11:
                System.out.println("ha seleccionado alcohol");
                return "alcohol";
            case 12:
                System.out.println("ha seleccionado quality");
                return "quality";
            case 13:
                System.out.println("ha seleccionado color");
                return "color";
            default:
                System.out.println("Opción no válida");
                return "invalid";
        }
    }

    public void showDirectionsMenu() {
        System.out.println("Qué tipo de orden desea?");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
    }

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


    public boolean shouldContinue() {
        int exit = 0;
        boolean shouldContinue = true;
        while (shouldContinue) {
            showExitMenu();
            exit = readExitMenu();
            shouldContinue = exit == 0 ? true : false;
        }
        return exit == 2 ? false: true;
    }
    public void showExitMenu(){
        System.out.println("Desea continuar?");
        System.out.println("1. Si");
        System.out.println("2. No");
    }
    public int readExitMenu(){
        Scanner sc = new Scanner(System.in);
        int exitSelected = sc.nextInt();
        sc.close();
        switch (exitSelected) {
            case 1:
                System.out.println("ha seleccionado continuar");
                return 1;
            case 2:
                System.out.println("gracias por usar los metodos de ordenamiento");
                return 2;
            default:
                System.out.println("Opción no válida");
                return 0;
        }
    }
}
