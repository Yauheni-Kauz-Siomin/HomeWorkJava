/*Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка.
Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1] - пример Deque
[5,4,3]- пример второго Deque
1) 123 * 345 = 42 435
Ответ всегда - связный список, в обычном порядке
[4,2,4,3,5] - пример ответа*/



package HomeWork.HomeWorkJava.HomeWork4;
import java.util.*;
public class task1 {
    public static void main(String[] args) {

        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        deque1.add(1);
        deque1.addFirst(2);
        deque1.addFirst(3);

        deque2.add(3);
        deque2.addFirst(4);
        deque2.addFirst(5);

        Scanner scanner = new Scanner(System.in);
        System.out.println(deque1);
        System.out.println(deque2);
        System.out.println("Выберите команду: 1 - умножение, 2 - сложение");
        int command = scanner.nextInt();

        switch (command) {
            case 1:
                Deque<Integer> result1 = multiply(deque1, deque2);
                System.out.println("Произведение: " + result1);
                break;
                
            case 2:
                Deque<Integer> result2 = add(deque1, deque2);
                System.out.println("Сумма: " + result2);
                break;
            default:
                System.out.println("Неверная команда");
        }
    }

    public static Deque<Integer> multiply(Deque<Integer> deque1, Deque<Integer> deque2) {
        
        int num1 = dequeToNum(deque1);
        int num2 = dequeToNum(deque2);

        int product = num1 * num2;

        return numToDeque(product);
    }

    public static Deque<Integer> add(Deque<Integer> deque1, Deque<Integer> deque2) {
        
        int num1 = dequeToNum(deque1);
        int num2 = dequeToNum(deque2);

        int sum = num1 + num2;

        return numToDeque(sum);
    }

    public static int dequeToNum(Deque<Integer> deque) {
        int num = 0;
        int multiplier = 1;

        while (!deque.isEmpty()) {
            int digit = deque.removeFirst();
            num += digit * multiplier;
            multiplier *= 10;
        }

        return num;
    }

    public static Deque<Integer> numToDeque(int num) {
        Deque<Integer> deque = new LinkedList<>();
 
        while (num > 0) {
            int digit = num % 10;
            deque.addFirst(digit);
            num /= 10;
        }

        return deque;
    }
}