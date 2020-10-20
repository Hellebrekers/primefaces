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
package org.primefaces.expression.impl;

import org.primefaces.expression.MultiSearchExpressionResolver;
import org.primefaces.expression.SearchExpressionHint;
import org.primefaces.expression.SearchExpressionResolver;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Set;

/**
 * {@link SearchExpressionResolver} for the "@after" keyword.
 */
public class AfterExpressionResolver implements SearchExpressionResolver, MultiSearchExpressionResolver {

    @Override
    public UIComponent resolveComponent(FacesContext context, UIComponent source, UIComponent last, String expression,
                                        Set<SearchExpressionHint> hints) {
        UIComponent parent = last.getParent();
        List<UIComponent> siblings = parent.getChildren();
        if (siblings.indexOf(last) == siblings.size() - 1) {
            throw new FacesException("Invalid search expression - there's no successor to the component " + expression);
        }
        else {
            return siblings.get(siblings.indexOf(last) + 1);
        }
    }

    @Override
    public void resolveComponents(FacesContext context, UIComponent source, UIComponent last, String expression,
                                  List<UIComponent> components, Set<SearchExpressionHint> hints) {
        UIComponent parent = last.getParent();
        List<UIComponent> siblings = parent.getChildren();
        if (siblings.indexOf(last) == siblings.size() - 1) {
            throw new FacesException("Invalid search expression - there's no successor to the component " + expression);
        }
        else {
            for (int i = siblings.indexOf(last) + 1; i < siblings.size(); i++) {
                components.add(parent.getChildren().get(i));
            }
        }
    }

}
