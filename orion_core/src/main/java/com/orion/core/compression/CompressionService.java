package com.orion.core.compression;

import com.orion.core.abstraction.OrionService;
import com.orion.core.compression.zip.ZIPCompressionService;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

public class CompressionService extends OrionService
{
    public static void compressToZIPAsStream(String tempFolder, Set<File> filesToCompress, OutputStream output, boolean deleteFilesAfterCompression) throws IOException
    {
        ZIPCompressionService.compressAsStream(tempFolder, filesToCompress, output, deleteFilesAfterCompression);
    }
}