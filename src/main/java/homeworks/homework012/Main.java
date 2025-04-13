package homeworks.homework012;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Main {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите следующие данные через пробел: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол Возраст");
        String input = scanner.nextLine();

        try {
            List<String> fields = parseInput(input);
            Person person = createPerson(fields);
            writeToFile(person);
        } catch (InvalidDataException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<String> parseInput(String input) throws InvalidDataException {
        String[] parts = input.split("\\s+");
        if (parts.length != 7) {
            throw new InvalidDataException("Количество полей не соответствует требованиям");
        }
        return List.of(parts);
    }

    private static Person createPerson(List<String> fields) throws InvalidDataException {
        String surname = fields.get(0);
        String name = fields.get(1);
        String patronymic = fields.get(2);
        LocalDate dateOfBirth = parseDate(fields.get(3));
        long phoneNumber = parsePhoneNumber(fields.get(4));
        char gender = parseGender(fields.get(5));
        int age = parseAge(fields.get(6));

        return new Person(surname, name, patronymic, dateOfBirth, phoneNumber, gender, age);
    }

    private static LocalDate parseDate(String dateString) throws InvalidDataException {
        try {
            return LocalDate.parse(dateString, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidDataException("Неверный формат даты рождения", e);
        }
    }

    private static long parsePhoneNumber(String phoneNumberString) throws InvalidDataException {
        try {
            return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат номера телефона", e);
        }
    }

    private static char parseGender(String genderString) throws InvalidDataException {
        if (!genderString.matches("[fmFM]")) {
            throw new InvalidDataException("Пол должен быть указан символом 'f' или 'm'");
        }
        return genderString.charAt(0);
    }

    private static int parseAge(String ageString) throws InvalidDataException {
        try {
            return Integer.parseInt(ageString);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Возраст должен быть целым числом", e);
        }
    }

    private static void writeToFile(Person person) throws IOException {
        File file = new File(person.getSurname() + ".txt");
        List<String> existingLines = readExistingLines(file);
        List<String> updatedLines = updateLines(existingLines, person);
        writeLines(updatedLines, file);
    }

    private static List<String> readExistingLines(File file) throws IOException {
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return Files.readAllLines(Paths.get(file.toURI()));
    }

    private static List<String> updateLines(List<String> existingLines, Person person) {
        String line = String.join(" ", person.getSurname(), person.getName(), person.getPatronymic(),
                person.getDateOfBirth().format(DATE_FORMATTER), String.valueOf(person.getPhoneNumber()),
                String.valueOf(person.getGender()), String.valueOf(person.getAge()));
        existingLines.add(line);
        return existingLines;
    }

    private static void writeLines(List<String> lines, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    private static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }

        public InvalidDataException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
