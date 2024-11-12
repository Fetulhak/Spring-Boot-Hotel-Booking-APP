package com.hotelbookingproject.BLITCoding.service;


import com.hotelbookingproject.BLITCoding.model.BookedRoom;

import java.util.List;

public interface BookedRoomService {


    List<BookedRoom> getAllBookingsByRoomId(Long roomId);

    void cancelBooking(Long bookingId);

    String saveBooking(Long roomId, BookedRoom bookingRequest);

    BookedRoom findByBookingConfirmationCode(String confirmationCode);

    List<BookedRoom> getAllBookings();

    List<BookedRoom> getBookingsByUserEmail(String email);
}
