
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

 class NiqueStringChars
{
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");
        System.out.println("output"+ isStringUnique("abcdef"));
    }

    public static boolean isStringUnique(String str){
        if(str.length()>128){
            return false;
        }
        boolean[] seen = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(seen[val]){
                return false;
            }

            seen[val] = true;
        }
        return true;
    }
}
