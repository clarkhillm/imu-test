package org.gavincui.imutest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PositionDao extends JpaRepository<Position, String> {

}
