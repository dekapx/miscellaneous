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

public class BasicFileAttributesExample {
    public static void main(String[] args) throws IOException {
        final String directoryPath = "C:/ericsson/pmic/pm1";
        final File directory = new File(directoryPath);
        final String[] files = directory.list();
        for (int i = 0; i < files.length; i++) {
            File file = new File(files[i]);
            if (!file.isDirectory()) {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println(file.getName());
                boolean eligableForRemoval = fileEligableForRemoval(directory.getAbsolutePath(), file);
                if (eligableForRemoval) {
                    System.out.println("Remove this file, it's older then 3 days");
                }
            }
        }
    }

    private static boolean fileEligableForRemoval(final String directory, final File file) throws IOException {
        final BasicFileAttributes fileAttributes = getFileAttributes(directory, file);

        FileTime lastModifiedTime = fileAttributes.lastModifiedTime();

        DateTime lastModifiedDate = new DateTime(lastModifiedTime.toMillis());
        System.out.println("Last Modified Date: " + lastModifiedDate);

        DateTime currentDate = new DateTime();
        System.out.println("Current Date: " + currentDate);

        Days diff = Days.daysBetween(lastModifiedDate, currentDate);
        System.out.println("Days Diff: " + diff.getDays());

        if (diff.getDays() > 3) {
            return true;
        } else {
            return false;
        }
    }

    private static BasicFileAttributes getFileAttributes(final String directory, final File file) throws IOException {
        final Path path = Paths.get(directory, file.getName());
        final BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        return fileAttributes;
    }
}
