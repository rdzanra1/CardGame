package com.me.cardgame.Enums;

import javax.xml.bind.annotation.*;

@XmlType(name = "WallType")
@XmlEnum
public enum WallTypeEnum {

	OPEN(true), BLOCKED(true), NOTHING(false);

	public final Boolean IS_PASSSABLE;

	private WallTypeEnum(Boolean passability) {
		IS_PASSSABLE = passability;
	}

	public String value() {
		return name();
	}

	public static WallTypeEnum fromValue(String v) {
		return valueOf(v);
	}

}
