package com.company;

public class Main {

    public static void main(String[] args) {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10) {
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

        String str = "abcdefg";
        //put a break point on the below line. If you debug, and then choose "step into", it will
        // go into the addSuffix method. If you choose smart step into (shift + F7), you can choose which of the two
        // methods on the line you want to step into
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}
