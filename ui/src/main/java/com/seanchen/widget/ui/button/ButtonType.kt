package com.seanchen.widget.ui.button

enum class ButtonType {
    /**
     * 默认蓝色主题按钮
     */
    DEFAULT,

    /**
     * 成功绿色按钮
     */
    SUCCESS,

    /**
     * 警告黄色按钮
     */
    WARNING,

    /**
     * 危险红色按钮
     */
    DANGER,

    /**
     * 紫色按钮
     */
    PURPLE,

    /**
     * 链接按钮
     */
    LINK
}

enum class ButtonStyle {
    /**
     * 填充样式
     */
    FILLED,

    /**
     * 轮廓样式
     */
    OUTLINED,

    /**
     * 渐变样式
     */
    GRADIENT,
}

/**
 * 按钮大小
 */
enum class ButtonSize {
    /**
     * 中等尺寸按钮 - 高度48dp
     */
    MEDIUM,

    /**
     * 小尺寸按钮 - 高度40dp
     */
    SMALL,

    /**
     * 迷你尺寸 - 高度32dp
     */
    MINI
}

/**
 * 按钮形状
 */
enum class ButtonShape {
    /**
     * 方形按钮
     */
    SQUARE,

    /**
     * 圆形按钮
     */
    ROUND
}