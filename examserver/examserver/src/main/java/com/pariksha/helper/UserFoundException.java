package com.pariksha.helper;

public class UserFoundException extends Exception {

public UserFoundException()
{
    super("User with this Username is already there in Database. Try with different username");
}

public UserFoundException(String msg)
{
    super(msg);
}

}
