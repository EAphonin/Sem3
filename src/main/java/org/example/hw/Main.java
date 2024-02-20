package org.example.hw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, ДР, Телефон, Пол(f или m)");
        String inputUser = scanner.nextLine();
        String[] dataUser = inputUser.split(" ");

        // Проверка количества введеных данных.
        if (dataUser.length != 6)
            throw new RuntimeException("Данные введены некорректно, введите согласно заданному формату.");

        String lastName = dataUser[0];
        String firstName = dataUser[1];
        String secondName = dataUser[2];
        String birthday = dataUser[3];
        long ph = checkPhoneNumber(dataUser[4]);
        char gender = dataUser[5].charAt(0);

        //Проверка пола.
        if (gender != 'f' && gender != 'm')
            throw new RuntimeException("Пол введен некорректно.");

        // Проверка корректности введеных ФИО (не должны содержать цифры и прочие некорректные символы)
        if (!checkFIO(lastName) || !checkFIO(firstName) || !checkFIO(secondName))
            throw new RuntimeException("ФИО введены некорректно.");

        // Проверка даты рождения
        if (!checkDate(birthday))
            throw new RuntimeException("Неверная дата.");

        Human human = new Human(lastName, firstName, secondName, birthday, ph, gender);
        System.out.println(human);
        writeToFile(human);

    }

    private static long checkPhoneNumber(String number) {
        try {
            long phoneNumber = Long.parseLong(number);
            return phoneNumber;
        } catch (NumberFormatException e) {
            throw new RuntimeException(" Введен неверный формат телефона.");
        }
    }

    private static boolean checkFIO(String str) {
        return str.matches("[a-zA-zа-яА-я]+");
    }

    private static boolean checkDate(String birthday) {
        return birthday.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    private static void writeToFile(Human human) {
        String filename = human.getLastName() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(human.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Успешно записано");
    }
}
