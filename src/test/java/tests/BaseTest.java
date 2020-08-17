package tests;

import org.junit.AfterClass;
import org.junit.Before;
import utils.Browser;
import utils.Utils;

public class BaseTest {
    @Before
    public void setup(){
        Browser.loadPage(Utils.getBaseUrl());
    }

    @AfterClass
    public static void tearDown() {
        Browser.close();
    }
}
