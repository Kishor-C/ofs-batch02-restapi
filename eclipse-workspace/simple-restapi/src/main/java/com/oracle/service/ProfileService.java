package com.oracle.service;

import java.util.ArrayList;
import java.util.List;

import com.oracle.beans.Profile;

public class ProfileService {
	// this class is going to maintain multiple profile objects in a List<Profile>
	private static List<Profile> inMemDB = new ArrayList<>();
	private static int counter = 0;
	/*
	 * There are methods in Collection like
	 * add(object), remove(object), remove(index), size(), iterator()
	 */
	// store method to store the Profile object in inMemDB
	public Profile addProfile(Profile profile) {
		int id = ++counter; 
		profile.setId(id); // setting the id of the profile
		inMemDB.add(profile);
		return profile;
	}
	// return all the profile in the List
	public List<Profile> findProfiles() {
		return inMemDB;
	}
}
