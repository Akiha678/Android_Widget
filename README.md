# CommonWidget

基于 Jetpack Compose 的企业级 Android 组件库，提供 Theme、Button、Dialog 等生产就绪的 UI 组件，以及网络与工具类模块。

## 模块

| 模块 | 说明 |
|------|------|
| `ui` | Compose UI 组件（Theme、Button、Dialog、Color、Shape） |
| `network` | 网络请求封装（规划中） |
| `utils` | 通用工具类（规划中） |


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

## 许可证

```
MIT License

Copyright (c) 2026 SeanChen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
