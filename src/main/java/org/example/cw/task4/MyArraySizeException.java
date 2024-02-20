package org.example.cw.task4;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super ("Массив неверной длины.");
    }
}
