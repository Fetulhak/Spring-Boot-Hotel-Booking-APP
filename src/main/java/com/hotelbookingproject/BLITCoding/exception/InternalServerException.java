package com.hotelbookingproject.BLITCoding.exception;

public class InternalServerException extends Throwable {
    public InternalServerException(String errorUpdatingRoom) {
        super(errorUpdatingRoom);
    }
}
