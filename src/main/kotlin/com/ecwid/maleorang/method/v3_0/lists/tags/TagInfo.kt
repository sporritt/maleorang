package com.ecwid.maleorang.method.v3_0.lists.tags

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Models a tag retrieved from the API
 * @author sporritt
 */
class TagInfo : MailchimpObject() {

    @JvmField
    @Field
    var id: Int? = null

    @JvmField
    @Field
    var name: String? = null

    @JvmField
    @Field
    var date_added: String? = null

}
