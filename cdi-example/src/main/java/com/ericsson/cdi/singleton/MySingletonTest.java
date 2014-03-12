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
package com.ericsson.cdi.singleton;

public class MySingletonTest {

    private static Runnable runnable = new Runnable() {

        @Override
        public void run() {
            MySingleton mySingleton = MySingleton.INSTANCE;
            mySingleton.helloWorld();
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(runnable).start();
        }
    }
}
