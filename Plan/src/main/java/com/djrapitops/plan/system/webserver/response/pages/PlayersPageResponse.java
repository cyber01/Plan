package com.djrapitops.plan.system.webserver.response.pages;

import com.djrapitops.plan.api.exceptions.ParseException;
import com.djrapitops.plan.system.webserver.response.Response;
import com.djrapitops.plan.system.webserver.response.errors.InternalErrorResponse;
import com.djrapitops.plan.utilities.html.pages.PlayersPage;
import com.djrapitops.plugin.api.utility.log.Log;

/**
 * @author Rsl1122
 * @since 3.5.2
 */
public class PlayersPageResponse extends Response {

    public PlayersPageResponse(PlayersPage playersPage) {
        super.setHeader("HTTP/1.1 200 OK");
        try {
            super.setContent(playersPage.toHtml());
        } catch (ParseException e) {
            Log.toLog(this.getClass(), e);
            setContent(new InternalErrorResponse("/players", e).getContent());
        }
    }
}
