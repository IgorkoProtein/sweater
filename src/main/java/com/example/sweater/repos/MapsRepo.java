package com.example.sweater.repos;

import com.example.sweater.domain.Map;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapsRepo extends CrudRepository<Map, Long> {

    List<Map> findByDescription(String description);

}
