package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private static final SelenideElement payWithDebitCardButton = $$("button").find(exactText("Купить"));
    private static final SelenideElement payWithCreditButton = $$("button").find(exactText("Купить в кредит"));

    public void payWithDebitCard() {
        payWithDebitCardButton.click();
    }

    public void payWithCredit() {
        payWithCreditButton.click();
    }
}