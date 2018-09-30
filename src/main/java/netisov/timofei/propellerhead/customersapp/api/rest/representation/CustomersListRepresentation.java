package netisov.timofei.propellerhead.customersapp.api.rest.representation;

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
@ApiModel(value = "CustomersListRepresentation", description = "Customers list")
public class CustomersListRepresentation {

    @ApiModelProperty(value = "Total number of customers", example = "10", position = 10)
    private Long count;

    @ApiModelProperty(value = "Customers list", position = 20)
    private List<CustomerRepresentation> customers;

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    @Getter
    @ApiModel(value = "CustomerRepresentation", description = "CustomerRepresentation in the list")
    public static class CustomerRepresentation {

        @ApiModelProperty(value = "Identity", example = "1", position = 10)
        private Integer id;

        @ApiModelProperty(value = "Name", position = 20)
        private String name;

        @ApiModelProperty(value = "Creation date and time", example = "2018-10-01T00:00:00", position = 30)
        private LocalDateTime created;

        @ApiModelProperty(value = "Status", position = 30)
        private String status;

    }
}
