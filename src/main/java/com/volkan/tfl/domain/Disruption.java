package com.volkan.tfl.domain;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

/**
 * Created by vcivelek on 24/08/16.
 */

@Table("disruption")
public class Disruption {

	@PrimaryKeyColumn(name = "id", type= PrimaryKeyType.PARTITIONED, ordinal = 0)
	private String id;

	@Column("start_date_time")
	private Date startdate;

	@Column("end_date_time")
	private Date enddate;

	@Column("latitude")
	private float latitude;

	@Column("longitude")
	private float longitude;

	@Column("severity")
	private String severity;

	public Disruption(String id, Date startdate, Date enddate, float latitude, float longitude, String severity) {
		this.id = id;
		this.startdate = startdate;
		this.enddate = enddate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.severity = severity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Disruption that = (Disruption) o;

		if (Float.compare(that.latitude, latitude) != 0)
			return false;
		if (Float.compare(that.longitude, longitude) != 0)
			return false;
		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null)
			return false;
		if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null)
			return false;
		return !(severity != null ? !severity.equals(that.severity) : that.severity != null);

	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
		result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
		result = 31 * result + (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
		result = 31 * result + (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
		result = 31 * result + (severity != null ? severity.hashCode() : 0);
		return result;
	}
}
