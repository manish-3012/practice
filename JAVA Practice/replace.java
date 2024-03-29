package com.advancedJava;

class replace {
    public static void main(String[] args) {
        String str = "newbie", replace="new";
        String replaceTo = "programmer";

        int position = 0;
        int len = replace.length();
        String new_string = str.substring(0, position) + replaceTo +
                str.substring(position+len);
        System.out.println(new_string);
    }
}