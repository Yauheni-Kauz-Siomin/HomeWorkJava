/*Задание

Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

Пример меню:
1) Добавить контакт
2) Вывести всех
3) Выход

Иванов 123432
Иванов 546457
Иванов 788354

Map<String, ArrayList> ---- {Иванов:[23145, 456745, 56787], Петров:[4325, 45674]}*/


package HomeWork.HomeWorkJava.HomeWork5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class task1 {
    static void sortedPrint(Map<String, ArrayList> map) {

        Set<String> keySet = map.keySet();

        int maxCount = 0;
        int minCount = 1_000_000;
        
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();
            
        }
        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount) {
            // System.out.println(map);
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    st.push(item.getKey());
                }  
            }
            num += 1;
        }
        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        Map<String, ArrayList> abon = new HashMap<>() {
            {
                put("Иванов", new ArrayList<Integer>() {
                    {
                        add(123432);
                        add(546457);
                        add(788354);
                    }
                });
                put("Сидоров", new ArrayList<Integer>() {
                    {
                        add(524312);
                    }
                });
                put("Петров", new ArrayList<Integer>() {
                    {
                        add(924123);
                        add(556221);

                    }
                });
         
            }
        };
        System.out.println();
        System.out.println("Исходные данные: ");
        sortedPrint(abon);

        Scanner scan = new Scanner(System.in, "cp866");
        Boolean getOut = false;
        String st;
        while (!getOut) {
            System.out.println("Введите номер действия (1 - добавить абонента, 2 - выйти из программы):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "1": {
                    System.out.println("Введите фамилию абонента:");
                    name = scan.nextLine();
                    if (abon.containsKey(name)) {
                        System.out.println("Введеная фамилия уже присутсвует в телефонном справочнике!");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую + пробел: ");
                        phString = scan.nextLine();
                        String[] arr = phString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }
                }
                case "2": {
                    getOut = true;
                    System.out.println();
                    System.out.println("Работа закончена!");
                    System.out.println();
                    break;
                }   
                    
               
            }
        }
    }

    
}
