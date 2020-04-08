# Introduction

DAOパターン\*1を利用して、JavaのクラスとMariaDBのレコードを組み合わせたプログラムを作成した。

\*1 デザインパターンのひとつ。データベース専門のクラスを使用して、コード量を削減・より簡単にデータベースを利用できる。

# Background

今後、データベースとJavaサーブレット（あるいはフレームワーク）を利用した、自身の蔵書の情報を検索するWebアプリケーションを制作する予定である。<br>
そのための足がかりのひとつとして、まずデータベースに保存された情報をJavaのクラスで読み込み・表示する簡単なプログラムを作成しようと考えた。


# Learning in the repositry

- データベースの接続URLには、IPアドレスではなく"localhost"を利用したほうがよい。
あるいは127.0.0.1とする（localhostとほぼ同義）



# Prepare

- MariaDBでdb1というデータベースとbookテーブルを作成し、その中でbook.csvをインポートする。
カラム,型はそれぞれ<br>
title varchar(30), author varchar(30), publisher varchar(30)<br>
とする。<br>
インポートには以下のクエリを実行する。

```

load data infile "input URL" into table tb2 fields terminated by ",";
```

- 外部からデータベースに接続する許可を得るため、MariaDBに接続し、以下のクエリを実行する。

```
mysql> GRANT all ON *.* TO admin@'userName' IDENTIFIED BY 'password';     
```

- JDBCドライバを導入する

mariadb-java-client-2.5.2.jarをクラスパスに適用する。




# Development environment

- MariaDB 10.4.11
- JDK 10.0.2
