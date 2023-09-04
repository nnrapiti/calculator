package com.gmail.nnrapiti.calculator;

public class Calculator {
    public static void main(String[] args){
        int x = getXFromArgs(args);
        int y = getYFromArgs(args);
        String operation = getOperatorFromArgs(args);

        System.out.println(doOperation(x, operation, y));
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
