package com.raonsecure.sso;
// Generated 2019. 8. 26 ���� 8:55:47 by Hibernate Tools 5.4.3.Final

/**
 * Wa3OrgUserId generated by hbm2java
 */
public class Wa3OrgUserId implements java.io.Serializable {

	private String userId;
	private String orgId;

	public Wa3OrgUserId() {
	}

	public Wa3OrgUserId(String userId, String orgId) {
		this.userId = userId;
		this.orgId = orgId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Wa3OrgUserId))
			return false;
		Wa3OrgUserId castOther = (Wa3OrgUserId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getOrgId() == castOther.getOrgId()) || (this.getOrgId() != null
						&& castOther.getOrgId() != null && this.getOrgId().equals(castOther.getOrgId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getOrgId() == null ? 0 : this.getOrgId().hashCode());
		return result;
	}

}
