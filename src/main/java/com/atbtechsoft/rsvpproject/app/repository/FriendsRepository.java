package com.atbtechsoft.rsvpproject.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atbtechsoft.rsvpproject.app.model.Friends;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, String>{

}
