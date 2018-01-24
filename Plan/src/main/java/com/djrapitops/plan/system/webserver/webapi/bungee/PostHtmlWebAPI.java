/*
 * Licence is provided in the jar as license.yml also here:
 * https://github.com/Rsl1122/Plan-PlayerAnalytics/blob/master/Plan/src/main/resources/license.yml
 */
package com.djrapitops.plan.system.webserver.webapi.bungee;

import com.djrapitops.plan.PlanPlugin;
import com.djrapitops.plan.api.exceptions.connection.WebException;
import com.djrapitops.plan.system.webserver.response.Response;
import com.djrapitops.plan.system.webserver.webapi.WebAPI;

import java.util.Map;
import java.util.UUID;

/**
 * WebAPI for posting Html pages such as Inspect or server pages.
 *
 * @author Rsl1122
 */
@Deprecated
public class PostHtmlWebAPI extends WebAPI {

    @Override
    public Response onRequest(PlanPlugin plugin, Map<String, String> variables) {
        return fail("Deprecated");
    }

    @Override
    public void sendRequest(String address) throws WebException {
        throw new IllegalStateException("Wrong method call for this WebAPI, call sendRequest(String, UUID, UUID) instead.");
    }

    public void sendInspectHtml(String address, UUID uuid, String html) throws WebException {
        addVariable("uuid", uuid.toString());
        addVariable("target", "inspectPage");
        addVariable("html", html);
        super.sendRequest(address);
    }

    public void sendAnalysisHtml(String address, String html) throws WebException {
        addVariable("html", html);
        addVariable("target", "analysisPage");
        super.sendRequest(address);
    }
}