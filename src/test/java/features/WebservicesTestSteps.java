package features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by vijayapalkayyam on 13/08/2017.
 */
public class WebservicesTestSteps {
    private DefaultHttpClient client;
    private HttpPost post;
    private HttpResponse response;

    @Given("^my endpoint is \"([^\"]*)\"$")
    public void iMyEndpointIs(String url) throws Throwable {
        client = new DefaultHttpClient();
        post = new HttpPost(url);
        List<BasicNameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(
                new BasicNameValuePair("county", "Hertforshire"));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    }

    @When("^I invoke it$")
    public void iInvokeIt() throws Throwable {

        try {
            response = client.execute(post);
            System.out.println(response.getStatusLine());
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see the success response$")
    public void iShouldSeeTheSuccessResponse() throws Throwable {
        assertTrue("Response is: " + response.getStatusLine().getStatusCode(), response.getStatusLine().getStatusCode() == 200);
    }
}
