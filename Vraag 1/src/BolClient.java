import org.restlet.resource.ClientResource;

public class BolClient {

    public static void main(String[] args) {

        try {
            ClientResource resource = new ClientResource("http://localhost:8182/bolapp/bestellingen");
            String bestelling = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
            bestelling += "<bestelling name=\"Dhr Possemiers\" address=\"Zeedijk 50\" date=\"02/09/2017\" product=\"strandstoel\" amount=\"1\">";
            bestelling += "</bestelling>";
            resource.post(bestelling);
            String bestelling2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
            bestelling2 += "<bestelling name=\"Mvr Van Osselaere\" address=\"Meir 40\" date=\"03/09/2017\" product=\"Handoek Cisco\" amount=\"20\">";
            bestelling2 += "</bestelling>";
            resource.post(bestelling2);
            // get the response
            System.out.println(resource.getResponseEntity().getText());
        }
        catch (Exception e) {
            System.out.println("In main : " + e.getMessage());
        }
    }
}
