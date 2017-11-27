package com.mf.entity;

/**
 * Õº∆¨¿‡
 * 
 * @author MXY
 *
 */

public class Picture {

	private String PiId;
	private String PiTitle;
	private String PiType;
	private String PiBulider;
	private String PiBtime;
	private String Sketch;

	public String getPiId() {
		return PiId;
	}

	public void setPiId(String piId) {
		PiId = piId;
	}

	public String getPiTitle() {
		return PiTitle;
	}

	public void setPiTitle(String piTitle) {
		PiTitle = piTitle;
	}

	public String getPiType() {
		return PiType;
	}

	public void setPiType(String piType) {
		PiType = piType;
	}

	public String getPiBulider() {
		return PiBulider;
	}

	public void setPiBulider(String piBulider) {
		PiBulider = piBulider;
	}

	public String getPiBtime() {
		return PiBtime;
	}

	public void setPiBtime(String piBtime) {
		PiBtime = piBtime;
	}

	public String getSketch() {
		return Sketch;
	}

	public void setSketch(String sketch) {
		Sketch = sketch;
	}

	public Picture(String piId, String piTitle, String piType, String piBulider, String piBtime, String sketch) {
		super();
		PiId = piId;
		PiTitle = piTitle;
		PiType = piType;
		PiBulider = piBulider;
		PiBtime = piBtime;
		Sketch = sketch;
	}

	public Picture() {
		super();
	}

}