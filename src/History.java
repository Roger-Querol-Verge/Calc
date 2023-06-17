public class History {

    private final int num1;
    private final char operation;
    private final int num2;
    private final int result;

    public History(int num1, char operation, int num2, int result) {
        this.num1 = num1;
        this.operation = operation;
        this.num2 = num2;
        this.result = result;
    }

    @Override
    public String toString() {
        return "\n"+num1+" "+operation+" "+num2+" "+"= "+result;
    }
}
