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

package org.openhab.habdroid.ui.activity

import org.openhab.habdroid.R
import org.openhab.habdroid.ui.MainActivity

class RuleCreatorWebViewFragment : AbstractWebViewFragment() {
    override val titleRes = R.string.mainmenu_openhab_rulecreator_ui
    override val multiServerTitleRes = R.string.mainmenu_openhab_rulecreator_ui_on_server
    override val errorMessageRes = R.string.rulecreator_error
    override val urlToLoad = "/settings/rules/add"
    override val urlForError = "/rest/rules"
    override val lockDrawer = true
    override val shortcutIcon = R.mipmap.ic_shortcut_habpanel
    override val shortcutAction = MainActivity.ACTION_HABPANEL_SELECTED
}
