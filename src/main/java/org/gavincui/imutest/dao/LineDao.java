package org.gavincui.imutest.dao;

import org.gavincui.imutest.dao.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineDao extends JpaRepository<Line, String> {

}
