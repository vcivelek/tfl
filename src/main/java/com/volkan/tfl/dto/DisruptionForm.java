package com.volkan.tfl.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by vcivelek on 24/08/16.
 */
public class DisruptionForm {

	@NotEmpty
	private String startdate;
	@NotEmpty
	private String enddate;

	public DisruptionForm(String startdate, String enddate) {
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public DisruptionForm() {
		super();
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override public String toString() {
		return "DisruptionForm{" +
				"startdate='" + startdate + '\'' +
				", enddate='" + enddate + '\'' +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DisruptionForm that = (DisruptionForm) o;

		if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null)
			return false;
		return !(enddate != null ? !enddate.equals(that.enddate) : that.enddate != null);

	}

	@Override public int hashCode() {
		int result = startdate != null ? startdate.hashCode() : 0;
		result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
		return result;
	}

}
