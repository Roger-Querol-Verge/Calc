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
        history.add(new History(4,'^',2,16));

        char operation = GetOperation();
        int num1 = GetInt(1); //Call to get the first number
        int num2 = GetInt(2); //Call to get the second number
        num2 =DoOperation(num1, num2, operation);
        System.out.println("Hola");

        System.out.println(num1+" "+operation+" "+num2);
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

    private static int DoOperation(int num1, int num2, char operation) {
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

        return num2;
    }
}