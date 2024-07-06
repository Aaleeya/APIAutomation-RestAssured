package restful.booker.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import restful.booker.base.BaseTest;
import restful.booker.endpoints.APIConstants;
import restful.booker.pojos.BookingResponse;

import static org.hamcrest.MatcherAssert.assertThat;


public class TestCreateBookingPOST extends BaseTest {

    @Test(groups = "Smoke")
    @Owner("Aaleeya")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be created")
    public void testCreateBooking(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        //Validatable Assertion
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Deserialize-
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //AssertJ
        //assertThat(bookingResponse.getBookingid()).isNotNull();
        //assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        //assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Aaleeya");

        //TestNG Assertions
        assertActions.verifyStatusCode(response);
    }
}
