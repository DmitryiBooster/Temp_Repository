package org.example;

import java.math.BigDecimal;

public class Temp_Solution {

    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 1
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    // 2
    public static void printMatrix(int m, int n, Byte value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 3
    public static void printMatrix(int m, int n, Short value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 4
    public static void printMatrix(int m, int n, Integer value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 5
    public static void printMatrix(int m, int n, Long value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 6
    public static void printMatrix(int m, int n, Float value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 7
    public static void printMatrix(int m, int n, Double value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 8
    public static void printMatrix(int m, int n, Character value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // 9
    public static void printMatrix(int m, int n, Boolean value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    // 10
    public static void printMatrix(int m, int n, BigDecimal value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

}
