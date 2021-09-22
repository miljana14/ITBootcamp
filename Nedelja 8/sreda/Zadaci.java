package skup.zadaci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Zadaci {


    /*
    * 1. Zajednicki elementi
    * Za dva zadata niza bojeva vratiti niz onih brojeva koji se nalaze i u jednom i u drugom nizu.
    *
    * NPR:
    * [1, 2, 3, 4, 5], [2, 4, 6, 8, 10] -> [2, 4]
    * */

    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b){
        if(a == null || b == null){
            return null;
        }
        Set<Integer> set1 = new TreeSet<>(a);
        ArrayList<Integer> res = new ArrayList<>();
        for(Integer i: b){
            if (set1.contains(i)){
                res.add(i);
            }
        }
        if(res.isEmpty()){
            return null;
        }
        return res;
    }

    /*
    * 2. Svi elementi
    * Za dva zadata niza brojeva vratiti niz svih brojeva iz oba niza bez ponavljanja.
    * */

    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b){
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }
        if(a.isEmpty() || b.isEmpty()){
            return null;
        }
        a.addAll(b);
        Set<Integer> set = new TreeSet<>(a);
        ArrayList<Integer> list = new ArrayList<>(set);
        return list;
    }

    /*
    * 3. Razlika
    * Za dva zadata niza brojeva vratiti niz onih brojeva koji se nalaze u prvom
    * ali ne i u drugom nizu, bez ponavljanja.
    * */

    public static ArrayList<Integer> razlika(ArrayList<Integer> a, ArrayList<Integer> b) {
        TreeSet<Integer> set = new TreeSet<>(a);
        ArrayList<Integer> arr = new ArrayList<>();
        if(b == null){
            return a;
        }
        if(a.equals(b)){
            return null;
        }
        for (int i: b){
            if (!set.add(i))
                set.remove(i);
        }
        set.removeAll(b);
        arr.addAll(set);
        return arr;
    }

    /*
     * 4. Napisati funkciju koja broji koliko ima duplikata u zadatom nizu.
     *
     * [1, 2, 3, 4, 4, 2, 3, 5, 6] -> 3
     * [1, 2, 3] -> 0
     * [5, 5, 5, 5, 5, 6] -> 4
     * */

    public static int ponavljanjeBroj(int[] arr){
        TreeSet<Integer> skup = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            skup.add(arr[i]);
        }
        int a = arr.length - skup.size();
        return a;
    }

    /*
     * 5. Provera permutacije
     * Za dva zadata niza brojeva proveriti da li moze da se jedan dobije od drugog.
     * Brojevi u nizu se ne ponavljaju
     *
     * NPR:
     * [1, 2, 221, 101], [101, 2, 221, 1] -> da
     * [1, 2, 3], [3, 1, 2, 4] -> ne
     * */

    public static boolean permutacija(ArrayList<Integer> p1, ArrayList<Integer> p2){
        Set<Integer> set1 = new TreeSet<>(p1);
        Set<Integer> set2 = new TreeSet<>(p2);
        if (set1.containsAll(set2) && set1.size() == set2.size()){
            return true;
        }
        return false;
    }


    /*
    * 6. Neuparen element
    * Funkciji se prosledjuje niz ciji se svi elementi ponavljaju tacno dva puta,
    * osim jednog koji se ponavlja samo jednom.
    * Vratiti taj element
    *
    * Npr:
    * [1, 1, 2, 3, 3, 4, 4] -> 2
    * */

    public static int neuparen(int[] arr){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i: arr){
            if (!set.add(i))
                set.remove(i);
        }
        return set.first();
    }


    /*
    * 7. Anagram
    * Funkcija prima 2 String i daje odgovor da/ne u odnosu na to da li je
    * jedan String anagram drugog.
    *
    * NPR:
    * "panta redovno zakasni"
    * "neopravdan izostanak"
    * Da
    * */

    public static boolean anagram(String s1, String s2){

        String str1 = s1.replaceAll("\\s", "");
        String str2 = s2.replaceAll("\\s", "");
        ArrayList<String> test = new ArrayList<>(Arrays.asList(str1, str2));
        TreeSet<String> set1 = new TreeSet<>(test);
        if (str1.length() != str2.length())
            return false;
        if (!set1.contains(str1) && !set1.contains(str2)){
            return false;
        }
        TreeSet<String> set2 = new TreeSet<>();
        set2.add(str1);
        TreeSet<String> set3 = new TreeSet<>();
        set2.add(str2);
        if (!set2.containsAll(set3)){
            return false;
        }
        return true;
    }

}
