package org.fundacionjala.stepdefs;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.core.context.Context;
import org.fundacionjala.core.ui.driver.SharedDriver;
import org.fundacionjala.utils.EndPointsEnum;

import java.util.Map;

/**
 * Groups request step definitions.
 */
public final class ApiRequestStepDef {

    private static final String ID = "id";
    private final Context context;
    private final RequestManager requestManager;

    /**
     * Initializes an instance of RequestSteps class.
     *
     * @param sharedDriver   init driver.
     * @param context        scenario context.
     * @param requestManager helper to sending requests.
     */
    public ApiRequestStepDef(
            final SharedDriver sharedDriver,
            final Context context,
            final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Sets authentication header to base request specification.
     *
     * @param user to set the authentication.
     */
    @Given("I authenticate as {string}")
    public void setAuthentication(final String user) {
        requestManager.setApiCredentials(user);
    }

    @ParameterType("board|card|list|organization")
    public EndPointsEnum entity(final String entity) {
        return EndPointsEnum.valueOf(entity.toUpperCase());
    }

    /**
     * Sends POST request for required item.
     *
     * @param entity specific for endPointEnum.
     * @param params request parameters.
     */
    @Given("I create (a)(an) {entity} with:")
    public void iCreateAItemWith(final EndPointsEnum entity, final Map<String, String> params) {
        Response response = requestManager.init(context).queryParams(params).post(entity.getEndPoint());
        context.saveResponse(entity.toString(), response);
        context.saveIds(entity.toString(), response.jsonPath().getString(ID));
    }
}
