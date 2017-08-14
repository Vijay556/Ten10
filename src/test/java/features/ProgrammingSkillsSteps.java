package features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by vijayapalkayyam on 13/08/2017.
 */
public class ProgrammingSkillsSteps {
    private Integer[] orderedItems;
    private int lengthOfLongestOrderedArray;


    @Given("^I have unordered array (.*)$")
    public void iHaveUnordered(String unorderedArray) throws Throwable {
        orderedItems = Arrays
                .stream(unorderedArray.split("\\s*,\\s*")) // split into array of
                .map(Integer::parseInt) // converts to integer
                .sorted() //It sorts all items in ascending order
                .toArray(Integer[]::new); // will be collected to Integer array
    }

    @When("^I calculate length of the longest ordered array$")
    public void iCalculateLengthOfTheLongestOrderedArray() throws Throwable {
        lengthOfLongestOrderedArray = getLengthOfLongestOrderedArray(orderedItems);
    }

    @Then("^the result should be (\\d+)$")
    public void theResultIs(int expectedResult) throws Throwable {
        assertTrue("Incorrect length, expected length is: " + expectedResult + ", but actual length is: " + lengthOfLongestOrderedArray,
                expectedResult == lengthOfLongestOrderedArray);
    }

    private int getLengthOfLongestOrderedArray(Integer[] items) {
        int count = 1, max = 1;
        for (int i = 1; i < items.length; i++) {
            if (items[i] == items[i - 1] + 1) count++;
            else count = 1;
            if (count > max) max = count;
        }
        return max;
    }
}
