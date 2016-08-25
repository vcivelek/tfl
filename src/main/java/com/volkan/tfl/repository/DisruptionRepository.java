package com.volkan.tfl.repository;

import com.volkan.tfl.domain.Disruption;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

/**
 * Created by vcivelek on 24/08/16.
 */
public interface DisruptionRepository extends CassandraRepository<Disruption> {
	// TODO: add a function that takes start and end date
	@Query("select * from disruption order by end_date_time desc limit ?1")
	public List<Disruption> findLastN(Integer count);
}
