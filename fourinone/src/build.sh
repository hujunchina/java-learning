#./build.sh
#!/bin/sh
#set -x
javac -d class com/fourinone/*.java
cp com/fourinone/config_en_US.properties class/META-INF
cp com/fourinone/fttp.jsp class/WEB-INFO
cp com/fourinone/err401.jsp class/WEB-INFO
cp com/fourinone/err404.jsp class/WEB-INFO
cp com/fourinone/fttp.js class/WEB-INFO
#copy com/fourinone/*.java class/com/fourinone/
cd class
jar -cf fourinone.jar META-INF WEB-INFO com/fourinone/*.*
cd ..
