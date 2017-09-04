package edu.ap.products;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ProductsApplication extends Application {

	    /**
	     * Creates a root Restlet that will receive all incoming calls.
	     */
	   @Override
	   public synchronized Restlet createInboundRoot() {

	       Router router = new Router(getContext());

	       router.attach("/products", ProductsResource.class);
	       router.attach("/products/{product_id}", ProductResource.class);
	       return router;
	   }
}


