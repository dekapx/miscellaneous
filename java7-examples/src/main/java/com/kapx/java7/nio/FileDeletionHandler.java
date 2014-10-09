/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.kapx.java7.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDeletionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileDeletionHandler.class);

    private String directoryPath;

    public FileDeletionHandler(final String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void deleteOlderFiles() {
        final File directory = new File(directoryPath);
        final String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            final File file = new File(files[i]);
            if (!file.isDirectory()) {
                boolean eligableForRemoval;
                try {
                    eligableForRemoval = fileEligableForRemoval(directory.getAbsolutePath(), file);
                    if (eligableForRemoval) {
                        LOGGER.info("########### File [{}] is older then 3 days and eligable for removal ###########", file.getName());
                        System.out.println("Removing this file, it's older then 3 days");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean fileEligableForRemoval(final String directory, final File file) throws IOException {
        final BasicFileAttributes fileAttributes = getFileAttributes(directory, file);

        final FileTime lastModifiedTime = fileAttributes.lastModifiedTime();

        final DateTime lastModifiedDate = new DateTime(lastModifiedTime.toMillis());
        LOGGER.info("Last modified date [{}] for File [{}]", lastModifiedDate, file.getName());

        final DateTime currentDate = new DateTime();
        final Days diff = Days.daysBetween(lastModifiedDate, currentDate);

        if (diff.getDays() > 3) {
            return true;
        } else {
            return false;
        }
    }

    private BasicFileAttributes getFileAttributes(final String directory, final File file) throws IOException {
        final Path path = Paths.get(directory, file.getName());
        final BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        return fileAttributes;
    }

    public static void main(String[] args) {
        final String directoryPath = "C:/ericsson/pmic/pm1";
        FileDeletionHandler deletionHandler = new FileDeletionHandler(directoryPath);
        deletionHandler.deleteOlderFiles();
    }
}
