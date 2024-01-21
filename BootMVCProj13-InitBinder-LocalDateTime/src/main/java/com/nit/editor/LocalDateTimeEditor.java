package com.nit.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

public class LocalDateTimeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {

		System.out.println("LocalTimeEditor.setAsText()");

		// split the String date value whose pattern yyyy-MM-ddThh:mm
		String content[] = text.split("T");
		String dateContent[] = content[0].split("-");
		String timeContent[] = content[1].split(":");

		// Date
		int year = Integer.parseInt(dateContent[0]);
		int month = Integer.parseInt(dateContent[1]);
		int day = Integer.parseInt(dateContent[2]);

		// Time
		int hours = Integer.parseInt(timeContent[0]);
		int minutes = Integer.parseInt(timeContent[1]);

		// create LocalDate class obj
		LocalDateTime ldt = LocalDateTime.of(year, month, day, hours, minutes);

		// set value to property

		setValue(ldt);
	}

}
