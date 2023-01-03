package com.study;

public class TypeInferenceDemo {
    public static void main(String[] args) {
        String str = "Hello Lambda";
        StringLengthLambda lengthLambda = (String s) -> s.length();
        printLength(lengthLambda, str);
        //type of input arguments from lambda can be removed as Java can infer it from the interface
        StringLengthLambda lengthLambdaVariant = (s) -> s.length();
        printLength(lengthLambda, str);
        //For lambdas with one argument we can even skip the parenthesis
        StringLengthLambda lengthLambdaVariant2 = s -> s.length();
        printLength(lengthLambda, str);

    }

    private static void printLength(StringLengthLambda lengthLambda, String s) {
        System.out.println(lengthLambda.getLength(s));
    }
}

interface StringLengthLambda {
    public int getLength(String str);

}
