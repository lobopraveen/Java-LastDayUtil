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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

/**
 * The Test class is written to run tests on the LastDayUtil class
 * 
 * @version 1.0
 * @author Praveen Lobo
 * 
 */
@RunWith(Parameterized.class)
public class TestLastDayUtil {
	
	// input and corresponding three outputs 
	private String input;
	private String lastDayOfMonth;
	private String lastWednesdayOfMonth;
	private String lastWeekDayOfMonth;

	// Constructor to prepare data for each test
	public TestLastDayUtil(String input, String lastDayOfMonth, String lastWeekDayOfMonth,
			String lastWednesdayOfMonth) {
		this.input = input;
		this.lastDayOfMonth = lastDayOfMonth;
		this.lastWednesdayOfMonth = lastWednesdayOfMonth;
		this.lastWeekDayOfMonth = lastWeekDayOfMonth;

	}
	
	// Test data 
	@Parameters(name = "{index}: {0}")
	public static Collection<Object[]> testData() {
		
		return Arrays.asList(new Object[][] {
			{ "12/1/2011", "12/31/2011", "12/30/2011", "12/28/2011" },
			{ "1/1/2012",  "01/31/2012", "01/31/2012", "01/25/2012" },
			{ "2/1/2012",  "02/29/2012", "02/29/2012", "02/29/2012" }, /* Leap */
			{ "3/1/2012",  "03/31/2012", "03/30/2012", "03/28/2012" },
			{ "4/1/2012",  "04/30/2012", "04/30/2012", "04/25/2012" },
			{ "5/1/2012",  "05/31/2012", "05/31/2012", "05/30/2012" },
			{ "6/1/2012",  "06/30/2012", "06/29/2012", "06/27/2012" },
			{ "7/1/2012",  "07/31/2012", "07/31/2012", "07/25/2012" },
			{ "8/1/2012",  "08/31/2012", "08/31/2012", "08/29/2012" },
			{ "9/1/2012",  "09/30/2012", "09/28/2012", "09/26/2012" },
			{ "10/1/2012", "10/31/2012", "10/31/2012", "10/31/2012" },
			{ "11/1/2012", "11/30/2012", "11/30/2012", "11/28/2012" },
			{ "12/1/2012", "12/31/2012", "12/31/2012", "12/26/2012" }			
		});		
	}

    @Test 
    public void test_lastDayOfMonth() throws ParseException {
    	assertEquals(lastDayOfMonth, LastDayUtil.lastDayOfMonth(input, "MM/dd/yyyy"));
    }

    @Test 
    public void test_lastWeekDayOfMonth() throws ParseException {   
    	assertEquals(lastWeekDayOfMonth, LastDayUtil.lastWeekDayOfMonth(input, "MM/dd/yyyy"));
    }

    @Test 
    public void test_lastDayOfMonth_Wednesday() throws ParseException {  
    	assertEquals(lastWednesdayOfMonth, LastDayUtil.lastDayOfMonth(input, "MM/dd/yyyy", Calendar.WEDNESDAY));
    }
}
