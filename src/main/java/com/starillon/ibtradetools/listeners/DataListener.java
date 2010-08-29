package com.starillon.ibtradetools.listeners;

import java.util.EventListener;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 7:58:27 PM
 */
public interface DataListener extends EventListener {
    void onError(int errorCode, String errorMessage);
}
