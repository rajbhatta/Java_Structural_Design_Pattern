package example.one.problem;

public class Client {

    public static void main(String [] args){
        WordProcessor wordProcessor=new WordProcessor();

        String text="Hello word processor";
        int length=text.length();

        for(int i=0;i<length;i++){
            String letterValue=text.substring(i,i+1);
            wordProcessor.addLetter(new Letter(letterValue));
        }

        wordProcessor.printLetters();
    }
}
