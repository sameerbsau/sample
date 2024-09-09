package misc;
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

 class StringOneEdit
{
    public static void main(String[] args) {

        System.out.println("output"+ isOneEditaway("pale","pal"));
    }

    public static boolean isOneEditaway(String s, String t){

        int len1 = s.length();
        int len2 = t.length();

        if(Math.abs(len1 - len2) > 1){
            return false;
        }

        int edits = 0;
        int i =0, j=0;

        while(i < len1 && j < len2){

            if(s.charAt(i) != t.charAt(j)){
                edits++;

                if(edits>1){
                    return false;
                }

                if(len1 == len2){
                    i++;
                    j++;

                }
                else if(len1 > len2){
                    i++;
                }else{
                    j++;
                }

            }else{
                i++;
                j++;
            }
        }
        if(i < len1 || j < len2){
            edits++;
        }
        return edits <=1;
    }

}






