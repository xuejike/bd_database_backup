#!/bin/sh
#对变量赋值：
host="-h $1 "
username=" -u$2 "
pwd="-p$3"
dbname=$4
file=$5

# 现在打印变量a的内容：

mysqldump $username $pwd $host $dbname > $file
exit $?



mysql