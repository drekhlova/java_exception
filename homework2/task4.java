/*
 Задание 4.
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

package homework2;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        while (true) {
            String text = scanner.nextLine(); 
            if (text.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя!");
            } else {
                System.out.println("Спасибо! Мы приняли Ваши данные.");
                break;
            }
        }
    }
}
