package uk.tw.energy.vo;

import lombok.Builder;
import lombok.Value;
import java.util.Date;

@Value
@Builder
public class RestApiResponse {
    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
