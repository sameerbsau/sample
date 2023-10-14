
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

 class StringPermutation
{
    public static void main(String[] args) {

        System.out.println("output"+ isPermutation("dod","god"));
    }

    public static boolean isPermutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        return sort(s).equals(sort(t));
    }

    static String sort(String s){
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }



}
