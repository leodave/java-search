import java.util.Collections;
//create a class that inherits from the "search class";

public class Identify extends Search{
    //create a constructor which takes a parameter
    public void mySearch( String letter) {
        //set an empty string which will store or words from the array later on.
        String myword = "";
        //call the getter function in the searcg class and sort the words in alphabetical order.
        Collections.sort(this.getWords());
        //create an int variable f.
        int f = 0;
        //loop through each words in the array.
        for (int i = 0; i < getWords().size(); i++) {
            //set each word to lowercase.
            myword = getWords().get(i).toLowerCase();
            //create a condition to check if any of the words in the array start with our input(parameter).
            if (myword.startsWith(letter)) {
                //if they match print the words changing thir first letter to capital.
                System.out.println(myword.substring(0, 1).toUpperCase() + myword.substring(1));
                //and finally stop the loop if our int "f" reaches 4.
                f++;
                if (f == 4) break;
            }
        }
    }
}

