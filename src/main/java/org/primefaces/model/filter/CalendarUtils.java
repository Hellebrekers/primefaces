/*
 * The MIT License
 *
 * Copyright (c) 2009-2020 PrimeTek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.primefaces.model.filter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//TODO: separate TClickFaces utils so we can use those functions instead
public class CalendarUtils {

    private CalendarUtils() {
    }

    public static Calendar getDutchCalendar() {
        Calendar cal = new GregorianCalendar();
        cal.setMinimalDaysInFirstWeek(4);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal;
    }

    public static Calendar of(Date date) {
        Calendar cal = getDutchCalendar();
        cal.setTime(date);
        return cal;
    }

    private static Date add(Date date, int calendarField, int amount) {
        Calendar c = of(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static Date getStartOfDay(Date date) {
        Calendar cal = of(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar cal = of(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static Date getPreviousDay(Date date) {
        return add(date, Calendar.DAY_OF_YEAR, -1);
    }

    /**
     * Convenience methods resolving calendar fields from Date objects
     */
    public static Integer resolveCalendarfield(Date date, int calendarField) {
        return of(date).get(calendarField);
    }

    public static Integer getYear(Date date) {
        return resolveCalendarfield(date, Calendar.YEAR);
    }

    public static Integer getCurrentYear() {
        return getYear(new Date());
    }

    public static Integer getMonth(Date date) {
        return resolveCalendarfield(date, Calendar.MONTH);
    }

    public static Integer getCurrentMonth() {
        return getMonth(new Date());
    }

    public static Integer getWeekOfMonth(Date date) {
        return resolveCalendarfield(date, Calendar.WEEK_OF_MONTH);
    }

    public static Integer getCurrentWeekOfMonth() {
        return getWeekOfMonth(new Date());
    }

    public static Integer getWeekOfYear(Date date) {
        return resolveCalendarfield(date, Calendar.WEEK_OF_YEAR);
    }

    public static Integer getCurrentWeekOfYear() {
        return getWeekOfYear(new Date());
    }

    public static Integer getDayOfYear(Date date) {
        return resolveCalendarfield(date, Calendar.DAY_OF_YEAR);
    }

    public static Integer getCurrentDayOfYear() {
        return getDayOfYear(new Date());
    }

    public static Integer getDayOfMonth(Date date) {
        return resolveCalendarfield(date, Calendar.DAY_OF_MONTH);
    }

    public static Integer getCurrentDayOfMonth() {
        return getDayOfMonth(new Date());
    }

    public static Integer getDayOfWeek(Date date) {
        return resolveCalendarfield(date, Calendar.DAY_OF_WEEK);
    }

    public static Integer getCurrentDayOfWeek() {
        return getDayOfWeek(new Date());
    }

}
