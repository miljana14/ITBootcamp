package strimovi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DomaciNedelja9 {
//
//    Sve brojeve deljive sa 3 uvecati za 2
//    Izbaciti sve brojeve koji su deljivi sa 3 prilikom njihovog dupliranja
//    Pomnoziti svaki neparan broj sa 2 i izbaciti duplikate

    public static int divisionWith3(int num){
        if(num % 3 == 0){
            return num + 2;
        }
        return num;
    }

    public static Set<Integer> list (List<Integer> numbers){
        List<Integer> list1 =  numbers.stream().
                map(DomaciNedelja9::divisionWith3
                ).collect(Collectors.toList());
 //       System.out.println(list1);
        List<Integer> list2 =  list1.stream().
                        filter(x -> x % 3 != 0
                        ).collect(Collectors.toList());
  //      System.out.println(list2);
        return list2.stream().
                map(x -> {
                    if (x % 2 != 0) {
                        return x * 2;
                    } else {
                        return x;
                    }
                }).collect(Collectors.toSet());
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,5,3,6,4,3,9);
        System.out.println(list(numbers));
    }
}
