package com.travel.TravelApplication.ExceptionHandling;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException (String msg){
        super(msg);
    }
}
