package de.neosearch.verweiserkennung.rest.controller;

public class AnnotationRequest {
	private String text;
	private String targetPlatform; // urteile-gesetze (default) oder opendata

	public String getText() {
		return text;
	}

	public String getTargetPlatform() {
		return targetPlatform;
	}

	public void setTargetPlatform(String targetPlatform) {
		this.targetPlatform = targetPlatform;
	}

	public void setText(String text) {
		this.text = text;
	}
}
