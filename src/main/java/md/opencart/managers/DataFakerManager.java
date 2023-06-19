package md.opencart.managers;

import com.github.javafaker.Faker;

public class DataFakerManager {

    private static Faker fakerObject = new Faker();

    public static String getRandomEmail(){
        return fakerObject.internet().emailAddress();
    }

    public static String getRandomName(){
        return fakerObject.funnyName().name();
    }

    public static String getRandomPass(){
        return fakerObject.internet().password(5,10);
    }
}
