package com.hotelbookingproject.BLITCoding.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    private Long bookingId;


    private LocalDate checkInDate;


    private LocalDate checkOutDate;


    private String guestName;



    private String guestEmail;


    private int numOfAdults;


    private int numOfChildren;


    private int totalNumOfGuests;


    private String bookingConfirmationCode;



    private RoomResponse room;

    public BookingResponse(Long bookingId, LocalDate checkInDate,
                           LocalDate checkOutDate, String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }




}
