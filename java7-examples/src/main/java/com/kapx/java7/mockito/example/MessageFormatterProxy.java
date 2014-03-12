package com.kapx.java7.mockito.example;

public enum MessageFormatterProxy {
	INSTANCE;

	public static MessageFormatterProxy getInstance() {
		return INSTANCE;
	}

	public MsgFormatter getMsgFormatter() {
		MsgFormatter formatter = new MsgFormatter() {

			@Override
			public String format(String msg) {
				return "!!! " + msg + " !!!";
			}
		};

		return formatter;
	}
}
