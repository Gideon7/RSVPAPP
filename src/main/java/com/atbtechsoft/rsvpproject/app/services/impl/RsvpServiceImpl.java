package com.atbtechsoft.rsvpproject.app.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atbtechsoft.rsvpproject.app.RsvpProjectApplication;
import com.atbtechsoft.rsvpproject.app.model.Friends;
import com.atbtechsoft.rsvpproject.app.repository.FriendsRepository;
import com.atbtechsoft.rsvpproject.app.services.RsvpService;

@Service
public class RsvpServiceImpl implements RsvpService{
	private static Logger logger= LoggerFactory.getLogger(RsvpProjectApplication.class);
	
	@Autowired
	FriendsRepository friendsRepository;

	@Override
	public Friends getFriendsByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		logger.info("Getting Friend's phoneNumber");
		return friendsRepository.getOne(phoneNumber);
	}

	@Override
	public boolean phoneNumberValid(String phoneNumber) {
		logger.info("validating friend's phone number..");
		friendsRepository.findById(phoneNumber);
		return false;
	}

	@Override
	public List<Friends> getAllFriends() throws Exception {
		 logger.info("Getting all contacts");
	        return friendsRepository.findAll();
	       
	}

	@Override
	public boolean updateDecision(Friends decision) {
		// TODO Auto-generated method stub
       logger.info("updating decision");
		
		if (friendsRepository.save(decision) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean updateFriendByPhoneNumber(String phone, String decision) {
		// TODO Auto-generated method stub
		Friends friend=new Friends();
		friend = this.getFriendsByPhoneNumber(phone);
		friend.setDecision(decision);
		
		boolean status=this.updateDecision(friend);
		
		if(status) {
			return true;
		}
		return false;
	}
  
}
