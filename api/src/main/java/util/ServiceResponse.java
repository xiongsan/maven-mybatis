package util;

import lombok.Data;

/**
 * Created by Wanghairui on 2017/6/9.
 */
@Data
public class ServiceResponse {
    String status;
    Object data;
    String tips;
}
