package netisov.timofei.propellerhead.customersapp.api.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST Response class containing
 * total number of items and list of customers
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class CustomerListRepresentation {

    @ApiModelProperty(value = "Total number of customers", position = 10)
    private Long count;

    @ApiModelProperty(value = "Customers list", position = 20)
    private List<CustomerRepresentation> incidents;

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    @Getter
    @ApiModel(value = "CustomerRepresentation", description = "CustomerRepresentation in the list")
    public static class CustomerRepresentation {

        @ApiModelProperty(value = "Identity", position = 10)
        private Integer id;

        @ApiModelProperty(value = "Name", position = 20)
        private String name;

        @ApiModelProperty(value = "Creation date and time", position = 30)
        private LocalDateTime created;

    }
}
