package org.test;

import com.scb.einvoice.seqnum.SequenceNumberService;

/**
 * @author 1394794
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out
                    .println("HEHE ::: " + SequenceNumberService.INSTANCE.getNextSequenceNumber("US")); //$NON-NLS-1$ //$NON-NLS-2$
        }
        SequenceNumberService.INSTANCE.saveXML();
    }
}
