package java_8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSample {

    /**
     * Sample: str (this is my first program which is cool)
     * => this: 1, is: 2, my: 1, first: 1, program: 1, cool: 1
     */
    static Map<String, Long> countingOccurence(String str) {
        return Arrays.asList(str.split(" "))
        .stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Sample: word (TYPE) => Type, type, tYpe, ...
     */
    static Map<String, Long> countingOccurenceOfAWordCaseInsensitive(String str, String word) {
        return Arrays.asList(str.split(" "))
        .stream()
        .filter(w -> word.toLowerCase().equals(w.toLowerCase()))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    static Integer sumArrayOfNumbers(int[] nums) {
        return IntStream.of(nums).sum();
    }

    public static void main(String[] args) {
        String str = "Lorem Ipsum is simply dummy tExt of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy teXt ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a Type specimen book";

        System.out.println(countingOccurence(str));
        System.out.println(countingOccurenceOfAWordCaseInsensitive(str, "text"));
        System.out.println(sumArrayOfNumbers(new int[] {1,4,5,6,4,3,53,3,3,3,3,3,3,3,3}));
    }
}
