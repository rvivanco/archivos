package com.anzen.bancagenerica.logic;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raul on 7/04/17.
 */
public class FileValidator
{

    //Tipos de operaciones que tendrá el archivo
    private int idOperationLong;
    private Map<String, FileLine> fileLines;
    private Map<String, Object> json;

    public FileValidator(Map<String, Object> json) {
        this.json = json;
        idOperationLong= Integer.valueOf( (String) json.get("idOperationLong") );
        fileLines = new HashMap<String, FileLine>();
        setup();
    }


    private void setup()
    {
        Map<String, Object> fileLinesDef= (Map<String, Object>) json.get( "FileLines" );
        fileLinesDef.forEach( (key, value) -> {
            Map<String, Object> innerJson= (Map<String, Object>) value;
            FileLine fileLine= new FileLine( key, Boolean.valueOf( (String) innerJson.get("unique") ),
                    Integer.valueOf( (String) innerJson.get("long") ));
            fileLine.setupFields( (List<Map<String, Object>>) innerJson.get("FileFields"));

            fileLines.put(key, fileLine);
        } );



    }







    public boolean validarLinea(String linea)
    {

        System.out.println("Se procede a validar idOpLong "+idOperationLong+": "+linea);
        fileLines.forEach((k,v)-> System.out.println("key: "+ k + " -->" + linea.substring(0,idOperationLong) ));
        return fileLines.get(linea.substring(0,idOperationLong)).validarLinea(linea);

    }


}
