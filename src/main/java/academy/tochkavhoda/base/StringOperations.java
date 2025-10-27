package academy.tochkavhoda.base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Objects;

public class StringOperations
{
    private StringOperations() { }

    // 1
    public static int getSummaryLength(String[] strings) {
        if (strings == null || strings.length == 0) return 0;
        int sum = 0;
        for (String s : strings) {
            if (s != null) sum += s.length();
        }
        return sum;
    }

    // 2
    public static String getFirstAndLastLetterString(String string) {
        if (string == null || string.isEmpty()) return "";
        if (string.length() == 1) {
            char c = string.charAt(0);
            return new String(new char[]{c, c});
        }
        char first = string.charAt(0);
        char last = string.charAt(string.length() - 1);
        return new String(new char[]{first, last});
    }

    // 3
    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (index < 0) return false;
        if (string1 == null || string2 == null) return false;
        if (index >= string1.length() || index >= string2.length()) return false;
        return string1.charAt(index) == string2.charAt(index);
    }

    // 4
    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        if (string1 == null || string2 == null) return false;
        int pos1 = string1.indexOf(character);
        int pos2 = string2.indexOf(character);
        return pos1 != -1 && pos1 == pos2;
    }

    // 5
    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        if (string1 == null || string2 == null) return false;
        int lastIndex1 = string1.lastIndexOf(character);
        int lastIndex2 = string2.lastIndexOf(character);
        return lastIndex1 != -1 && lastIndex1 == lastIndex2;
    }

    // 6. первая встреченная подстрока str с начала — одинаковая позиция
    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        if (string1 == null || string2 == null || str == null) return false;
        int pos1 = string1.indexOf(str);
        int pos2 = string2.indexOf(str);
        return pos1 != -1 && pos1 == pos2;
    }

    // 7. первая встреченная подстрока str при просмотре с конца — одинаковая позиция
    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        if (string1 == null || string2 == null || str == null) return false;
        int last1 = string1.lastIndexOf(str);
        int last2 = string2.lastIndexOf(str);
        return last1 != -1 && last1 == last2;
    }

    // 8. равны ли строки (с учётом null: две null — равны)
    public static boolean isEqual(String string1, String string2) {
        return Objects.equals(string1, string2);
    }

    // 9. равны ли строки без учёта регистра (null-safe)
    public static boolean isEqualIgnoreCase(String string1, String string2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        return string1.equalsIgnoreCase(string2);
    }

    // 10. лексикографически меньше (null считается меньше любой непустой строки; две null — false)
    public static boolean isLess(String string1, String string2) {
        if (string1 == null && string2 == null) return false;
        if (string1 == null) return true;
        if (string2 == null) return false;
        return string1.compareTo(string2) < 0;
    }

    // 11. лексикографически меньше без учёта регистра
    public static boolean isLessIgnoreCase(String string1, String string2) {
        if (string1 == null && string2 == null) return false;
        if (string1 == null) return true;
        if (string2 == null) return false;
        return string1.compareToIgnoreCase(string2) < 0;
    }

    // 12. конкатенация с учётом null
    public static String concat(String string1, String string2) {
        String a = string1 == null ? "" : string1;
        String b = string2 == null ? "" : string2;
        return a + b;
    }

    // 13. начинаются ли обе строки с одного префикса (null-safe)
    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        if (prefix == null) return true;
        if (string1 == null || string2 == null) return false;
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    // 14. заканчиваются ли обе строки одинаковым суффиксом (null-safe)
    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        if (suffix == null) return true;
        if (string1 == null || string2 == null) return false;
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    // 15. самое длинное общее начало двух строк
    public static String getCommonPrefix(String string1, String string2) {
        if (string1 == null || string2 == null) return "";
        int len = Math.min(string1.length(), string2.length());
        int i = 0;
        while (i < len && string1.charAt(i) == string2.charAt(i)) i++;
        return string1.substring(0, i);
    }

    // 16. reverse
    public static String reverse(String string) {
        if (string == null) return null;
        return new StringBuilder(string).reverse().toString();
    }

    // 17. palindrome (case-sensitive)
    public static boolean isPalindrome(String string) {
        if (string == null) return false;
        String rev = reverse(string);
        return string.equals(rev);
    }

    // 18. palindrome ignore case
    public static boolean isPalindromeIgnoreCase(String string) {
        if (string == null) return false;
        String s = string.toLowerCase(Locale.ROOT);
        return isPalindrome(s);
    }

    // 19. longest palindrome ignore case
    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        if (strings == null || strings.length == 0) return "";
        String best = "";
        for (String s : strings) {
            if (s == null) continue;
            if (isPalindromeIgnoreCase(s)) {
                if (s.length() > best.length()) best = s;
            }
        }
        return best;
    }

    // 20. has same substring at index with length
    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (index < 0 || length < 0) return false;
        if (string1 == null || string2 == null) return false;
        if (index + length > string1.length() || index + length > string2.length()) return false;
        return string1.regionMatches(index, string2, index, length);
    }

    // 21. isEqualAfterReplaceCharacters
    public static boolean isEqualAfterReplaceCharacters(
            String string1, char replaceInStr1, char replaceByInStr1,
            String string2, char replaceInStr2, char replaceByInStr2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        String r1 = string1.replace(replaceInStr1, replaceByInStr1);
        String r2 = string2.replace(replaceInStr2, replaceByInStr2);
        return r1.equals(r2);
    }

    // 22. isEqualAfterReplaceStrings
    public static boolean isEqualAfterReplaceStrings(
            String string1, String replaceInStr1, String replaceByInStr1,
            String string2, String replaceInStr2, String replaceByInStr2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        String r1 = (replaceInStr1 == null) ? string1 : string1.replace(replaceInStr1, replaceByInStr1);
        String r2 = (replaceInStr2 == null) ? string2 : string2.replace(replaceInStr2, replaceByInStr2);
        return r1.equals(r2);
    }

    // 23. palindrome after removing spaces ignore case
    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        if (string == null) return false;
        String compressed = string.replace(" ", "").toLowerCase(Locale.ROOT);
        return isPalindrome(compressed);
    }

    // 24. equal after trimming
    public static boolean isEqualAfterTrimming(String string1, String string2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        return string1.trim().equals(string2.trim());
    }

    // 25. makeCsvStringFromInts
    public static String makeCsvStringFromInts(int[] array) {
        if (array == null || array.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(array[i]);
        }
        return sb.toString();
    }

    // 26. makeCsvStringFromDoubles (two decimal places)
    public static String makeCsvStringFromDoubles(double[] array) {
        if (array == null || array.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(",");
            BigDecimal bd = BigDecimal.valueOf(array[i]).setScale(2, RoundingMode.HALF_UP);
            sb.append(bd.toPlainString());
        }
        return sb.toString();
    }

    // 27. makeCsvStringBuilderFromInts
    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        if (array == null || array.length == 0) return sb;
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(array[i]);
        }
        return sb;
    }

    // 28. makeCsvStringBuilderFromDoubles
    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        if (array == null || array.length == 0) return sb;
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(",");
            BigDecimal bd = BigDecimal.valueOf(array[i]).setScale(2, RoundingMode.HALF_UP);
            sb.append(bd.toPlainString());
        }
        return sb;
    }

    // 29. removeCharacters by positions (positions sorted ascending, positions refer to original string indices)
    public static StringBuilder removeCharacters(String string, int[] positions) {
        if (string == null) return new StringBuilder();
        if (positions == null || positions.length == 0) return new StringBuilder(string);
        StringBuilder sb = new StringBuilder();
        int srcIndex = 0;
        int posIdx = 0;
        while (srcIndex < string.length()) {
            if (posIdx < positions.length && positions[posIdx] == srcIndex) {
                posIdx++;
                srcIndex++;
            } else {
                sb.append(string.charAt(srcIndex));
                srcIndex++;
            }
        }
        return sb;
    }

    // 30. insertCharacters: positions and characters arrays have same length, positions non-decreasing
    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        if (string == null) string = "";
        StringBuilder sb = new StringBuilder();
        if (positions == null || characters == null || positions.length == 0) {
            sb.append(string);
            return sb;
        }
        int srcIndex = 0;
        int insertIdx = 0;
        for (int i = 0; i <= string.length(); i++) {
            while (srcIndex < i && srcIndex < string.length()) {
                sb.append(string.charAt(srcIndex));
                srcIndex++;
            }
            while (insertIdx < positions.length && positions[insertIdx] == i) {
                sb.append(characters[insertIdx]);
                insertIdx++;
            }
        }
        while (insertIdx < positions.length) {
            sb.append(characters[insertIdx]);
            insertIdx++;
        }
        return sb;
    }
}
