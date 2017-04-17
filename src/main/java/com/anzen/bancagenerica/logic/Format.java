package com.anzen.bancagenerica.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by raul on 7/04/17.
 */
public class Format
{
    private Pattern pattern;
    private Matcher matcher;

    public Format(char format, int enteros, int decimales, int size) {
        Expressions ex= new Expressions();
        if(format=='9')
        {
            pattern= Pattern.compile(ex.getFORMAT_9(enteros,decimales));
        }
        else if( format == 'x')
        {
            pattern= Pattern.compile(ex.getFORMAT_X(size));
        }

    }

    public boolean isValid(String text)
    {
        matcher= pattern.matcher(text);
        return matcher.matches();
    }

    public Pattern getPattern() {
        return pattern;
    }


}
