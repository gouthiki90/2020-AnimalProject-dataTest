package site.metacoding.animalsapitest.domain.sidorest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {
    
    private Header header;
    private Body body;
}
