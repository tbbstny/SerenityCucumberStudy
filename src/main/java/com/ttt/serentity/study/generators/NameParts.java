package com.ttt.serentity.study.generators;

public enum NameParts
{
    // lower ("abc"),   // taken care of by "feature" in generated path/file names
    UPPER ("XYZ"),
    caMel ("lMn"),
    // digit ("123"),   // taken care of by adding index value to generated path/file names
    under ("u_n"),
    // tilde ("t~d"),   // taken care of by adding ~ between index and token in generate path/file names
    sQuote("\'sq\'"),
    dQuote("\"dq\"");

    private final String token;

    NameParts(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    //private static String[] folderParts   = {"", "abc", "XYZ", "123", "camelCase", "_un", "~td"};
    //private static String[] featureParts  = {"", "abc", "XYZ", "123", "~td", "\'sq\'", "\"dq\""};

}

