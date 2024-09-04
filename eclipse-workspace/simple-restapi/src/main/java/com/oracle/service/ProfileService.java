package com.oracle.service;

import java.util.ArrayList;
import java.util.Iterator;
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
	// return the profile based on the id
	public Profile findProfile(int id) {
		Profile profile = null;
		for(Profile p : inMemDB) {
			if(p.getId() == id) {
				profile = p;
				break; // stop iterating if profile is found
			}
		}
		return profile; // if profile is not found then returns null
	}
	// delete the profile based on the id
	public int deleteProfile(int id) {
		// for-loop is read-only, Iterator<T> can iterate & also remove using remove()
		Iterator<Profile> iterate = inMemDB.iterator();
		while(iterate.hasNext()) {
			// next() returns the iterated element
			Profile p = iterate.next();
			if(p.getId() == id) {
				// remove() removes the iterated element
				iterate.remove();
				return 1; // 1 means removed successfully.
			}
		}
		return -1; // -1 means id doesn't exist
	}
	
	
}
