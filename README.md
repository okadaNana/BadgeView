## BadgeView

类似 QQ、微信等 App 中的消息提醒的小红点

## 原理

继承于 `TextView`，调用 `setBackgroundDrawable(Drawable)` 设置背景颜色和圆角

## TODO

1. ~~显示数字~~
2. 不显示数字时就隐藏，同时提供隐藏、显示方法
3. 可在XML中配置
4. 可用代码配置
5. 可制定位置
6. 可指定背景颜色
7. 支持动画

## 感谢

* [android-viewbadger](https://github.com/jgilfelt/android-viewbadger)