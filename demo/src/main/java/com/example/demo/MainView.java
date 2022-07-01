package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import java.util.Collections;

//create the root in which your web will be displayed.
@Route("")
//create the main view class that extends a vertical layout class from the vaadin package.
public class MainView extends VerticalLayout {

    //create a String attribute in which each of your elements in your array from the Search class will be stored later.
    private String myword;
    //create a method that will take an input from a user as parameter
    public void mySearch( String letter) {
        //create an object of your other class "search".
        Search mine = new Search();
        //call the getter method and sort the words alphabetically.
        Collections.sort(mine.getWords());
        //create an int variable in order to cut a loop for later on.
        int f = 0;
        //create a loop for your array from the other class
        for (int i = 0; i < mine.getWords().size(); i++) {
            //change all letters of the words to lowercase.
            myword = mine.getWords().get(i).toLowerCase();
            //put a condition to check if any of the words in the array have the same start with the input of the user.
            if (myword.startsWith(letter.toLowerCase())) {
                //if they do create a new h3 element to print them while changing the first letter of the words to capital letter.
                add(new H3(myword.substring(0, 1).toUpperCase() + myword.substring(1)));
                //check in the terminal if you have the results you want.
                System.out.println(myword.substring(0, 1).toUpperCase() + myword.substring(1));
                //in order to stop the loop at the top 4 searches we break it as the variable we created earlier "f" reaches 4.
                f++;
                if(f == 4){
                    break;
                }
            }
        }
        //finally we add a reset button to reload the page and add it to our web
        var reset = new Button("Reset");
        add(new HorizontalLayout(reset));
        reset.addClickListener(e->{
            UI.getCurrent().getPage().reload();
        });
        //and remind the user to reload the page before doing another search.
        add(new H2("please RESET before doing the next search!!!"));
    }
    //create the constructor method for you main page and web.
    public  MainView(){
        //create the text field in which the user will be typing the input
        var textField = new TextField();
        //create a button that will handle your search action.
        var button = new Button("Search");
        //add them both to your web.
        add(new HorizontalLayout(textField,button));
        //create the action on the click of the button
        button.addClickListener(e->{
            //at click call the method "mysearch" by giving it the users input as a parameter.
            mySearch(textField.getValue());
            //and finnally cear the text area.
            textField.clear();
        });
    }
}
