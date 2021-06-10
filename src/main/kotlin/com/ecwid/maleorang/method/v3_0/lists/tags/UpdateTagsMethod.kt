package com.ecwid.maleorang.method.v3_0.lists.tags

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import org.apache.commons.codec.digest.DigestUtils

/**
 * [Adds/removes tags from some subscriber](https://mailchimp.com/developer/marketing/api/list-member-tags/add-or-remove-member-tags/)
 * @author sporritt
 *
 * To use this class:
 *
 * val updater = new UpdateTagsMethod(listId, email, Array(new UpdateTagInfo("tagName", ACTIVE))
 * updater.execute()
 */
@Method(httpMethod = HttpMethod.POST, version = APIVersion.v3_0, path = "/lists/{list_id}/members/{subscriber_hash}/tags")
class UpdateTagsMethod(@JvmField @PathParam val list_id: String,
                       email: String,
                       @JvmField @Field val tags:Array<UpdateTagInfo> = arrayOf()) : MailchimpMethod<UpdateTagsMethod.Response>() {

    @JvmField
    @PathParam
    val subscriber_hash: String = DigestUtils.md5Hex(email.toLowerCase())

    class Response : MailchimpObject() { }

}
