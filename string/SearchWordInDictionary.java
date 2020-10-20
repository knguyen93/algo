package string;

import java.util.*;
import java.util.stream.Collectors;

public class SearchWordInDictionary {
    /**
     * letter: aik
     * 
     * dictionary: ["khanh", "khai", "kilo", "han"]
     */

    static Set<String> predict(List<String> dictionaries, String word) {
        List<String> results = new ArrayList<>();
        permute(word.toCharArray(), results, 0);
        
        return dictionaries
        .stream()
        .filter(w -> results.stream().filter(p -> w.contains(p)).findAny().isPresent())
        .collect(Collectors.toSet());
    }

    static void permute(char[] letters, List<String> results, int i) {
        if (i == letters.length) {
            results.add(String.valueOf(letters));
        } else {
            for (int j=i; j < letters.length; j++) {
                swap(letters, i, j);
                permute(letters, results, i + 1);
                swap(letters, i, j);
            }
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<String> dictionaries = Arrays.asList("khanh", "khai", "kilo", "han");
        System.out.println(predict(dictionaries, "ahk"));
    }
}
