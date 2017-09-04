package edu.ap.products;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Products {
	
	private ArrayList<Product> productsArray;
    private String filename;


    public Products(String filename) {
        this.filename = filename;
        productsArray = new ArrayList<Product>();
        updateList();

    }

    public ArrayList<Product> getProductsArray() {
        return productsArray;
    }

    public void add(Product product)
    {
        productsArray.add(product);
    }

    public void updateFile()
    {
        writeFile(getJSONArray().toString());
    }
    
    private String readFile()
    {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public JSONArray getJSONArray()
    {
        JSONArray arr = new JSONArray();
        for(Product p : productsArray)
        {
            arr.put(p.getJSON());
        }
        return arr;
    }

    private void writeFile(String data)
    {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(data);
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
