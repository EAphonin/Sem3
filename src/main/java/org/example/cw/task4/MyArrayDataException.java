package org.example.cw.task4;

import java.util.List;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j) {
        super(String.format("В ячейке [%s][%s] не валидные данные", i,j));
    }

    public MyArrayDataException(List<Point2D> list) {
        super(String.format("В ячейках %s не валидные данные", list));
    }
}
