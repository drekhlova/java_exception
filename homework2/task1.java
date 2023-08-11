/*
Задание 1.
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float) и возвращает введенное значение. 
Ввод текста вместо числа не должно приводить к падению приложения.
Вместо этого необходимо повторно запросить у пользователя ввод данных. 
*/

package homework2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class task1 {
    public static void main(String[] args) {
        enterNumber();
    }

    public static float enterNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        while (true) {
            try {
                float number = scanner.nextFloat();
                return number;
            }  catch (InputMismatchException e) {
                System.err.println("Введено не дробное число! Введите дробное число: ");
                scanner.next();
            }
        }
    }
}

