/*
Задание.
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных: для упрощения можно все форматы принимать как String.
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m. //char

Приложение должно проверить введенные данные по количеству. 
Если количество не совпадает с требуемым, вернуть код ошибки или бросить исключение, 
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
Можно использовать встроенные типы java и создать свои. 
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.
 */

package homework3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите данные: Фамилия Имя Отчество Дата_рождения (формат dd.mm.yyyy) Номер_телефона (без +7) Пол (f/m)");
            String inputData = scanner.nextLine();
            String[] data = inputData.split(" ");

            //Проверка количества введенных данных
            if (data.length != 6) {
                throw new IllegalArgumentException("Ошибка! Введено неправильное количество данных.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

             /* 
             * Проверка формата даты рождения
             * Regex date format validation on Java:
                ^\d{4}-\d{2}-\d{2}$
             
                as in

                if (str.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    ...
                }
            */
            if (!dateOfBirth.matches("\\d{2}.\\d{2}.\\d{4}")) { 
                throw new IllegalArgumentException("Ошибка! Неверный формат даты рождения.");
            }

            //Проверка формата пола
            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Ошибка! Неверный формат пола.");
            }

            //Создание файла и запись данных в файл
        /* 
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(lastName + ".txt"), "utf-8"))) {
                writer.write(lastName + " " + firstName + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender);
                writer.close();
                System.out.println("Данные успешно записаны в файл.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        */ 

            try (FileWriter writer = new FileWriter (lastName + ".txt", true)) {
                writer.write(lastName + " " + firstName + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender);
                writer.close();
            System.out.println("Данные успешно записаны в файл.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}