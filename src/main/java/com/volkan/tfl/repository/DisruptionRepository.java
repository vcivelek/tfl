package com.volkan.tfl.repository;

import com.volkan.tfl.domain.Disruption;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by vcivelek on 24/08/16.
 */
public interface DisruptionRepository extends CassandraRepository<Disruption> {
	@Query("select * from disruption order by end_date_time desc limit ?0")
	public List<Disruption> findLastN(Integer count);

	@Query("select * from disruption where severity = ?0")
	public List<Disruption> findBySeverity(String severity);

	@Query("select * from disruption where end_date_time > ?0 ALLOW FILTERING")
	public List<Disruption> findAllByEnddate(String enddate);

	@Query("select * from disruption where severity = ?0 AND end_date_time > ?1")
	public List<Disruption> findBySeverityAndEnddate(String severity, String enddate);

}
