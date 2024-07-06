package restful.booker.modules;

import com.google.gson.Gson;
import restful.booker.pojos.Booking;
import restful.booker.pojos.BookingDates;
import restful.booker.pojos.BookingResponse;

public class PayloadManager {

    Gson gson;

    public String createPayloadBookingAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Aaleeya");
        booking.setLastname("Test");
        booking.setTotalprice(227);
        booking.setDepositpaid(true);

        BookingDates bookingDates =new BookingDates();
        bookingDates.setCheckin("2024-10-01");
        bookingDates.setCheckout("2024-10-17");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        return gson.toJson(booking);
    }

    public String fullUpdatePayloadAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Ayesha");
        booking.setLastname("Test");
        booking.setTotalprice(227);
        booking.setDepositpaid(true);

        BookingDates bookingDates =new BookingDates();
        bookingDates.setCheckin("2024-10-01");
        bookingDates.setCheckout("2024-10-17");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        return gson.toJson(booking);
    }

    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse= gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

}
