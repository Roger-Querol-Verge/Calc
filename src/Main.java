import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<History> history = new ArrayList<>();
        history.add(new History(4,'+',2,6));
        history.add(new History(4,'-',2,2));
        history.add(new History(4,'*',2,8));
        history.add(new History(4,'/',2,2));
        history.add(new History(4,'^',2,6));

        boolean exit = false;
        do{
            exit = Menu(exit, history);
        }while (!exit);
    }


    public static boolean Menu(boolean exit, ArrayList<History>history){
        int opc_menu = 0;
        System.out.println("\nMain Menu:\n1. Do the operations.\n2. View history\n3. Exit\n");
        opc_menu = ScannerNum(opc_menu);

        switch (opc_menu) {
            case 1 -> {
                char operation = GetOperation(); //Call to get the operation
                int num1 = GetInt(1); //Call to get the first number
                int num2 = GetInt(2); //Call to get the second number
                DoOperation(num1, num2, operation, history); //Call to do the operation
            }
            case 2 -> {
                System.out.println("Calculator History:");
                System.out.println(history); //Print all the operations that you do
            }
            case 3 -> {
                System.out.println("Good bye!");
                exit = true;
            }
            default -> System.out.println("Introduce a number between 1-3");
        }
        return exit;
    }


    //Get the operation
    public static char GetOperation(){
        char[] operations = {'+', '-', '*', '/', '^'};

        System.out.println("Choose an operation (Write the symbol):");

        for (int i = 0; i < operations.length; i++) {
            System.out.println(i+1+". "+ operations[i]);
        }
        return ScannerChar(operations); //Call "char" verification
    }


    //Char Checker
    public static char ScannerChar(char[] operations){
        char ope;
        boolean exist = false;

        if(scanner.hasNext()){
            ope = scanner.next().charAt(0);
        } else {
            System.out.println("ERROR. Introduce a symbol");
            scanner.next();
            ope = GetOperation();
        }

        for (char operation : operations) { //Check if it exists in the array
            if (ope == operation) {
                exist = true;
                break;
            }
        }

        if (!exist){
            System.out.println("ERROR. The symbol doesn't exists");
            ope = GetOperation();
        }
        return ope;
    }


    //Get the numbers
    public static int GetInt(int opc){
        System.out.println("Introduce the number "+opc+":");

        return ScannerNum(opc); //Call number verification
    }


    //Number Checker
    public static int ScannerNum(int opc){
        int num;

        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("ERROR, you need to introduce only a number, try again.");
            scanner.next();
            num = GetInt(opc);
        }
        return num;
    }


    //Division Check
    public static int ScannerDivi(int num2){

        do {
            if (num2 == 0) {
                System.out.println("ERROR. Cannot be divided by 0");
                System.out.println("Change the second number");
                num2 = GetInt(2);
            }
        }while (num2 == 0);

        return num2;
    }


    //Data operation
    private static void DoOperation(int num1, int num2, char operation, ArrayList<History>histories) {
        int result = 0;
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '/' -> {
                num2 = ScannerDivi(num2); //Call to check if you try to divide by 0
                result = num1 / num2;
            }
            case '*' -> result = num1 * num2;
            case '^' -> result = num1 ^ num2;
        }
        System.out.println("\nThe result of "+num1+" "+operation+" "+num2+" is = "+result);
        histories.add(new History(num1,operation,num2,result));
    }
}