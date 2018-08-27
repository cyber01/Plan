/*
 * License is provided in the jar as LICENSE also here:
 * https://github.com/Rsl1122/Plan-PlayerAnalytics/blob/master/Plan/src/main/resources/LICENSE
 */
package com.djrapitops.plan.system.webserver.pages;

import com.djrapitops.plan.api.exceptions.WebUserAuthException;
import com.djrapitops.plan.system.webserver.Request;
import com.djrapitops.plan.system.webserver.auth.Authentication;
import com.djrapitops.plan.system.webserver.cache.PageId;
import com.djrapitops.plan.system.webserver.cache.ResponseCache;
import com.djrapitops.plan.system.webserver.response.Response;
import com.djrapitops.plan.system.webserver.response.ResponseFactory;

import javax.inject.Inject;
import java.util.List;

/**
 * PageHandler for /players page.
 *
 * @author Rsl1122
 */
public class PlayersPageHandler implements PageHandler {

    private final ResponseFactory responseFactory;

    @Inject
    public PlayersPageHandler(ResponseFactory responseFactory) {
        this.responseFactory = responseFactory;
    }

    @Override
    public Response getResponse(Request request, List<String> target) {
        return ResponseCache.loadResponse(PageId.PLAYERS.id(), responseFactory::playersPageResponse);
    }

    @Override
    public boolean isAuthorized(Authentication auth, List<String> target) throws WebUserAuthException {
        return auth.getWebUser().getPermLevel() <= 1;
    }
}
