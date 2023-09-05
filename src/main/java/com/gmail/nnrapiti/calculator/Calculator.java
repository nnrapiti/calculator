package com.gmail.nnrapiti.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        String[] arguments = getInputFromUser().toArray(new String[0]);

        int x = getXFromArgs(arguments);
        int y = getYFromArgs(arguments);
        String operation = getOperatorFromArgs(arguments);

        System.out.println("Result = " + doOperation(x, operation, y));
    }

    private static List<String> getInputFromUser() {
        List<String> arguments = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String operation = "UNKNOWN";

        System.out.print("Please enter First Number: ");
        arguments.add(String.valueOf(scanner.nextInt()));
        System.out.println();
        while (operation.equalsIgnoreCase("UNKNOWN")) {
            System.out.println();
            System.out.print("Please enter Operation:");
            int op = scanner.nextInt();
            operation = switch (op){
                case 1 -> "ADD";
                case 2 -> "SUBTRACT";
                case 3 -> "MULTIPLY";
                case 4 -> "DIVIDE";
                default -> "UNKNOWN";
            };
            System.out.println("OPERATION SELECTED: " + operation);
        }
        arguments.add(operation);

        System.out.println();
        System.out.print("Please enter Second Number: ");
        arguments.add(String.valueOf(scanner.nextInt()));

        scanner.close();
        return arguments;
    }

    public static int addNumbers(int x, int y){
        return x + y;
    }
    public static int subtractNumbers(int x, int y){
        return x - y;
    }
    public static int multiplyNumbers(int x, int y){
        return x * y;
    }
    public static int divideNumbers(int x, int y){
        return x / y;
    }

    public static int getXFromArgs(String[] args){
        return getNumberFromStringArray(args);
    }
    public static String getOperatorFromArgs(String[] args){
        for(String arg: args){
            try{
                Integer.parseInt(arg);
            }catch (NumberFormatException e){
                return arg;
            }
        }
        return "ADD";
    }

    public static int getYFromArgs(String[] args){
        int index = 0;
        for(String arg: args){
            try{
                Integer.parseInt(arg);
            }catch (NumberFormatException e){
                index++;
                break;
            }
            index++;
        }
        String[] argsYSubset = new String[args.length-index];
        System.arraycopy(args, index, argsYSubset, 0, args.length-index);
        return getNumberFromStringArray(argsYSubset);
    }

    public static int getNumberFromStringArray(String[] numbers){
        StringBuilder fullNumber = new StringBuilder();
        for(String number: numbers){
            try{
                Integer.parseInt(number);
            }catch (NumberFormatException e){
                break;
            }
            fullNumber.append(number);
        }
        return Integer.parseInt(fullNumber.toString());
    }

    public static int doOperation(int x, String operation, int y){
        return switch (operation){
            case "ADD" -> addNumbers(x, y);
            case "SUBTRACT" -> subtractNumbers(x, y);
            case "MULTIPLY" -> multiplyNumbers(x, y);
            case "DIVIDE" -> divideNumbers(x, y);
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }


}
