import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B29 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());

        String[][] preparedInput = new String[n][];

        for (int i = 0; i < n; i++) {
            String text = reader.readLine().trim();
            String[] temp = new String[text.length() + 1];

            for (int j = 0; j < text.length(); j++) {
                temp[j] = text.substring(0, j) + text.substring(j + 1);
            }
            temp[text.length()] = text;

            preparedInput[i] = temp;
        }

        long answer = 0L;

        for (int seg = 0; seg <= preparedInput[0].length - 1; seg++) {
            Set<String> suffixesSet = new HashSet<>();
            Map<String, Long> suffixCount = new HashMap<>();
            Set<String> words = new HashSet<>();
            Map<String, Long> wordRepeats = new HashMap<>();

            for (String[] row : preparedInput) {
                String suffix = row[seg];
                String originalWord = row[row.length - 1];

                if (suffixesSet.contains(suffix)) {
                    long repeatCount = 0L;

                    if (words.contains(originalWord)) {
                        repeatCount = wordRepeats.getOrDefault(originalWord, 0L);
                    }

                    answer += (suffixCount.get(suffix) - repeatCount);
                } else {
                    suffixesSet.add(suffix);
                }

                suffixCount.put(suffix, suffixCount.getOrDefault(suffix, 0L) + 1L);
                words.add(originalWord);
                wordRepeats.put(originalWord, wordRepeats.getOrDefault(originalWord, 0L) + 1L);
            }
        }

        System.out.println(answer);
    }
}
