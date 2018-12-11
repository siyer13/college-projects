package com.education.school.util;

import java.util.UUID;

public class SchoolUtilities {

    public static String generateTransactionID() {
        return UUID.randomUUID().toString();
    }
}
