package edu.ap.products;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import edu.ap.xml.XMLParser;

public class ProductsResource extends ServerResource {

	public static Products products = new Products("products.json");
	
	@Get("html")
	public String getProducts() {
		return file.getJSONArray().toString();
	}
	
	@Post("txt")
	public String addProduct(String product) {
	}

}
