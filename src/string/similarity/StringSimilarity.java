package string.similarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author erdmcagri
 */
public class StringSimilarity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {

            String firstInput = "";
            String secondInput = "";

            System.out.println("İlk string ifadeyi giriniz:");
            firstInput = scan.next();

            System.out.println("İkinci string ifadeyi giriniz:");
            secondInput = scan.next();

            boolean controlFirst = firstInput.isEmpty();
            boolean controlSecond = secondInput.isEmpty();

            if (!controlFirst || !controlSecond) {
                firstInput = firstInput.toLowerCase();
                secondInput = secondInput.toLowerCase();

                System.out.println("Result -> " + calculateSimilarity(firstInput, secondInput) + "\n");

                System.out.println("Devam etmek istiyor musunuz? Evet : 1 Hayır : 0 ");
                try {
                    int state = scan.nextInt();

                    boolean res = isNumber(String.valueOf(state));
                    if (res == true) {
                        if (state == 0) {
                            break;
                        } else if (state == 1) {
                            continue;
                        } else {
                            System.out.println("Yanlış bir giriş yaptınız.");
                            break;
                        }
                    } else {
                        System.out.println("Yanlış bir giriş yaptınız.");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Yanlış bir giriş yaptınız.");
                    break;
                }

            } else {
                System.out.println("Yanlış bir giriş yaptınız.");
            }

        }

    }

    public static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))
                    == false) {
                return false;
            }
        }

        return true;
    }

    public static boolean calculateSimilarity(String first, String second) {
        boolean state = false;
        int sum = 0;

        List firstList = new ArrayList();
        List secondList = new ArrayList();

        for (int i = 0; i < first.length(); i++) {
            if (!firstList.contains(first.charAt(i))) {
                firstList.add(first.charAt(i));
            }
        }

        for (int i = 0; i < second.length(); i++) {
            if (!secondList.contains(second.charAt(i))) {
                secondList.add(second.charAt(i));
            }
        }
        if (firstList.size() < secondList.size()) {
            state = true;
        }

        int res = calculateReverse(state, firstList, secondList);

        if (res > 70) {
            return true;
        } else {
            return false;

        }

    }

    public static int calculateReverse(boolean state, List firstList, List secondList) {
        int sum = 0;
        int count = 0;
        if (state) {
            for (int i = 0; i < secondList.size(); i++) {
                for (int j = 0; j < firstList.size(); j++) {
                    if (secondList.get(i).equals(firstList.get(j))) {
                        count++;
                        break;
                    }
                }
            }
            sum = (int) ((float) count / secondList.size() * 100);

            return sum;
        } else {

            for (int i = 0; i < firstList.size(); i++) {
                for (int j = 0; j < secondList.size(); j++) {
                    if (firstList.get(i).equals(secondList.get(j))) {
                        count++;
                        break;
                    }
                }
            }
            sum = (int) ((float) count / firstList.size() * 100);

            return sum;
        }
    }

}
