// Online Java Compiler
// Use this editor to write, compile and run your Java code online
 class Stringurlify {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(urlify("Hello, World!   "));
    }

    public static String urlify(String input){
        int spaces = 0;
        String finalString = "";
        char[] inputChars = input.toCharArray();

        for(char c : inputChars){
            if(c == ' '){
                spaces++;
            }
        }

        int finalStringlength = input.length()+ spaces *2;
        char[] finalchar = new char[finalStringlength];
        int index = 0;
        for(char c : inputChars){
            if(c == ' '){
                finalchar[index++] = '%';
                finalchar[index++] = '2';
                finalchar[index++] = '0';
            }
            else{
                finalchar[index++] = c;
            }
        }

        System.out.println(spaces);
        return new String(finalchar);
    }
}