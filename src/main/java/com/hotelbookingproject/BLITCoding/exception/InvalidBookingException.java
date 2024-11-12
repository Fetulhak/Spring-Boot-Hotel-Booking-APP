package com.hotelbookingproject.BLITCoding.exception;

public class InvalidBookingException  extends RuntimeException{
    public InvalidBookingException(String message) {
        super(message);
    }
}
