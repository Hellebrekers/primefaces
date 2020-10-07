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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class FilterFormEntry implements Serializable {

    private Boolean staticColumn;

    private String columnId;
    private String filterMatchMode;

    private String textValue;
    private Boolean booleanValue;
    private Integer intValue1;
    private Integer intValue2;
    private BigDecimal decimalValue1;
    private BigDecimal decimalValue2;
    private Date dateValue1;
    private Date dateValue2;

    public static FilterFormEntry newWithStaticColumn(String columnId) {
        FilterFormEntry filterFormEntry = new FilterFormEntry();
        filterFormEntry.setStaticColumn(true);
        filterFormEntry.setColumnId(columnId);
        return filterFormEntry;
    }

    public static FilterFormEntry newWithEditableColumn() {
        FilterFormEntry filterFormEntry = new FilterFormEntry();
        filterFormEntry.setStaticColumn(false);
        return filterFormEntry;
    }

    public boolean filterMatchModeIsBetween() {
        return filterMatchMode != null && filterMatchMode.startsWith("between");
    }

    public boolean filterMatchModeIsDateUtility() {
        return filterMatchMode != null && (filterMatchMode.equals("today")
                || filterMatchMode.equals("yesterday")
                || filterMatchMode.equals("currentWeek")
                || filterMatchMode.equals("currentMonth")
                || filterMatchMode.equals("currentYear"));
    }

    public void clearValues() {
        textValue = null;
        booleanValue = null;
        intValue1 = null;
        intValue2 = null;
        decimalValue1 = null;
        decimalValue2 = null;
        dateValue1 = null;
        dateValue2 = null;
    }

    public Object getValue() {
        if (filterMatchModeIsBetween()) {
            if (dateValue2 != null) {
                return Arrays.asList(dateValue1, dateValue2);
            }
            else if (decimalValue2 != null) {
                return Arrays.asList(decimalValue1, decimalValue2);
            }
            else if (intValue2 != null) {
                return Arrays.asList(intValue1, intValue2);
            }
            return null;
        }
        else if (filterMatchModeIsDateUtility()) {
            return true; //Always return true so we know it's a valid filterFormEntry
        }
        else {
            if (textValue != null) {
                return textValue;
            }
            else if (booleanValue != null) {
                return booleanValue;
            }
            else if (intValue1 != null) {
                return intValue1;
            }
            else if (decimalValue1 != null) {
                return decimalValue1;
            }
            else if (dateValue1 != null) {
                return dateValue1;
            }
            return null;
        }
    }

    public Boolean getStaticColumn() {
        return staticColumn;
    }

    public void setStaticColumn(Boolean staticColumn) {
        this.staticColumn = staticColumn;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        clearValues();
        this.columnId = columnId;
    }

    public String getFilterMatchMode() {
        return filterMatchMode;
    }

    public void setFilterMatchMode(String filterMatchMode) {
        this.filterMatchMode = filterMatchMode;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public Integer getIntValue1() {
        return intValue1;
    }

    public void setIntValue1(Integer intValue1) {
        this.intValue1 = intValue1;
    }

    public Integer getIntValue2() {
        return intValue2;
    }

    public void setIntValue2(Integer intValue2) {
        this.intValue2 = intValue2;
    }

    public BigDecimal getDecimalValue1() {
        return decimalValue1;
    }

    public void setDecimalValue1(BigDecimal decimalValue1) {
        this.decimalValue1 = decimalValue1;
    }

    public BigDecimal getDecimalValue2() {
        return decimalValue2;
    }

    public void setDecimalValue2(BigDecimal decimalValue2) {
        this.decimalValue2 = decimalValue2;
    }

    public Date getDateValue1() {
        return dateValue1;
    }

    public void setDateValue1(Date dateValue1) {
        this.dateValue1 = dateValue1;
    }

    public Date getDateValue2() {
        return dateValue2;
    }

    public void setDateValue2(Date dateValue2) {
        this.dateValue2 = dateValue2;
    }
}
