# QRCode

* Encode
  * (String `内容`，String `QRCode 路径`)
  * (String `内容`，String `QRCode 路径`，String `Logo 路径`)
* Decode
  * (String `QRCode 路径`)

## Example

```java
encode("http://xhstormr.tk/", "D:/QRCode.png", "D:/Logo.png");
decode("D:/QRCode.png");
```

![](/assets/QRCode.png)
