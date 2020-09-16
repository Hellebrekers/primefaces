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
package org.primefaces.model;

public enum MatchMode {

    STARTS_WITH("startsWith"),
    ENDS_WITH("endsWith"),
    CONTAINS("contains"),
    EXACT("exact"),
    LESS_THAN("lt"),
    LESS_THAN_EQUALS("lte"),
    GREATER_THAN("gt"),
    GREATER_THAN_EQUALS("gte"),
    EQUALS("equals"),
    IN("in"),
    GLOBAL("global"),

    LESS_THEN_DAY("ltDay"),
    EQUALS_DAY("equalsDay"),
    GREATER_THEN_DAY("gtDay"),
    BETWEEN("between"),
    BETWEEN_DAY("betweenDay");

    private final String name;

    MatchMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MatchMode byName(String name) {
        for (MatchMode mode : MatchMode.values()) {
            if (mode.getName().equals(name)) {
                return mode;
            }
        }
        return null;
    }
}
