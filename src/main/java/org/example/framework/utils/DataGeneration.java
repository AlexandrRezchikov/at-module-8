package org.example.framework.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGeneration {

    private static final Faker faker = new Faker();

    public static String generateFullName() {
        Faker ruFaker = new Faker(new Locale("ru"));
        return ruFaker.name().fullName();
    }

    public static String generatePhoneNumber() {
        return faker.code().ean8();
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
}
