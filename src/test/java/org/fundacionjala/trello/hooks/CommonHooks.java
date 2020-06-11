package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.api.RequestManager;
import org.fundacionjala.core.context.Context;
import org.fundacionjala.trello.utils.EndPointsEnum;

public final class CommonHooks {

    private static final int CLEAN_CONTEXT_ORDER = 20;
    private final Context context;
    private final RequestManager requestManager;

    public CommonHooks(final Context context, final RequestManager requestManager) {
        this.context = context;
        this.requestManager = requestManager;
    }

    /**
     * Deletes Items if they were created.
     */
    @After(value = "@cleanDataApi", order = CLEAN_CONTEXT_ORDER)
    public void cleanTestsData() {
        for (EndPointsEnum item : EndPointsEnum.values()) {
            context.getIdsByKey(item.toString()).forEach(id -> requestManager
                    .init(context)
                    .delete(item.getEndPoint().concat(id)));
        }
    }
}
