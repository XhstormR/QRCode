# QRCode

* Encode
  * (String `内容`，String `QRCode 路径`)
  * (String `内容`，String `QRCode 路径`，String `Logo 路径`)
* Decode
  * (String `QRCode 路径`)

## Example

```java
Encode("http://xhstormr.tk/", "D:/QRCode.png", "D:/Logo.png");
Decode("D:/QRCode.png");
```

![](/assets/QRCode.png)
