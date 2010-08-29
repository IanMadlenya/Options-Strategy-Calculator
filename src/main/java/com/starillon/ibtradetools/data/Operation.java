package com.starillon.ibtradetools.data;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 6:04:33 PM
 */
public enum Operation {
    UNKNOWN(-1),
    INSERT(0),
    UPDATE(1),
    DELETE(2);

    public static Operation valueOf(int operation) {
        return (operation == Operation.INSERT.operation) ? Operation.INSERT :
                (operation == Operation.UPDATE.operation) ? Operation.UPDATE :
                        (operation == Operation.DELETE.operation) ? DELETE : UNKNOWN;
    }

    Operation(int operation) {
        this.operation = operation;
    }

    private int operation;
}
