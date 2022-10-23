package org.gavincui.imutest.biz;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractBaseController<D extends JpaRepository<M, String>, M extends InterfaceSetId> {
    @Resource
    private D dao;

    @GetMapping(value = "/list")
    List<M> list() {
        return dao.findAll();
    }

    @PostMapping
    void create(@RequestBody M model) {
        model.setId(UUID.randomUUID().toString());
        dao.save(model);
    }

    @PutMapping
    void update(@RequestBody M model) {
        dao.save(model);
    }

    @DeleteMapping(value = "/del/{id}")
    void del(@PathVariable String id) {
        dao.deleteById(id);
    }
}
