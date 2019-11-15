package com.atbtechsoft.rsvpproject.app.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atbtechsoft.rsvpproject.app.RsvpProjectApplication;
import com.atbtechsoft.rsvpproject.app.model.Friends;
import com.atbtechsoft.rsvpproject.app.services.RsvpService;

@RestController
public class FriendsRestControllers {
   private static Logger logger= LoggerFactory.getLogger(RsvpProjectApplication.class);
   
     @Autowired
	 private RsvpService rsvpService;

	 @RequestMapping(value="/Friends", method=RequestMethod.GET)
   public List<Friends> getAllFriends() throws Exception{
       logger.info("API call to get all friends list");
       return rsvpService.getAllFriends();
       //return new ResponseEntity<>(contactService.getAllContact(), HttpStatus.OK);
   }
	 @RequestMapping(value="/friends/updateDecision", method=RequestMethod.POST)
	 public boolean updateDecision(Friends decision) {
		 logger.info("API call to update decision");
		return rsvpService.updateDecision(decision);	 
	 }
	 
	 @RequestMapping(value="/friends/updateFriendByPhoneno", method=RequestMethod.POST)
	 public boolean updateFriendByPhoneno(String phoneNumber, String decision) {
		 logger.info("API call to update decision");
		 Friends friend = rsvpService.getFriendsByPhoneNumber(phoneNumber);
		 friend.setDecision(decision);
		 
		return rsvpService.updateDecision(friend);	 
	 }
   
   @RequestMapping(value="/friendList", method=RequestMethod.GET)
   public Friends getFriendsPhoneNumber(String phoneNumber) {
  	 logger.info("API call to get friends by phone number");
		return rsvpService.getFriendsByPhoneNumber(phoneNumber);
   }
   @RequestMapping(value="/friends/validate", method=RequestMethod.GET)
   public boolean validateFriendsPhoneNumber(String phoneNumber) {
  	 logger.info("API call to validate phone number");
		return rsvpService.phoneNumberValid(phoneNumber);
  	 
   }

}


