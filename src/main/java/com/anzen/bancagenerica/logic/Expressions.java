package com.anzen.bancagenerica.logic;

/**
 * Created by raul on 7/04/17.
 */
public class Expressions
{
    private String N_ALFANUMERICO_PATTERN=".{$1}";
    private String N_DIGITO_PATTERN="\\d{$1}";



    public String getFORMAT_X(int cantidad)
    {
        return N_ALFANUMERICO_PATTERN.replace("$1", new String(cantidad+""));
    }

    public String getFORMAT_9(int cEnteros,int cDecimales)
    {
        String pattern= N_DIGITO_PATTERN.replace("$1", cEnteros + "");
        if(cDecimales>0)
        {
            return pattern + N_DIGITO_PATTERN.replace( "$1" , cDecimales + "");
        }
        else
        {
            return pattern;
        }
    }
}