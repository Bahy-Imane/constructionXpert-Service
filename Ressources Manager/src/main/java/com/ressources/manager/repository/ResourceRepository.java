package com.ressources.manager.repository;

import com.ressources.manager.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
   List<Resource> getResourcesByTaskId(Long taskId);
}
