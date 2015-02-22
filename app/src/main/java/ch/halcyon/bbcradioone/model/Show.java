package ch.halcyon.bbcradioone.model;

/**
 * Created by yannick on 10/02/15.
 */

public class Show {
    private Number total;

    private Results results;

    private String responseStatus;

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}