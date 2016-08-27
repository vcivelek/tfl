CREATE KEYSPACE tfl WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

CREATE TABLE tfl.disruption (
  id text,
  latitude float,
  longitude float,
  start_date_time timestamp,
  end_date_time timestamp,
  severity text,
  PRIMARY KEY(severity, end_date_time)
);
