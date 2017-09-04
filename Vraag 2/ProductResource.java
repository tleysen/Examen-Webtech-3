package edu.ap.products;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * This resource represents an individual race instance
 */
public class ProductResource extends ServerResource {

	@Get("html")
	public String getProduct() {
	
	}

}
