package com.general.Locations.dto.location;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateDto {

    public Integer locationId;
    public Double latitude;
    public Double longitude;
    public String locationName;
}
