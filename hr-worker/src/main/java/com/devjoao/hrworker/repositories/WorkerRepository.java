package com.devjoao.hrworker.repositories;

import com.devjoao.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
