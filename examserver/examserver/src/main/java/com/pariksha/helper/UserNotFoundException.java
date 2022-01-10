package com.pariksha.helper;

public class UserNotFoundException extends Exception {

public UserNotFoundException()
{
    super("User with this username not foound in database");
}

public UserNotFoundException(String msg)
{
    super(msg);
}

}
