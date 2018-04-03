package practice.leetcode.hard;

/**
 * billion, million, thousand
 * ten twenty thirty forth fifty sixty...ninety
 * zero one...nine
 */
public class IntegerToEnglishWords {
    final String[] digits = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "nineteen"};
    final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] units = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                sb.insert(0, units[i] + " ").insert(0, getNumber(num % 1000));
            }
            num /= 1000;
            i++;
        }
        return sb.toString().trim();
    }

    private String getNumber(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return "";
        } else if (n < 20) {
            sb.append(digits[n]).append(" ");
        } else if (n < 100) {
            sb.append(tens[n / 10]).append(" ").append(getNumber(n % 10));
        } else {
            sb.append(digits[n / 100]).append(" Hundred ").append(getNumber(n % 100));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 31) - 1); // 2,147,483,647
        IntegerToEnglishWords it = new IntegerToEnglishWords();
        System.out.println(it.numberToWords(123247890));
    }
}
