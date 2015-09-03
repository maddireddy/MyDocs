/**
 * SequenceNumberService.java
 * © Copyright 2011 Scope International
 */
package com.scb.einvoice.seqnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author 1394794
 */
public final class SequenceNumberService {

    /** Singleton Instance */
    public static final SequenceNumberService INSTANCE = new SequenceNumberService();
    private EInvoice eInvoice;

    private SequenceNumberService() {
        loadXML();
    }

    /**
     * 
     */
    private void loadXML() {
        try {
            final JAXBContext context = JAXBContext.newInstance("com.scb.einvoice.seqnum"); //$NON-NLS-1$
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            // TODO move the seq-number.xml to appropriate location (safe) and use the
            // FileInputStream from there
            // TODO dont forget to close the FIS
            eInvoice = (EInvoice) unmarshaller.unmarshal(new FileInputStream(new File(
                    "C:/Documents and Settings/1414588/seq-number.xml"))); //$NON-NLS-1$
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveXML() {
        try {
            final JAXBContext context = JAXBContext.newInstance("com.scb.einvoice.seqnum"); //$NON-NLS-1$
            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(
                    "C:/Documents and Settings/1414588/seq-number.xml"));
            marshaller.marshal(eInvoice, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param countryCode
     * @return the next sequence number
     */
    @SuppressWarnings("boxing")
    public String getNextSequenceNumber(final String countryCode) {
        StringBuilder  builder = new StringBuilder();
        String nextSequenceNumber = null;
        for (Country country : eInvoice.getCountries()) {
            if (country.getCountryCode().equals(countryCode)) {
                final String currSeq = country.getCurrentSeqNumber();
                nextSequenceNumber = String.format("%07d", Long.valueOf(currSeq) + 1); //$NON-NLS-1$
                builder.append(countryCode);
                builder.append("e"); //$NON-NLS-1$
                builder.append(nextSequenceNumber);
                country.setCurrentSeqNumber(nextSequenceNumber);
                break;
            }
        }
        return builder.toString();
    }
}
