package com.ecwid.maleorang.examples;

import com.ecwid.maleorang.MailchimpClient;
import com.ecwid.maleorang.MailchimpObject;
import com.ecwid.maleorang.method.v3_0.lists.members.EditMemberMethod;
import com.ecwid.maleorang.method.v3_0.lists.members.MemberInfo;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Demonstrates how to use an existing method implementation (namely {@link com.ecwid.maleorang.method.v3_0.lists.members.EditMemberMethod.CreateOrUpdate}).
 */
public class ExistingMethodExample {

    private final String apiKey, listId;

    @Parameters({"mailchimp.test.apikey", "mailchimp.test.listid"})
    private ExistingMethodExample(String apiKey, String listId) {
        this.apiKey = apiKey;
        this.listId = listId;
    }

    /**
     * Subscribes a user to list.
     */
    //@Test
    public void subscribeUserToList() throws Exception {
        MailchimpClient client = new MailchimpClient(apiKey);
        try {
            EditMemberMethod.CreateOrUpdate method = new EditMemberMethod.CreateOrUpdate(listId, "vasya.pupkin@gmail.com");
            method.status = "subscribed";
            method.merge_fields = new MailchimpObject();
            method.merge_fields.mapping.put("FNAME", "Vasya");
            method.merge_fields.mapping.put("LNAME", "Pupkin");

            MemberInfo member = client.execute(method);
            System.err.println("The user has been successfully subscribed: " + member);
        } finally {
            client.close();
        }
    }

    /**
     * Subscribes a user to list.
     */
    @Test
    public void usingClientWithTimeOutParameters() throws Exception {
        Integer connectTimeOut = 15000;
        int socketTimeOut = 300000;
        int connectionRequestTimeOut = 15000;
        MailchimpClient client = new MailchimpClient(apiKey,connectTimeOut,socketTimeOut,connectionRequestTimeOut);
        try {
            EditMemberMethod.CreateOrUpdate method = new EditMemberMethod.CreateOrUpdate(listId, "vasya.pupkin@gmail.com");
            method.status = "subscribed";
            method.merge_fields = new MailchimpObject();
            method.merge_fields.mapping.put("FNAME", "Vasya");
            method.merge_fields.mapping.put("LNAME", "Pupkin");

            MemberInfo member = client.execute(method);

            System.out.println("Done fuckers");
            System.err.println("The user has been successfully subscribed: " + member);
        } finally {
            client.close();
        }
    }



}
