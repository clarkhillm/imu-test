package org.gavincui.imutest.dao;

import org.springframework.stereotype.Repository;
import org.gavincui.imutest.dao.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PositionDao extends JpaRepository<Position, String> {

}
