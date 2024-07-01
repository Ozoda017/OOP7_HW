package less7.services;

import java.util.Scanner;

import less7.domen.ComplexNumber;

public class App {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ComplexNumber num1 = new ComplexNumber(6.0, 5.0); // число 1.
            ComplexNumber num2 = new ComplexNumber(2.0, 2.0); // число 2.

            Calculator calculator = new Calculator(); 

            Logger.log("Select the operation:");
            Logger.log("1 - +");
            Logger.log("2 - -");
            Logger.log("3 - *");
            Logger.log("4 - /");

            int choice = input.nextInt(); // обработка ввода 

            switch (choice) { // проверка введенных данных
                case 1 -> calculator.setOperation(new ComplexOperation() {
                    @Override
                    public ComplexNumber operate(ComplexNumber num1, ComplexNumber num2) {
                        return num1.add(num2);
                    }
                });
                case 2 -> calculator.setOperation(new ComplexOperation() {
                    @Override
                    public ComplexNumber operate(ComplexNumber num1, ComplexNumber num2) {
                        return num1.subtract(num2);
                    }
                });
                case 3 -> calculator.setOperation(new ComplexOperation() {
                    @Override
                    public ComplexNumber operate(ComplexNumber num1, ComplexNumber num2) {
                        return num1.multiply(num2);
                    }
                });
                case 4 -> calculator.setOperation(new ComplexOperation() {
                    @Override
                    public ComplexNumber operate(ComplexNumber num1, ComplexNumber num2) {
                        return num1.divide(num2);
                    }
                });
                default -> Logger.log("Incorrect operation selection.");
            }
            calculator.executeOperation(num1, num2);
        }
    }

}
