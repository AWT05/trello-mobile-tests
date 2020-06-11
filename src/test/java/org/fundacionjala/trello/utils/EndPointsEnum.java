package org.fundacionjala.trello.utils;

public enum EndPointsEnum {
    BOARD("/boards/"),
    CARD("/cards/"),
    LIST("/lists/"),
    ORGANIZATION("/organizations/");

    private final String endPoint;

    /**
     * Set EndPointsEnum with specific data.
     *
     * @param endPoint for each enum.
     */
    EndPointsEnum(final String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Gets a specific endPoint.
     *
     * @return a string with endPoint.
     */
    public String getEndPoint() {
        return endPoint;
    }


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
