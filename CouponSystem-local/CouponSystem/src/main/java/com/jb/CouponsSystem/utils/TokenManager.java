package com.jb.CouponsSystem.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TokenManager {
	private Map<UUID, UserData> tokenMap = new HashMap<UUID, UserData>();

	public void addUser(UUID uuid, UserData userData) {
		tokenMap.put(uuid, userData);
	}

	public void removeUser(UUID uuid) {
		tokenMap.remove(uuid);
	}

	public boolean validateUser(UUID uuid, UserType userType) {
		return tokenMap.containsKey(uuid) && tokenMap.get(uuid).getUserType() == userType;
	}

	public String getUserEmail(UUID uuid) {
		return tokenMap.get(uuid).getEmail();
	}

}
