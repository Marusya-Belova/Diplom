package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@NoArgsConstructor
public class DataHelper {

    public static String approvedCardNumber = "4444 4444 4444 4441";
    public static String declinedCardNumber = "4444 4444 4444 4442";
    public static String notExistCardNumber = "9999 0000 9999 0000";
    public static String differentTypeOfCard = new Faker(new Locale("en-US")).finance().creditCard();
    public static Faker fakerEN = new Faker(new Locale("en-US"));
    public static Faker fakerRU = new Faker(new Locale("ru-RU"));

    @Data
    @AllArgsConstructor
    public static class CardData {
        String number, month, year, holder, cvc;
    }

    public static CardData getCardData(String number) {
        String month = String.format("%2d", fakerEN.number().numberBetween(1, 12)).replace(" ", "0");
        int currentYear = LocalDate.now().getYear();
        String year = Integer.toString(fakerEN.number().numberBetween(currentYear + 1, currentYear + 5)).substring(2);
        String holder = fakerEN.name().firstName() + " " + fakerEN.name().lastName();
        String cvc = fakerEN.numerify("###");
        return new CardData(number, month, year, holder, cvc);
    }

    public static CardData getApprovedCardNumber() {
        return getCardData(approvedCardNumber);
    }

    public static CardData getDeclinedCardNumber() {
        return getCardData(declinedCardNumber);
    }

    public static CardData getEmptyNumber() {
        return getCardData("");
    }

    public static CardData getCardNumberLess16Digits() {
        return getCardData("card" + approvedCardNumber.substring(2));
    }

    public static CardData getNumberIfNotExistInBase() {
        return getCardData(notExistCardNumber);
    }

    public static CardData getNumberFaker() {
        return getCardData(differentTypeOfCard);
    }

    public static CardData getEmptyMonth() {
        CardData card = getCardData(approvedCardNumber);
        card.setMonth("");
        return card;
    }

    public static CardData getMonthWithZero() {
        CardData card = getCardData(approvedCardNumber);
        card.setMonth(("00"));
        return card;
    }

    public static CardData getMonthMoreThen12() {
        CardData card = getCardData(approvedCardNumber);
        card.setMonth(Integer.toString(fakerEN.number().numberBetween(13, 99)));
        return card;
    }

    public static CardData getMonthWithOneDigit() {
        CardData card = getCardData(approvedCardNumber);
        card.setMonth(Integer.toString(fakerEN.number().numberBetween(1, 9)));
        return card;
    }

    public static CardData getEmptyYear() {
        CardData card = getCardData(approvedCardNumber);
        card.setYear("");
        return card;
    }

    public static CardData getYearExceedingCurrentYearBy6() {
        CardData card = getCardData(approvedCardNumber);
        card.setYear(LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy")));
        return card;
    }

    public static CardData getYearWithOneDigit() {
        CardData card = getCardData(approvedCardNumber);
        card.setYear(Integer.toString(fakerEN.number().numberBetween(1, 9)));
        return card;
    }

    public static CardData getYearWithZero() {
        CardData card = getCardData(approvedCardNumber);
        card.setYear("00");
        return card;
    }

    public static CardData getExpiredCard() {
        CardData card = getCardData(approvedCardNumber);
        card.setYear(LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy")));
        return card;
    }

    public static CardData getEmptyHolderName() {
        CardData card = getCardData(approvedCardNumber);
        card.setHolder("");
        return card;
    }

    public static CardData getHolderWithoutName() {
        CardData card = getCardData(approvedCardNumber);
        card.setHolder(fakerEN.name().lastName());
        return card;
    }

    public static CardData getHolderWithManySpaces() {
        CardData card = getCardData(approvedCardNumber);
        card.setHolder(fakerEN.name().firstName() + "     " + fakerEN.name().lastName());
        return card;
    }

    public static CardData getDigitsInHolderName() {
        CardData card = getCardData(approvedCardNumber);
        card.setHolder(fakerEN.regexify("[0-9]{5,10}"));
        return card;
    }

    public static CardData getHolderWithCyrillicLetters() {
        CardData card = getCardData(approvedCardNumber);
        card.setHolder(fakerRU.name().firstName() + " " + fakerRU.name().lastName());
        return card;
    }

    public static CardData getHolderWith100Letters() {
        CardData card = getCardData(approvedCardNumber);
        card.setHolder(fakerEN.regexify("[a-zA-Z]{100}"));
        return card;
    }

    public static CardData getSpecialCharactersInHolderName() {
        CardData card = getCardData(approvedCardNumber);
        card.setHolder(fakerEN.regexify("[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\_\\+]{5,10}"));
        return card;
    }

    public static CardData getEmptyCvcCode() {
        CardData card = getCardData(approvedCardNumber);
        card.setCvc("");
        return card;
    }

    public static CardData getCvcCodeWithTwoDigits() {
        CardData card = getCardData(approvedCardNumber);
        card.setCvc(fakerEN.regexify("[0-9]{2}"));
        return card;
    }
    public static CardData getCvcCodeWithOneDigits() {
        CardData card = getCardData(approvedCardNumber);
        card.setCvc(fakerEN.regexify("[0-9]{1}"));
        return card;
    }
}