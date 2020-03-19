 /* ----------------------------------------
   Polish Notation (Postfix Notation) Solver
   ----------------------------------------
   Author: Daniel J. Stout II
   Date: 3/17/2020
   ----------------------------------------
 */

import java.io.*;
import java.util.*;

public class Postfix {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(new File("postfix.dat"));
        ArrayList<String> list = new ArrayList<>();

        while (f.hasNextLine())
            list.add(f.nextLine());

        for (String str : list)
            System.out.println(postfix(str));
    }

    private static int postfix(String str) {
        String[] arr = str.split("t?[ ]");
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, arr);

        while (arrayList.size() != 1) {
            for (int i = 2; i < arrayList.size(); i++) {
                String str1 = arrayList.get(i);
                String str2 = arrayList.get(i - 1);
                String str3 = arrayList.get(i - 2);

                if (!str1.matches("t?[-+/*]") || str2.matches("t?[-+/*]"))
                    continue;

                int num1 = Integer.parseInt(str3);
                int num2 = Integer.parseInt(str2);

                for (int j = 0; j < 2; j++)
                    arrayList.remove(i - 1);

                switch (str1) {
                    case "+": arrayList.set(i - 2, String.valueOf(num1 + num2)); break;
                    case "-": arrayList.set(i - 2, String.valueOf(num1 - num2)); break;
                    case "*": arrayList.set(i - 2, String.valueOf(num1 * num2)); break;
                    case "/": arrayList.set(i - 2, String.valueOf(num1 / num2)); break;
                    default: break;
                }
            }
        }

        return Integer.parseInt(arrayList.get(0));
    }
}
