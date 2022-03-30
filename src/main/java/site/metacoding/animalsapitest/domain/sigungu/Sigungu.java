package site.metacoding.animalsapitest.domain.sigungu;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sigungu {

    private Response response;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Response {

        private Header Header;
        private Body body;

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        class Header {
            private String reqNo;
            private String resultCode;
            private String resultMsg;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        class Body {
            private Items Item;

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            class Items {
                private List<Item> Items;

                private Integer numOfRows;
                private Integer pageNo;
                private Integer totalCount;

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                class Item {
                    private String orgCd;
                    private String orgdownNm;
                }
            }

        }
    }

}
