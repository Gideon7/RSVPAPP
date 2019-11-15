package com.atbtechsoft.rsvpproject.app.services;

import java.util.List;

import com.atbtechsoft.rsvpproject.app.model.Friends;

public interface RsvpService {
	 //service
	 Friends getFriendsByPhoneNumber(String phoneNumber);
	 boolean phoneNumberValid(String phoneNumber);
	 List<Friends> getAllFriends() throws Exception;
     boolean updateDecision(Friends decision);
     boolean updateFriendByPhoneNumber(String phone, String decision);
}
