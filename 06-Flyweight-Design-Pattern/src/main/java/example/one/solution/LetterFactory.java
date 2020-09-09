package example.one.solution;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {

    private Map<String, Letter> letterMap=new HashMap<>();

    public Letter createLetter(String key){
        Letter letter=letterMap.get(key);
        if(letter==null){
            letter=new Letter(key);
            letterMap.put(key,letter);
        }
        return letterMap.get(key);
    }


}
