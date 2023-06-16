public class History {

    private int num1;
    private char operation;
    private int num2;
    private int result;

    public History(int num1, char operation, int num2, int result) {
        this.num1 = num1;
        this.operation = operation;
        this.num2 = num2;
        this.result = result;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResult(){
        return result;
    }

    public void setResult(int result){
        this.result = result;
    }

    @Override
    public String toString() {
        return "Calc_History: "+num1+" "+operation+" "+num2+" "+"= "+result+"\n";
    }
}
