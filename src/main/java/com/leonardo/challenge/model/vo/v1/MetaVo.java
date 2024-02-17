package com.leonardo.challenge.model.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaVo implements Serializable {

	private static final long serialVersionUID = 1L;

	public String versionId;
	public Date lastUpdated;
	public String source;

	public MetaVo() {
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lastUpdated, source, versionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaVo other = (MetaVo) obj;
		return Objects.equals(lastUpdated, other.lastUpdated) && Objects.equals(source, other.source) && Objects.equals(versionId, other.versionId);
	}

}
