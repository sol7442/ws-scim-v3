package com.raonsecure.sso;
// Generated 2019. 8. 26 ���� 8:55:47 by Hibernate Tools 5.4.3.Final

/**
 * Wa3Org generated by hbm2java
 */
public class Wa3Org implements java.io.Serializable {

	private String id;
	private String name;
	private String creator;
	private String modifier;
	private String info;
	private String parentId;
	private String pathId;
	private Long loginPolicyId;
	private Long createTime;
	private Long modifyTime;
	private Integer orderNum;

	public Wa3Org() {
	}

	public Wa3Org(String id, String name, String parentId, String pathId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.pathId = pathId;
	}

	public Wa3Org(String id, String name, String creator, String modifier, String info, String parentId, String pathId,
			Long loginPolicyId, Long createTime, Long modifyTime, Integer orderNum) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.modifier = modifier;
		this.info = info;
		this.parentId = parentId;
		this.pathId = pathId;
		this.loginPolicyId = loginPolicyId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.orderNum = orderNum;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPathId() {
		return this.pathId;
	}

	public void setPathId(String pathId) {
		this.pathId = pathId;
	}

	public Long getLoginPolicyId() {
		return this.loginPolicyId;
	}

	public void setLoginPolicyId(Long loginPolicyId) {
		this.loginPolicyId = loginPolicyId;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

}