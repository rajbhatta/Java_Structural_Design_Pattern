## Introduction about flyweight design pattern ##
- Flyweight design pattern is used to reduce the number of the objects created and decrease memory footprint and increase performance.

## Example in Java ###
```java
Integer firstInt = Integer.valueOf(5);

```
From above method, when we call valueOf() then it checks that object, if object exists then it will return the object else create and return it.


### Problem ###
```java
package example.one.problem;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private List<Letter> letters=new ArrayList<>();

    public void addLetter(Letter letter){
        this.letters.add(letter);
    }

    public void printLetters(){
        for(Letter letter:letters){
            System.out.print(letter.getValue());
        }
    }
}

```

```java
package example.one.problem;

public class Letter {

    private String value;

    public Letter(String value) {

        this.value = value;
        System.out.println("New letter created with value: \t"+value);
    }

    public String getValue() {
        return value;
    }
}

```

```java
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

```

Once running above program, we can see that 
```java
New letter created with value: 	H
New letter created with value: 	e
New letter created with value: 	l
New letter created with value: 	l
New letter created with value: 	o
New letter created with value: 	 
New letter created with value: 	w
New letter created with value: 	o
New letter created with value: 	r
New letter created with value: 	d
New letter created with value: 	 
New letter created with value: 	p
New letter created with value: 	r
New letter created with value: 	o
New letter created with value: 	c
New letter created with value: 	e
New letter created with value: 	s
New letter created with value: 	s
New letter created with value: 	o
New letter created with value: 	r
Hello word processor
```
We can see that New letter is created for duplicate words such as (s), (r), (o).

### Solution ###
```java
package example.one.solution;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private List<Letter> letters=new ArrayList<>();

    public void addLetter(Letter letter){
        this.letters.add(letter);
    }

    public void printLetters(){
        for(Letter letter:letters){
            System.out.print(letter.getValue());
        }
    }
}

```

```java
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

```

```js
package example.one.solution;

public class Letter {

    private String value;

    public Letter(String value) {

        this.value = value;
        System.out.println("New letter created with value: \t"+value);
    }

    public String getValue() {
        return value;
    }
}

```


```java
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

```

```js
New letter created with value: 	H
New letter created with value: 	e
New letter created with value: 	l
New letter created with value: 	o
New letter created with value: 	 
New letter created with value: 	w
New letter created with value: 	r
New letter created with value: 	d
New letter created with value: 	p
New letter created with value: 	c
New letter created with value: 	s
Hello word processor errrr
```

## Pitfall ##
- Complex pattern because we need to include other pattern such as factory 
- Premature optimization
- 