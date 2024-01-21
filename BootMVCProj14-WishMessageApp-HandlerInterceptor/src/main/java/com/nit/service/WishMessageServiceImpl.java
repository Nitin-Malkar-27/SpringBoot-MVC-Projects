package com.nit.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("wMsg")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateMessage() {

		// get the system date and time
		LocalDateTime ldt = LocalDateTime.now();

		// get the cuurent hour of the
		int hour = ldt.getHour();

		// generate the wishMessage
		if (hour < 12) {
			return "Good Morning";
		} else if (hour < 16) {
			return "Good AfterNoon";
		} else if (hour < 20) {
			return "Good Evening";
		} else {
			return "Good Night";
		}
	}

}
