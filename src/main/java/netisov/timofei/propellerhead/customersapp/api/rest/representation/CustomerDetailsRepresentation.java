package netisov.timofei.propellerhead.customersapp.api.rest.representation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST Response class containing
 * customer details
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@ApiModel(value = "CustomerDetailsRepresentation", description = "Customer details representation")
public class CustomerDetailsRepresentation {
    @ApiModelProperty(value = "Identity", position = 10)
    private Integer id;

    @ApiModelProperty(value = "Name", position = 20)
    private String name;

    @ApiModelProperty(value = "Creation date and time", position = 30)
    private LocalDateTime created;

    @ApiModelProperty(value = "Status", position = 30)
    private String status;

    @ApiModelProperty(value = "Contact", position = 40)
    private String contact;

    @ApiModelProperty(value = "Notes", position = 50)
    private List<CustomerNoteRepresentation> notes;

    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    @Getter
    @ApiModel(value = "CustomerNoteRepresentation", description = "Customer note representation")
    public static class CustomerNoteRepresentation {

        @ApiModelProperty(value = "Identity", position = 10)
        private Integer id;

        @ApiModelProperty(value = "Content", position = 20)
        private String content;
    }

}
