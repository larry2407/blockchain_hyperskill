package blockchain;

import java.util.Date;

public class StringUtilDemo {

    public static void main(String[] args) {

        String larry = "Laurent Élior";
        long timeStamp = new Date().getTime();
        String name = larry.concat(String.valueOf(timeStamp));

        String hashResult = StringUtil.applySha256(name);

        System.out.println(hashResult);
        System.out.println(hashResult.length());

    }

}
