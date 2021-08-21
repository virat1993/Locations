package com.general.Locations.dto.location;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDto {

    public Double latitude;
    public Double longitude;
    public String locationName;
}
