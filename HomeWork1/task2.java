// 2. Вывести все простые числа от 1 до 1000.


package HomeWork.HomeWorkJava.HomeWork1;

public class task2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1001; i++) {
            boolean primeNumber = true;  
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++){
                if ((i % j) == 0) { 
                    primeNumber = false;
                    break;
                }
            }
            if (primeNumber){
                System.out.print(i + " ");
            }
        }
    }
}