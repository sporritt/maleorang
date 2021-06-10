package com.ecwid.maleorang.method.v3_0.lists.tags

import com.ecwid.maleorang.MailchimpMethod
import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.*
import org.apache.commons.codec.digest.DigestUtils

/**
 * [Get a list of all tags for a subscriber](https://mailchimp.com/developer/marketing/api/list-member-tags/list-member-tags/)
 * @author sporritt
 */
@Method(httpMethod = HttpMethod.GET, version = APIVersion.v3_0, path = "/lists/{list_id}/members/{subscriber_hash}/tags")
class GetTagsMethod(@JvmField @PathParam val list_id: String, email: String) : MailchimpMethod<GetTagsMethod.Response>() {

    @JvmField
    @PathParam
    val subscriber_hash: String = DigestUtils.md5Hex(email.toLowerCase())

    @JvmField
    @QueryStringParam
    var fields: String? = null

    @JvmField
    @QueryStringParam
    var exclude_fields: String? = null

    @JvmField
    @QueryStringParam
    var count: Int? = null

    @JvmField
    @QueryStringParam
    var offset: Int? = null

    class Response : MailchimpObject() {
        @JvmField
        @Field
        var tags: List<TagInfo>? = null

        @JvmField
        @Field
        var list_id: String? = null

        @JvmField
        @Field
        var total_items: Int? = null
    }

}
