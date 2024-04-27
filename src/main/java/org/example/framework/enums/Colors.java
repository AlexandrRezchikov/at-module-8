package org.example.framework.enums;

public enum Colors {

    GREY("rgba(220, 220, 220, 1)"),
    BLUE("rgba(0, 106, 208, 1)"),
    DARK_BLUE("rgba(5, 80, 152, 1)"),
    ORANGE("rgba(247, 129, 45, 1)"),
    RED("rgba(230, 79, 79, 1)"),
    DARK_ORANGE("rgba(233, 113, 28, 1)");

    private String rgba;

    Colors(String rgba) {
        this.rgba = rgba;
    }

    public String getRGBA() {
        return rgba;
    }
}
