import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoChar {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        //todo add read int
        int w1 = scan.nextInt();
        String s = scan.next();
        //String s = "beabeefeab";

        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(char ch : s. toCharArray()){
            if(!list.contains(ch))
                list.add(ch);
        }
        for(int i = 0; i < list.size()-1; i++){
            for(int j = i+1; j < list.size(); j++){
                //System.out.println(list.get(i) + " " + list.get(j));
                String reg = "[^("+list.get(i)+"|"+list.get(j)+")]";
                String newS = s.replaceAll(reg, "");

                ArrayList<Character> chs = new ArrayList<>();

                for(char ch : newS.toCharArray()){
                    if(!chs.contains(ch))
                        chs.add(ch);
                    if(chs.size() == 2)
                        break;
                }

                //System.out.println (chs.toString());
                String regex = "(["+chs.get(0)+"]["+chs.get(0)+"])|(["+chs.get(1)+"]["+chs.get(1)+"])";
                if(newS.length() == newS.replaceAll(regex,"").length()){
                    //System.out.println(newS.replaceAll(regex,""));
                    res.add(newS.length());
                }
            }
        }
        Collections.sort(res);
        System.out.println(res.size() == 0 ? 0 : res.get(res.size()-1));
        //System.out.println(list.toString());
    }
}
