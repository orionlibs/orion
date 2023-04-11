package com.orion.core.content;

import com.orion.core.abstraction.OrionConstants;
import java.util.Arrays;
import java.util.List;

public class EscapeCharacters extends OrionConstants
{
    public static final List<String> EscapeCharacters = Arrays.asList(new String[]
    {"'", "\"", "\n", "\r", "\f", "\\", "\t", "\b"});
    public static final String SingleQuote = "'";
    public static final String DoubleQuote = "\"";
    public static final String NewLine = "\n";
    public static final String CarriageReturn = "\r";
    public static final String FormFeed = "\f";
    public static final String Blacslash = "\\";
    public static final String Tab = "\t";
    public static final String Backspace = "\b";
}