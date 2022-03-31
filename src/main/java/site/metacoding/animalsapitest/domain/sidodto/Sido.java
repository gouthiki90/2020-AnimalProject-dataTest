package site.metacoding.animalsapitest.domain.sidodto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sido {

    private Response response;

    @AllArgsConstructor
    @Data
    class Response {

        private Header header;
        private Body body;

        @AllArgsConstructor
        @Data
        class Header {

            private String reqNo;
            private String resultCode;
            private String resultMsg;
        }

        @AllArgsConstructor
        @Data
        class Body {

            private Items items;
            private Integer numOfRows;
            private Integer pageNo;
            private Integer totalCount;

            @AllArgsConstructor
            @Data
            class Items {

                private List<Item> item;

                @AllArgsConstructor
                @Data
                class Item {

                    private String orgCd;
                    private String orgdownNm;
                }
            }
        }
    }

}