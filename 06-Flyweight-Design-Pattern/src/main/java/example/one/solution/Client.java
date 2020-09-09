package example.one.solution;

public class Client {

    public static void main(String [] args){
        WordProcessor wordProcessor=new WordProcessor();

        String text="Hello word processor errrr";
        int length=text.length();

        LetterFactory factory=new LetterFactory();

        for(int i=0;i<length;i++){
            String letterValue=text.substring(i,i+1);

            wordProcessor.addLetter(factory.createLetter(letterValue));
        }

        wordProcessor.printLetters();
    }
}
