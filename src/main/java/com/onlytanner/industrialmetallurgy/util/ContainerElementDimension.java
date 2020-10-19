package com.onlytanner.industrialmetallurgy.util;

public class ContainerElementDimension {

    public final int x;
    public final int y;
    public final int width;
    public final int height;
    public final int index;
    public final ElementType type;
    public final boolean isSlot;

    public ContainerElementDimension(int x, int y, int width, int height, int index, ElementType type, boolean isSlot) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.index = index;
        this.type = type;
        this.isSlot = isSlot;
    }

    public enum ElementType {
        FUEL,
        INPUT,
        OUTPUT,
        CONTAINER_INVENTORY,
        PLAYER_INVENTORY,
        BUTTON,
        LAYER_ELEMENT
    }

}
