package gov.nysenate.openleg.service.log.event;

import gov.nysenate.openleg.model.auth.ApiRequest;
import gov.nysenate.openleg.model.auth.ApiResponse;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class ApiLogEvent
{
    private LocalDateTime logDateTime;
    private ApiResponse apiResponse;

    /** --- Constructors --- */

    public ApiLogEvent(ServletRequest servletRequest, ServletResponse servletResponse, LocalDateTime requestStart,
                       LocalDateTime requestEnd) {

        ApiRequest apiRequest = new ApiRequest((HttpServletRequest) servletRequest, requestStart);
        this.apiResponse = new ApiResponse(apiRequest, (HttpServletResponse) servletResponse, requestEnd);
        this.logDateTime = LocalDateTime.now();
    }

    /** --- Basic Getters --- */

    public LocalDateTime getLogDateTime() {
        return logDateTime;
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
