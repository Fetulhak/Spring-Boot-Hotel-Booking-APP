package com.hotelbookingproject.BLITCoding.repository;

import com.hotelbookingproject.BLITCoding.model.BookedRoom;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface BookedRoomRepository extends ListCrudRepository<BookedRoom, Long> {
    BookedRoom findByBookingConfirmationCode(String bookingConfirmationCode);
    List<BookedRoom> findByRoomId(Long roomId);

    List<BookedRoom> findByGuestEmail(String email);
}
