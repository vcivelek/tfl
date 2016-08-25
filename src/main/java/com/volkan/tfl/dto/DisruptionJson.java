package com.volkan.tfl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vcivelek on 25/08/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisruptionJson implements Serializable {
	private String id;
	private Date startDateTime;
	private Date endDateTime;
	private String severity;
	private String point;

	public String getId() {
		return id;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public String getSeverity() {
		return severity;
	}

	public String getPoint() {
		return point;
	}

	public Float getLatitude() {
		Pattern p = Pattern.compile("\\[(.*),(.*)\\]");
		Matcher m = p.matcher(point);
		if (m.find()) {
			return Float.valueOf(m.group(1));
		}
		return null;
	}

	public Float getLongitude() {
		Pattern p = Pattern.compile("\\[(.*),(.*)\\]");
		Matcher m = p.matcher(point);
		if (m.find()) {
			return Float.valueOf(m.group(2));
		}
		return null;
	}

	public DisruptionJson(String id, Date startDateTime, Date endDateTime, String severity, String point) {
		this.id = id;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.severity = severity;
		this.point = point;
	}

	public DisruptionJson() {
	}

	@Override public String toString() {
		return "DisruptionJson{" +
				"id='" + id + '\'' +
				", startDateTime=" + startDateTime +
				", endDateTime=" + endDateTime +
				", severity='" + severity + '\'' +
				", point='" + point + '\'' +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DisruptionJson that = (DisruptionJson) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;
		if (startDateTime != null ? !startDateTime.equals(that.startDateTime) : that.startDateTime != null)
			return false;
		if (endDateTime != null ? !endDateTime.equals(that.endDateTime) : that.endDateTime != null)
			return false;
		if (severity != null ? !severity.equals(that.severity) : that.severity != null)
			return false;
		return !(point != null ? !point.equals(that.point) : that.point != null);

	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (startDateTime != null ? startDateTime.hashCode() : 0);
		result = 31 * result + (endDateTime != null ? endDateTime.hashCode() : 0);
		result = 31 * result + (severity != null ? severity.hashCode() : 0);
		result = 31 * result + (point != null ? point.hashCode() : 0);
		return result;
	}
}
