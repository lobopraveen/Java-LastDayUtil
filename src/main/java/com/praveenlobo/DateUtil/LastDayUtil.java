/* 
 * MIT License
 * Copyright (c) 2018 Praveen Lobo (praveenlobo.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *  
 */

package com.praveenlobo.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The LastDayUtil classes provide a number of utilities that are not directly
 * provided by the Java Calendar class. 
 *   
 * @version 1.0 
 * 
 */
public class LastDayUtil {

	/**
	 * Returns the date of the last day of the month.
	 * 
	 * @param date
	 *            a date for which the last day of the month has to be
	 *            determined
	 * @return a date indicating the last day of the month
	 * 
	 * @see #lastDayOfMonth(String, String)
	 * @see #lastWeekDayOfMonth(Date)
	 * @see #lastWeekDayOfMonth(String, String)
	 * @see #lastDayOfMonth(Date, int)
	 * @see #lastDayOfMonth(String, String, int)
	 */
	public final static Date lastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// set calendar to the last day of the month
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/**
	 * Returns the date of the last day of the month.
	 * 
	 * @param strDate
	 *            a date for which the last day of the month has to be
	 *            determined
	 * @param dateFormat
	 *            the date format of the <code>strDate</code> being passed
	 * @return a string representation of the last day of the month in
	 *         <code>dateFormat</code>
	 * @throws ParseException
	 *             if the <code>strDate</code> specified cannot be parsed
	 *
	 * @see #lastDayOfMonth(Date) 
	 * @see #lastWeekDayOfMonth(Date)
	 * @see #lastWeekDayOfMonth(String, String)
	 * @see #lastDayOfMonth(Date, int)
	 * @see #lastDayOfMonth(String, String, int)
	 */
	public final static String lastDayOfMonth(String strDate, String dateFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date = lastDayOfMonth(formatter.parse(strDate));
		return formatter.format(date);
	}

	/**
	 * Returns the date of the last weekday of the month; note that this method
	 * never checks for holidays i.e. it returns the last weekday of the month
	 * even if it is a holiday.
	 * 
	 * @param date
	 *            a date for which the last weekday of the month has to be
	 *            determined
	 * @return a date indicating the last weekday of the month
	 * 
	 * @see #lastDayOfMonth(Date)
	 * @see #lastDayOfMonth(String, String)
	 * @see #lastWeekDayOfMonth(String, String)
	 * @see #lastDayOfMonth(Date, int)
	 * @see #lastDayOfMonth(String, String, int)
	 */
	public final static Date lastWeekDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// set calendar to the last day of the month
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

		// get the last weekday of the month; simple logic
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.add(Calendar.DAY_OF_MONTH, -2);
		} else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		return cal.getTime();
	}

	/**
	 * Returns the date of the last weekday of the month; note that this method
	 * never checks for holidays i.e. it returns the last weekday of the month
	 * even if it is a holiday.
	 * 
	 * @param strDate
	 *            a string representation of the date
	 * @param dateFormat
	 *            the date format of the <code>strDate</code> being passed
	 * @return a string representation of the last weekday of the month in
	 *         <code>dateFormat</code>
	 * @throws ParseException
	 *             if the <code>strDate</code> specified cannot be parsed
	 * 
	 * @see #lastDayOfMonth(Date)
	 * @see #lastDayOfMonth(String, String)
	 * @see #lastWeekDayOfMonth(Date)
	 * @see #lastDayOfMonth(Date, int)
	 * @see #lastDayOfMonth(String, String, int)
	 */
	public final static String lastWeekDayOfMonth(String strDate, String dateFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date = lastWeekDayOfMonth(formatter.parse(strDate));
		return formatter.format(date);
	}

	/**
	 * Returns the date of the last specified <code>day</code> of the month.
	 * 
	 * @param date
	 *            a date for which the last specified <code>day</code> of the
	 *            month has to be determined
	 * @param day
	 *            any day of the week
	 * 
	 *            <p>
	 *            Example: lastDayOfMonth(date, Calendar.SUNDAY) returns last
	 *            Sunday of <code>date</code>
	 * 
	 * @return the date of the last specified <code>day</code> of the month.
	 *  
	 * @see #lastDayOfMonth(Date)
	 * @see #lastDayOfMonth(String, String)
	 * @see #lastWeekDayOfMonth(Date)
	 * @see #lastWeekDayOfMonth(String, String)
	 * @see #lastDayOfMonth(String, String, int)
	 */
	public final static Date lastDayOfMonth(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// set calendar to the first day of the next month
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, 1);

		// calculate the number of days to subtract to get the last desired day of the month
		int lobosMagicNumber = (13 - day) % 7;
		cal.add(Calendar.DAY_OF_MONTH, -(((lobosMagicNumber + cal.get(Calendar.DAY_OF_WEEK)) % 7) + 1));

		return cal.getTime();
	}

	/**
	 * Returns the date of the last specified <code>day</code> of the month.
	 * 
	 * @param strDate
	 *            a date for which the last specified <code>day</code> of the
	 *            month has to be determined
	 * @param dateFormat
	 *            the date format of the <code>strDate</code> being passed
	 * @param day
	 *            any day of the week
	 * 
	 *            <p>
	 *            Example: lastDayOfMonth(strDate, dateFormat, Calendar.SUNDAY)
	 *            returns last Sunday of <code>strDate</code> in
	 *            <code>dateFormat</code> format.
	 * 
	 * @return a string representation of the date of the last specified
	 *         <code>day</code> of the month.
	 *         
	 * @throws ParseException
	 *             if the <code>strDate</code> specified cannot be parsed
	 * 
	 * @see #lastDayOfMonth(Date)
	 * @see #lastDayOfMonth(String, String)
	 * @see #lastWeekDayOfMonth(Date)
	 * @see #lastWeekDayOfMonth(String, String)
	 * @see #lastDayOfMonth(Date, int)
	 */
	public final static String lastDayOfMonth(String strDate, String dateFormat, int day) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date = lastDayOfMonth(formatter.parse(strDate), day);
		return formatter.format(date);
	}

}