# Mugibow Watch Face

Pixel Watch 2 対応のカスタムウォッチフェイスプロジェクトです。
Watch Face Format (WFF) v2 を使用しており、Wear OS 4以降のデバイスで動作します。

## 対応デバイス

- Pixel Watch 2
- Pixel Watch 3
- Pixel Watch (初代)
- Galaxy Watch 4/5/6/7/Ultra
- その他 Wear OS 4+ 搭載のスマートウォッチ

## 必要な画像ファイル

`app/src/main/res/drawable/` フォルダに以下の画像を配置してください：

### 背景画像

| ファイル名 | サイズ | 説明 |
|-----------|--------|------|
| `background.png` | 450x450 px | メイン背景画像 |
| `preview.png` | 450x450 px | ウォッチフェイス選択画面のプレビュー |

### 数字画像（デジタル時計用）

| ファイル名 | 推奨サイズ | 説明 |
|-----------|----------|------|
| `digit_0.png` | 60x100 px | 数字 0 |
| `digit_1.png` | 60x100 px | 数字 1 |
| `digit_2.png` | 60x100 px | 数字 2 |
| `digit_3.png` | 60x100 px | 数字 3 |
| `digit_4.png` | 60x100 px | 数字 4 |
| `digit_5.png` | 60x100 px | 数字 5 |
| `digit_6.png` | 60x100 px | 数字 6 |
| `digit_7.png` | 60x100 px | 数字 7 |
| `digit_8.png` | 60x100 px | 数字 8 |
| `digit_9.png` | 60x100 px | 数字 9 |
| `digit_colon.png` | 30x100 px | コロン（:） |

**注意**: すべての数字画像は同じ高さにしてください。幅は異なっていても問題ありません。

## 画像作成のヒント

1. **透過PNGを使用**: 背景が透明なPNG画像を使うと綺麗に重なります
2. **円形にクロップ**: Pixel Watch 2 は円形ディスプレイなので、背景は円形で作成するとよいでしょう
3. **アンビエントモード対応**: バッテリー節約のため、アンビエントモードでは画像の明るさが自動的に下がります
4. **解像度**: 実際の Pixel Watch 2 は 384x384 ピクセルですが、WFF では 450x450 の座標系を使用します（自動スケーリング）

## ビルド方法

### 必要なもの

- Android Studio (最新版推奨)
- JDK 17 以上

### 手順

1. Android Studio でこのプロジェクトを開く
2. 画像ファイルを `app/src/main/res/drawable/` に配置
3. `Build > Build Bundle(s) / APK(s) > Build APK(s)` を実行
4. APK が `app/build/outputs/apk/` に生成されます

## インストール方法

### ADB を使用

```bash
# Pixel Watch を PC に接続（WiFi デバッグまたはUSB経由）
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Wear OS エミュレータ

1. Android Studio で Wear OS エミュレータを起動
2. エミュレータに APK をドラッグ＆ドロップ

## カスタマイズ

### watchface.xml の編集

メインの設定ファイルは `app/src/main/res/raw/watchface.xml` です。

#### 数字のサイズ変更

```xml
<BitmapFont name="custom_digits">
    <Character name="0" resource="digit_0" width="60" height="100" />
    <!-- width と height を調整 -->
</BitmapFont>
```

#### 時計の位置変更

```xml
<DigitalClock x="60" y="160" width="330" height="130">
    <!-- x, y を調整して位置を変更 -->
</DigitalClock>
```

#### 日付表示のオン/オフ

日付表示を無効にする場合は、`watchface.xml` 内の `PartText name="Date"` ブロックをコメントアウトしてください。

#### 秒表示の追加

`watchface.xml` 内のコメントアウトされた秒表示セクションのコメントを外すと、秒表示が追加されます（アンビエントモードでは非表示）。

## プロジェクト構成

```
mugibow-watchface/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml     # アプリ設定
│   │   └── res/
│   │       ├── drawable/           # 画像ファイル
│   │       ├── raw/
│   │       │   └── watchface.xml   # ウォッチフェイス定義
│   │       ├── values/
│   │       │   └── strings.xml     # 文字列リソース
│   │       └── xml/
│   │           └── watch_face_info.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

## 参考リンク

- [Watch Face Format 公式ドキュメント](https://developer.android.com/training/wearables/wff)
- [Watch Face Format セットアップ](https://developer.android.com/training/wearables/wff/setup)
- [BitmapFont リファレンス](https://developer.android.com/reference/wear-os/wff/group/part/text/bitmap-font)
- [Google Watch Face サンプル](https://github.com/google/watchface)

## ライセンス

MIT License
