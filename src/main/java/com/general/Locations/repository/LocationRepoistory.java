package com.general.Locations.repository;

import com.general.Locations.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepoistory extends JpaRepository<LocationEntity, Integer> {
}
