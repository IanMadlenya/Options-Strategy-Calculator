package com.starillon.ibtradetools.util;

import com.google.inject.Singleton;

@Singleton
public class RequestIdGeneratorImpl implements RequestIdGenerator {
    private int current = 0;

    @Override
    public int nextValue() {
        return current++;
    }
}
