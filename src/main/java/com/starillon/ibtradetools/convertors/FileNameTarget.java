/*
 * Copyright (c) 2010.  Starillon Pty Ltd
 */

package com.starillon.ibtradetools.convertors;

public class FileNameTarget implements Target
{
    String file;

    public FileNameTarget(String file)
    {
        this.file = file;
    }

    public String getFile()
    {
        return file;
    }
}
