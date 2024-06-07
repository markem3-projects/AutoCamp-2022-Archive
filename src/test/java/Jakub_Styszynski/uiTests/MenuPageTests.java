package Jakub_Styszynski.uiTests;

import Jakub_Styszynski.pageObjects.MenuPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;

public class MenuPageTests {
    MenuPage menuPage = new MenuPage();

    @BeforeEach
    public void setup() throws MalformedURLException {
        menuPage.init();
    }

    @AfterEach
    public void cleanup(){
        menuPage.clean();
    }

    //if 2 positions have same price, sorting returns them in random order
    //bug or intended??
    @Test
    public void shoudlBeTrueIfOrderFilterSortsCorrectly(){
        //given
            //check order of dishes before sorting
        sleep(200);
        List<String> namesBefore = menuPage.makeListOfAllDisplaydDishes();
        sleep(200);

        //when
            //Sorting
        menuPage.clickAscDescOrderButton();
        sleep(200);
        menuPage.clickApplyFiltersButton();
        sleep(200);

        //then
            //check order of dishes after sorting
        List<String> namesAfter = menuPage.makeListOfAllDisplaydDishes();
        sleep(200);

            //Check if order is correct
        Collections.reverse(namesAfter);
        Assertions.assertEquals(namesBefore, namesAfter);
        sleep(200);
    }

}
