package com.volkan.tfl.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by vcivelek on 24/08/16.
 */
public class DisruptionForm {

	@NotEmpty
	private String severity;
	@NotEmpty
	private String enddate;
	
	public DisruptionForm(String severity, String enddate) {
		this.severity = severity;
		this.enddate = enddate;
	}

	public DisruptionForm() {
		super();
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override public String toString() {
		return "DisruptionForm{" +
				"severity='" + severity + '\'' +
				", enddate='" + enddate + '\'' +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DisruptionForm that = (DisruptionForm) o;

		if (severity != null ? !severity.equals(that.severity) : that.severity != null)
			return false;
		return !(enddate != null ? !enddate.equals(that.enddate) : that.enddate != null);

	}

	@Override public int hashCode() {
		int result = severity != null ? severity.hashCode() : 0;
		result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
		return result;
	}

}
