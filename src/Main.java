import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore " +
                "et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +
                " fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                "mollit anim id est laborum.";
        String text2 = text.toLowerCase(Locale.ROOT);
        int maxValue = -1;
        int minValue = Integer.MAX_VALUE, i;
        char maxChar = 0, minChar = 0;

        Map<Character, Integer> findT = new HashMap<>();
        //приводим текст в набор исимволов
        char[] textChar = text2.toCharArray();

        //перебираем символ и добавляем их как ключ в Map
        for (i = 0; i < textChar.length; i++) {
            char b = textChar[i];
            if ((textChar[i] >= 'a' && textChar[i] < 'z')) {
                if (findT.containsKey(textChar[i])) {
                    findT.put(textChar[i], findT.get(textChar[i]) + 1);
                } else {
                    findT.put(textChar[i], 1);
                }
            }
        }
        System.out.println(findT);

        //находим наибольшее значение символов в тексте
        for (Map.Entry<Character, Integer> entry : findT.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        //находим наименьшее значение вхождения символов в тексте
        for (Map.Entry<Character, Integer> entry : findT.entrySet()) {
            if (minValue > entry.getValue()) {
                minValue = entry.getValue();
                minChar = entry.getKey();
            }
        }
        System.out.println("Наибольшее количество символов в тексте: " + maxValue + "  Символ: " + maxChar);
        System.out.println("Наименьшее количество символов в тексте: " + minValue + "  Символ: " + minChar);
    }
}
