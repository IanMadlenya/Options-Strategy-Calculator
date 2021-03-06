package com.starillon.ibtradetools.listeners;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 12:29 PM
 */
@BindingAnnotation
@Target({FIELD, PARAMETER, METHOD})
@Retention(RUNTIME)
public @interface UnmatchedMarketData {
}
