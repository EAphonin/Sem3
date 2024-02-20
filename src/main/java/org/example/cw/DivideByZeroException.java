package org.example.cw;

import java.io.FileReader;

/**
 * Задание 3.1
 * Создайте класс исключения, который будет выбрасываться при делении на 0.
 * Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException(String s) {
        super(s);
    }
}

class Main {
    public static void fileNotFoundEx(String path) throws Exception {
        FileReader fileReader = new FileReader(path);
    }

    public static void main(String[] args) {
//        try {
//            int x = 4 / 0;
//        } catch (ArithmeticException e) {
//            throw new DivideByZeroException("Деление на 0");
//        }
        try {
            fileNotFoundEx("sdfsdf");
        } catch (Exception e) {
            try {
                throw new NonExistedFileException("file not found");
            } catch (NonExistedFileException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }

}