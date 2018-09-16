package fr.techad.edc.pages.editor;

public class BrickInfos {

	private static String strTitle;
	private static String strDesc;
	private static String strMainKey;
	private static String strSubKey;
	private static String strType;
	private static String strLink;

	public BrickInfos() {

	}

	public void setTitle(String strTitle) {
		BrickInfos.strTitle = strTitle;
	}

	public void setDesc(String strDesc) {
		BrickInfos.strDesc = strDesc;
	}

	public void setMainKey(String strMainKey) {
		BrickInfos.strMainKey = strMainKey;
	}

	public void setSubKey(String strSubKey) {
		BrickInfos.strSubKey = strSubKey;
	}

	public void setType(String strType) {
		BrickInfos.strType = strType;
	}
	
	public void setLink(String strLink) {
		BrickInfos.strLink = strLink;
	}

	public static String getTitle() {
		return strTitle;
	}

	public static String getDesc() {
		return strDesc;
	}

	public static String getMainKey() {
		return strMainKey;
	}

	public static String getSubKey() {
		return strSubKey;
	}

	public static String getType() {
		return strType;
	}
	
	public static String getLink() {
		return strLink;
	}
}
