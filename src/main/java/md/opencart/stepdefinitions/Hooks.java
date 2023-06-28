package md.opencart.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import md.opencart.managers.DriverManager;

public class Hooks {

    static int counter = 0;

    @BeforeAll
    public static void beforAllTheTestsAreExecuted(){
        System.out.println("The execution of features is started");
    }

    @Before
    public void beforeEachTest(){
        counter ++;
        System.out.println("The test No ["  + counter +"]  started");
    }

    @After
    public void afterEachTest(){
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The test No [" + counter + "] is finished");
    }

    @AfterAll
    public static void afterAllTheTestsAreExecuted(){
        System.out.println("The execution off all the features is finished");
    }
}
