package interview1;

import java.util.Calendar;

public class Test2 {
    public static void main(String[] args) {
        String s1 = "123";
        int a = Integer.parseInt(s1);
        Integer b = Integer.valueOf(s1);
        int c = 123;
        String d = String.valueOf(c);
        String e = Integer.toString(c);
        StringBuilder s = new StringBuilder("abcdefg");
        s.reverse();
        System.out.println(s);
        s.replace(2,4,"a");
        System.out.println(s);
        Calendar time = Calendar.getInstance();
        System.out.println(time.get(Calendar.MONTH));
        System.out.println(time.getTime());

    }


}
