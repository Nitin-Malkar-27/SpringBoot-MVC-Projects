package com.nit.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;

public class LocalTimeEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) {
		System.out.println("LocalTimeEditor.setAsText()");

		// split the String date value whose pattern hh:mm
		String timeContent[] = text.split(":");
		int hours = Integer.parseInt(timeContent[0]);
		int minutes = Integer.parseInt(timeContent[1]);

		// create LocalDate class obj
		LocalTime lt = LocalTime.of(hours, minutes);
		// set value to property

		setValue(lt);
	}
}