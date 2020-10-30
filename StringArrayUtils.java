 
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        if (array == null || array.length == 0) return null;
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        if (array == null || array.length < 2) return null;
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        if (array == null || array.length == 0) return null;
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        if (array == null || array.length < 2) return null;
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        // time: O(n)
        // space: O(1)
        // n is the length of array; ignore the time complexity caused by String length and .equals()
        if (array == null || value == null)
            return false;
        for (String s : array) {
            if (s.equals(value)) return true;
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        // time: O(n)
        // space: O(1)
        // n is the length of array
        if (array == null) return null;
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            String tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++;
            r--;
        }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        // time: O(n)
        // space: O(1)
        // n is the length of array; ignore the time complexity caused by String length and .equals()
        if (array == null) return false;
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            if (!array[l++].equals(array[r--])) return false;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        // time: O(nm)
        // space: O(26) = O(1)
        // n is the length of array, m is the length each String
        if (array == null) return false;
        Set<Character> visited = new HashSet<>();
        for (String s : array) {
            for (int i = 0; i < s.length(); i++) {
                char cur = Character.toLowerCase(s.charAt(i));
                if (cur >= 'a' && cur <= 'z') visited.add(cur);
                if (visited.size() == 26) return true;
            }          
        }
        return visited.size() == 26;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        // time: O(n)
        // space: O(1)
        // n is the length of array; ignore the time complexity caused by String length and .equals()
        if (array == null || value == null) return 0;
        int cnt = 0;
        for (String s : array) {
            if (s.equals(value)) cnt++;
        }
        return cnt;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        // time: O(n)
        // space: O(1)
        // n is the length of array; ignore the time complexity caused by String length and .equals()
        if (array == null || valueToRemove == null) return array;
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                cnt++;
            }
        }
        String[] res = new String[cnt];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                res[index++] = array[i];
            }
        }
        return res;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {     
        // time: O(n)
        // space: O(1)
        // n is the length of array; ignore the time complexity caused by String length and .equals()
        if (array == null) return array;
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || !array[i].equals(array[i - 1])) {
                cnt++;
            }
        }
        String[] res = new String[cnt];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || !array[i].equals(array[i - 1])) {
                res[index++] = array[i];
            }
        }
        return res;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        // time: O(n)
        // space: O(n) for the worst case
        // n is the length of array; ignore the time complexity caused by String length and .equals()
        if (array == null) return array;
        List<String> resList = new ArrayList<>();
        StringBuilder sb = null;
        for (int i = 0; i <= array.length; i++) {
            if (i == 0 || i == array.length || !array[i].equals(array[i - 1])) {
                if (sb != null) resList.add(sb.toString());
                if (i != array.length) sb = new StringBuilder(array[i]);
            } else {
                sb.append(array[i]);
            }
        }
        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
