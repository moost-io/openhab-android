/*
 * Copyright (c) 2010-2021 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.openhab.habdroid.model

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.openhab.habdroid.ui.MainActivity
import org.openhab.habdroid.util.optStringOrNull

@Parcelize
data class CloudNotificationAction internal constructor(
    val text: String?,
    val actionQualifier: String?,
    val isPositiveAction: Boolean? = false
) : Parcelable

fun JSONArray.toCloudNotificationActionList(): List<CloudNotificationAction> {
    return (0 until length()).mapNotNull { index ->
        var result: CloudNotificationAction? = null
        try {
            val cloudNotificationAction = getJSONObject(index).toCloudNotificationAction()
            result = cloudNotificationAction
        } catch (e: JSONException) {
            Log.d(Sitemap::class.java.simpleName, "Error while parsing sitemap", e)
        }
        result
    }
}

fun JSONObject.toCloudNotificationAction(): CloudNotificationAction? {
    val text = optStringOrNull("text") ?: return null
    val actionQualifier = optStringOrNull("actionQualifier")

    return CloudNotificationAction(text, actionQualifier)
}

fun CloudNotificationAction.toOpenHABActionIntent(): String {
    return when (actionQualifier) {
        "OpenRuleCreator" -> MainActivity.ACTION_RULECREATOR_SELECTED
        "OpenDeviceControl" -> MainActivity.ACTION_SITEMAP_SELECTED
        else -> MainActivity.ACTION_DISMISS_NOTIFICATION
    }
}
