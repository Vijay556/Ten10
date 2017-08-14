import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.FileNotFoundException;

/**
 * Created by vijayapalkayyam on 13/08/2017.
 */

public class WebServiceTestClient {

    public static String webServiceTestClient(String webServiceURL)
            throws FileNotFoundException, Exception {
        PostMethod post = null;
        HttpClient client = new HttpClient();
        String inputFile = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n" +
                "<SOAP-ENV:Envelope\n" +
                " xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                " xmlns:q0=\"http://sample.ws.ibm.com\"\n" +
                " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "<SOAP-ENV:Body>\n" +
                "  <q0:getUsers/> \n" +
                "</SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";

        try {
            post = new PostMethod(webServiceURL);
            post.setRequestHeader("Accept", "application/soap+xml,application/ dime, multipart / related, text/*");
            post.setRequestHeader("SOAPAction", "");

            // Request content will be retrieved directly from the input stream
            RequestEntity entity = new StringRequestEntity(inputFile, "text/xml", "utf-8");
            post.setRequestEntity(entity);

            // Returns a number indicating the status of response
            int result = client.executeMethod(post);
            return post.getResponseBodyAsString();
        } finally {
            // Release current connection to the connection pool once you are done
            post.releaseConnection();
        }
    }
}