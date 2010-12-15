package com.starillon.ibtradetools.listeners;

import com.google.inject.Inject;

import java.util.logging.Logger;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 12:36 PM
 */
public abstract class BaseDataListener implements DataListener {
    @Inject
    public Logger logger;

    @Override
    public final void onError(int errorCode, String errorMessage) {
        logger.severe("Unmatched error message : " + errorCode + " : " + errorMessage);
    }
}
