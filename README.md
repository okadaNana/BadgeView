## BadgeView

类似 QQ、微信等 App 中的消息提醒的小红点

## 原理

### 背景圆角

继承于 `TextView`，调用 `setBackgroundDrawable(Drawable)` 设置背景颜色和圆角。具体实现看 `getDefaultBackground()` 方法

### 指定TargetView

将 BadgeView 从它的父 View 中 remove 掉，使用 FrameLayout 来代替 BadgeView 原来的位置，然后将 BadgeView 放进 FrameLayout 即可

## TODO

1. ~~显示数字~~
2. ~~指定TargetView~~
3. 不显示数字时就隐藏，同时提供隐藏、显示方法
4. 可在XML中配置
5. 可用代码配置
6. 可制定位置
7. 可指定背景颜色
8. 支持动画

## 感谢

* [android-viewbadger](https://github.com/jgilfelt/android-viewbadger)