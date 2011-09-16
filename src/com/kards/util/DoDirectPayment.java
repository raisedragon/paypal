/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kards.util;

/**
 *
 * @author aungthawaye
 */
import com.paypal.sdk.core.nvp.NVPDecoder;
import com.paypal.sdk.core.nvp.NVPEncoder;
import com.paypal.sdk.profiles.APIProfile;
import com.paypal.sdk.profiles.ProfileFactory;
import com.paypal.sdk.services.NVPCallerServices;
import com.paypal.sdk.util.TestConnection;
import com.paypal.sdk.util.Util;

/**
 * PayPal Java SDK sample code
 */
public class DoDirectPayment
{

    private NVPCallerServices caller = null;

    public String DoDirectPaymentCode(String paymentAction, String amount, String cardType,
                                      String acct, String expdate, String cvv2, String firstName,
                                      String lastName, String street, String city, String state,
                                      String zip, String countryCode)
    {
        NVPEncoder encoder = new NVPEncoder();
        NVPDecoder decoder = new NVPDecoder();

        try
        {

            caller = new NVPCallerServices();
            APIProfile profile = ProfileFactory.createSignatureAPIProfile();
            /*
            WARNING: Do not embed plaintext credentials in your application code.
            Doing so is insecure and against best practices.
            Your API credentials must be handled securely. Please consider
            encrypting them for use in any production environment, and ensure
            that only authorized individuals may view or modify them.
             */
            // Set up your API credentials, PayPal end point, API operation and version.
            profile.setAPIUsername("seller_1315906318_biz_api1.gmail.com");
            profile.setAPIPassword("1315906389");
            profile.setSignature("ADBMSIyTjrxgmHYa-L2K5yuzU80CAd1zuTQv2PTQp-vQyRQBw8GDYs2t");
            profile.setEnvironment("sandbox");
            profile.setSubject("");
            caller.setAPIProfile(profile);
            
            System.out.println("**DEBUG : Stage : " + Util.isStage(profile.getEnvironment()));
            
            // To test the connection to 
            System.out.println("**DEBUG : Testing the connection to PayPal.");
            TestConnection test = new TestConnection();
            test.testServerConnection(caller);
            System.out.println("**DEBUG : Finish testing the connection to PayPal.");

            encoder.add("VERSION", "58.0");
            encoder.add("METHOD", "DoDirectPayment");

            // Add request-specific fields to the request string.
            encoder.add("PAYMENTACTION", paymentAction);
            encoder.add("AMT", amount);
            encoder.add("CREDITCARDTYPE", cardType);
            encoder.add("ACCT", acct);
            encoder.add("EXPDATE", expdate);
            encoder.add("CVV2", cvv2);
            encoder.add("CURRENCYCODE", "USD");
            encoder.add("FIRSTNAME", firstName);
            encoder.add("LASTNAME", lastName);
            encoder.add("STREET", street);
            encoder.add("CITY", city);
            encoder.add("STATE", state);
            encoder.add("ZIP", zip);
            encoder.add("COUNTRYCODE", countryCode);

            // Execute the API operation and obtain the response.
            String NVPRequest = encoder.encode();
            System.out.println("**DEBUG : Request Param : " + NVPRequest);
            
            String NVPResponse = (String) caller.call(NVPRequest);
            decoder.decode(NVPResponse);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return decoder.get("ACK");
    }
}
