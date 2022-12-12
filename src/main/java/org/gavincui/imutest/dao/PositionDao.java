package org.gavincui.imutest.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.gavincui.imutest.dao.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PositionDao extends JpaRepository<Position, String> {

    @Query("select obj from Position obj where obj.lineId=?1")
    List<Position> queryByLineId(String lineId);

}
