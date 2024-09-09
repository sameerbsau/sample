//
///*
//Online Java - IDE, Code Editor, Compiler
//
//Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
//*/
//
// class StringPermutation2
//{
//    public static void main(String[] args) {
//
//        System.out.println("output"+ isPermutation("dog","god"));
//    }
//
//    public static boolean isPermutation(String s, String t){
//        if(s.length() != t.length()){
//            return false;
//        }
//
//        int[] letters = new int[128];
//        for(int i = 0; i< s.length(); i++){
//            int val = s.charAt(i);
//            letters[val]++;
//        }
//
//        for(int i =0; i<t.length(); i++){
//            int val = t.charAt(i);
//            letters[val]--;
//            if(letters[val]<0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//
//
//
//}
