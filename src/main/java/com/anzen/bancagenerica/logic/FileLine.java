package com.anzen.bancagenerica.logic;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by raul on 7/04/17.
 */
public class FileLine
{
    private String codigo;
    private boolean unique;
    private int longitud;
    private List<Field> fields;

    public FileLine(String codigo, boolean unique, int longitud) {
        this.codigo = codigo;
        this.unique = unique;
        this.longitud = longitud;
        this.fields= new ArrayList<Field>();
    }

    public void setupFields(List<Map<String, Object>> listFields)
    {
        listFields.forEach( (fields) -> {
            Map<String, Object> validation=(Map<String, Object>) fields.get( "validation" );

            Field field= new Field( (String) fields.get("nombre"),
                    Integer.valueOf( (String) fields.get("longField") ),
                    Integer.valueOf( (String) fields.get("start") ),
                    Integer.valueOf( (String) fields.get("end") ),
                    new Format(  ((String)fields.get("format")).charAt(0) ,
                            (Integer) validation.get("int") ,
                            (Integer)  validation.get("decimal "),
                            Integer.valueOf( (String) fields.get("longField"))
                    )
            );
            this.fields.add(field);

        } );

    }

    public boolean validarLinea(String linea)
    {
        //LA LONGITUD DE LA LINEA NO CORRESPONDE CON LA DEFINICION
        if(linea.length() < longitud)
        {
            System.out.println("Longitud de la linea invalida "+longitud+": " +linea.length() );
            return false;
        }
        System.out.println("Campos en la linea: "+ fields.size());
        for (Field f : fields)
        {
            if( !f.validar( linea.substring( f.getStart(), f.getEnd() )) )
            {
                System.out.println("Campo invalido: "+ linea.substring( f.getStart(), f.getEnd() ) + " \t-> " + f.getNombre() + " \t-> " + f.getFormat().getPattern().pattern()  );
                return false;
            }
            else
            {
                System.out.println("Campo valido: "+ linea.substring( f.getStart(), f.getEnd() ) + " \t-> " + f.getNombre() + " \t-> " + f.getFormat().getPattern().pattern()  );

            }
        }

        return true;

    }

}
