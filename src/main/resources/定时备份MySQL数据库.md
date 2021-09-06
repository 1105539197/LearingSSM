####1. mysqldump常用操作示例

-  备份全部数据库的 数据 和 结构 
```
mysqldump -uroot -p123456 -A > /data/mysqlDump/mydb.sql
```
-  备份全部数据库的 结构（加 -d 参数）
```
mysqldump -uroot -p123456 -A -d > /data/mysqlDump/mydb.sql
```
-  备份全部数据库的 数据(加 -t 参数)
```
mysqldump -uroot -p123456 -A -t > /data/mysqlDump/mydb.sql
```
-  备份 单个 数据库的数据和结构(,数据库名mydb)
```
mysqldump -uroot-p123456 mydb > /data/mysqlDump/mydb.sql
```
-  备份 多个表 的数据和结构
```
mysqldump -uroot -p123456 mydb t1 t2 > /data/mysqlDump/mydb.sql
```
- 一次备份 多个数据库
```
mysqldump -uroot -p123456 --databases db1 db2 > /data/mysqlDump/mydb.sql
```
####2. 还原mysql备份内容
1. 在系统命令行中，输入如下实现还原：
mysql -uroot -p123456 < /data/mysqlDump/mydb.sql
2. 在登录进入mysql系统中,通过source指令找到对应系统中的文件进行还原：

mysql> source /data/mysqlDump/mydb.sql

####3. 脚本实例

```shell
#!/bin/bash
#保存备份个数，备份31天数据
number=31
#备份保存路径
backup_dir=/root/mysqlbackup
#日期
dd=`date +%Y-%m-%d-%H-%M-%S`
#备份工具
tool=mysqldump
#用户名
username=root
#密码
password=TankB214
#将要备份的数据库
database_name=edoctor

#如果文件夹不存在则创建
if [ ! -d $backup_dir ]; 
then     
    mkdir -p $backup_dir; 
fi

#简单写法  mysqldump -u root -p123456 users > /root/mysqlbackup/users-$filename.sql
$tool -u $username -p$password $database_name > $backup_dir/$database_name-$dd.sql

#写创建备份日志
echo "create $backup_dir/$database_name-$dd.dupm" >> $backup_dir/log.txt

#找出需要删除的备份
delfile=`ls -l -crt  $backup_dir/*.sql | awk '{print $9 }' | head -1`

#判断现在的备份数量是否大于$number
count=`ls -l -crt  $backup_dir/*.sql | awk '{print $9 }' | wc -l`

if [ $count -gt $number ]
then
  #删除最早生成的备份，只保留number数量的备份
  rm $delfile
  #写删除文件日志
  echo "delete $delfile" >> $backup_dir/log.txt
fi
```

####4.定时任务

定期执行编写的定时任务脚本（记得先给shell脚本执行权限）
```
0 2 * * * /root/mysql_backup_script.sh
```
