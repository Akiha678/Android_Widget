<div align="center">
<img src="docs/images/xincomponent_logo.png" width="120" alt="Logo"/>

基于 Jetpack Compose 的企业级 Android 组件库

<div align="center">
    <a href="README_EN.md">🌍 English</a>
</div>

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-BOM%202026.02.01-4285F4?logo=jetpackcompose&logoColor=white)](https://developer.android.com/compose)

</div>

XinComponent是基于Jetpack Compose的多功能组件库，包含UI类、工具类、网络类，可快速构建美观、主题一致的Android应用，提供丰富的主题定制组件能力。



## 组件

### Theme

`AppTheme` 提供完整的明/暗主题支持，兼容 Material 3 设计系统。

```kotlin
@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    themeColor: Color = PrimaryDefault,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
)
```

### Button

```kotlin
@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.DEFAULT,
    style: ButtonStyle = ButtonStyle.FILLED,
    size: ButtonSize = ButtonSize.MEDIUM,
    shape: ButtonShape = ButtonShape.ROUND,
    enabled: Boolean = true,
    loading: Boolean = false,
    fullWidth: Boolean = true,
)
```

**使用示例**

```kotlin
AppButton(
    text = "提交",
    type = ButtonType.SUCCESS,
    style = ButtonStyle.GRADIENT,
    size = ButtonSize.MEDIUM,
    loading = isSubmitting,
    onClick = { /* 提交逻辑 */ }
)
```

### Dialog

标准对话框，支持标题、正文、自定义确认按钮颜色及取消回调。

```kotlin
@Composable
fun AppDialog(
    title: String,
    content: String? = null,
    okText: String = "确定",
    cancelText: String = "取消",
    okColor: Color = Color.Unspecified,
    onOk: () -> Unit,
    onCancel: (() -> Unit)? = null,
    onDismiss: () -> Unit,
)
```

**使用示例**

```kotlin
AppDialog(
    title = "确认删除",
    content = "删除后数据无法恢复，确定继续？",
    okText = "删除",
    okColor = ColorDanger,
    onOk = { /* 删除逻辑 */ },
    onCancel = { /* 取消 */ },
    onDismiss = { /* 关闭弹窗 */ }
)
```

## 构建

```bash
# 编译全部模块
./gradlew assemble

# 发布到本地 Maven
./gradlew publishToMavenLocal

# 发布到 GitHub Packages（需配置 GITHUB_USERNAME / GITHUB_TOKEN 环境变量）
./gradlew publish

# 运行测试
./gradlew test
```


