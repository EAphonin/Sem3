package org.example.cw;

import java.io.IOException;

/**
 Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */
public class Counter implements AutoCloseable{
    int i =0;
    boolean closed = false;
    public void add() throws IOException {
        if (closed) throw new IOException("Нет доступа");
        i++;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Вызван метод close");
        closed = true;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "i=" + i +
                '}';
    }
}
class Maine{
    public static void main(String[] args) {
//        Counter counter = new Counter();
//        try {
//            counter.add();
//            System.out.println(counter);
//            counter.close();
//            counter.add();
//        }catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        try(Counter counter = new Counter()) {
            counter.add();
            System.out.println(counter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}