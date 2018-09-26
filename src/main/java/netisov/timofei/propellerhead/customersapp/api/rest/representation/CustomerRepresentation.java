package netisov.timofei.propellerhead.customersapp.api.rest.representation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representation representation of a customer
 */
@ApiModel(value = "CustomerRepresentation", description = "CustomerRepresentation company")
public class CustomerRepresentation {

    @ApiModelProperty(value = "name", position = 10)
    private String name;

    @ApiModelProperty(value = "status", position = 20)
    private String status;

}
