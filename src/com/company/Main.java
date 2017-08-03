package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.company.Human.Gender;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) throws ParseException {
        List<Human> humanList = new ArrayList<>();
        /*
        humanList.add(new Human("Иванов","Иван","Иванович",
                Gender.male,dateFormat.parse("1.1.2001")));
        humanList.add(new Human("Степанова","Светлана","Степановна",
                Gender.female,dateFormat.parse("2.2.2002")));
        humanList.add(new Human("Горбунков","Семён","Семёнович",
                Gender.male,dateFormat.parse("31.12.2000")));
        */
        boolean flag = true;
        do {
            try {
                Human human = createHuman();
                humanList.add(human);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("Введите д для продолжения или любой другой символ для выхода");
            flag = scanner.nextLine().equals("д");
        } while (flag);

        showHumans(humanList);
    }

    private static Human createHuman() throws ParseException {
        System.out.print("Введите фамилию: ");
        String familyName = scanner.nextLine();
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите отчество: ");
        String fatherName = scanner.nextLine();
        System.out.print("Введите дату рождения в формате ДД.ММ.ГГГГ :");
        Date birthDate = dateFormat.parse(scanner.nextLine());
        System.out.print("Введите пол (М или Ж): ");
        String strGender = scanner.nextLine();
        Gender gender = strGender.equals("М")
                ? Gender.male : strGender.equals("Ж")
                ? Gender.female : null;
        return new Human(familyName, name, fatherName, gender, birthDate);
    }

    private static void showHumans(List<Human> humanList) {
        System.out.println("Количество людей: " + humanList.size());
        for (Human human : humanList) {
            System.out.println("ФИО: " + human.getFullName() +
            ", пол: " + human.getGender().description +
            " дата рождения: " + dateFormat.format(human.getBirthDate()));
        }
    }
}
