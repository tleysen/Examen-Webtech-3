package edu.ap.products;

import org.json.JSONObject;

public class Product {

   
    private String naam;
    private String producent;
    private String prijs;

    public Product(String naam, String producent, String prijs) {
        this.naam = naam;
        this.producent = producent;
        this.prijs = prijs;
    }

    public JSONObject getJSON()
    {
        JSONObject obj = new JSONObject();
        try
        {
        		obj.put("naam", naam);
        		obj.put("producent", producent);
        		obj.put("prijs", prijs);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return obj;
    }
}
