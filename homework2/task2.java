/* 
Задание 2. 
Если необходимо, исправьте данный код 

try {
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
     } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
     }
*/

/*
 * Решение:
 1. В исходном коде не дан массив - задаем массив из 8 элементов.
 2. d = 0, но делить на 0 нельзя. При этом в исходном коде исключение ArithmeticException. 
 Таким образом, выпоняя деление на d = 0, мы будем получать соответсвующую ошибку. 
 Но по исходному коду d всегда равно 0 и у нас всегда будет эта ошибка. Поэтому знаменатель вводим вручную.
 3. 
 */
package homework2;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите знаменатель: ");
        try {
            int d = scanner.nextInt(); 
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}

