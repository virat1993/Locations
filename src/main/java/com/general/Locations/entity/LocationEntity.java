package com.general.Locations.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity implements Serializable {

    private static final long serialVersionUID =1l;

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    public int locationId;

    @Column(name = "location_coordinates")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    public Point geometricLocation;

    @Column(name = "longitude")
    public Double longitude;

    @Column(name = "latitude")
    public Double latitude;

    @Column(name = "locationName")
    public String locationName;
}
