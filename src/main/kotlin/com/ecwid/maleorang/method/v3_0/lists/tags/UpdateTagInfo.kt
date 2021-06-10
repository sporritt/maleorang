package com.ecwid.maleorang.method.v3_0.lists.tags

import com.ecwid.maleorang.MailchimpObject
import com.ecwid.maleorang.annotation.Field

/**
 * Models an update to a tag - either adding one or removing one, it depends on the `status`.
 * @sporritt
 */
class UpdateTagInfo(@JvmField @Field val name:String, @JvmField @Field val status:TagStatus) : MailchimpObject() { }
